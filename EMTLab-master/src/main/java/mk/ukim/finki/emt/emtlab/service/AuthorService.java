package mk.ukim.finki.emt.emtlab.service;

import mk.ukim.finki.emt.emtlab.models.Author;
import mk.ukim.finki.emt.emtlab.models.Book;
import mk.ukim.finki.emt.emtlab.models.dto.AuthorDto;
import mk.ukim.finki.emt.emtlab.models.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

    Optional<Author> editAuthor(Long id, AuthorDto authorDto);


    Optional<Author> addNewAuthor(AuthorDto authorDto);

    void deleteById(Long id);

}
