package mk.ukim.finki.emt.emtlab.service.impl;

import mk.ukim.finki.emt.emtlab.models.Author;
import mk.ukim.finki.emt.emtlab.models.Book;
import mk.ukim.finki.emt.emtlab.models.dto.BookDto;
import mk.ukim.finki.emt.emtlab.exception.invalidAuthorException;
import mk.ukim.finki.emt.emtlab.exception.InvalidBookIdException;
import mk.ukim.finki.emt.emtlab.repository.AuthorRepo;
import mk.ukim.finki.emt.emtlab.repository.BookRepo;
import mk.ukim.finki.emt.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookServiceImpl(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepo.findById(id);
    }

    @Override
    public Optional<Book> addNewBook(BookDto bookDto) {
        Author author = this.authorRepo.findById(bookDto.getAuthor()).orElseThrow(invalidAuthorException::new);
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepo.save(book));
    }

    @Override
    public Optional<Book> editBook(Long id, BookDto bookDto) {
        Book book = this.bookRepo.findById(id).orElseThrow(InvalidBookIdException::new);
        book.setName(bookDto.getName());
        book.setAuthor(this.authorRepo.findById(bookDto.getAuthor()).orElseThrow(invalidAuthorException::new));
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepo.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepo.deleteById(id);
    }

    @Override
    public boolean markAsTaken(Long id) {
        Book book = this.bookRepo.findById(id).orElseThrow(InvalidBookIdException::new);
        if(book.getAvailableCopies()==0){
            return false;
        }
        book.setAvailableCopies((book.getAvailableCopies()));
        this.bookRepo.save(book);
        return true;
    }
}
