package mk.ukim.finki.emt.emtlab.service.impl;

import mk.ukim.finki.emt.emtlab.models.Author;
import mk.ukim.finki.emt.emtlab.models.dto.AuthorDto;
import mk.ukim.finki.emt.emtlab.exception.InvalidCountryIdException;
import mk.ukim.finki.emt.emtlab.repository.AuthorRepo;
import mk.ukim.finki.emt.emtlab.repository.CountryRepo;
import mk.ukim.finki.emt.emtlab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final CountryRepo countryRepo;


    public AuthorServiceImpl(AuthorRepo authorRepo, CountryRepo countryRepo) {
        this.authorRepo = authorRepo;
        this.countryRepo = countryRepo;
    }


    @Override
    public List<Author> listAll() {
        return this.authorRepo.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepo.findById(id);
    }

    @Override
    public Optional<Author> addNewAuthor(AuthorDto authorDto) {
        Author author = new Author(authorDto.getName(),authorDto.getSurname(),
                this.countryRepo.findById(authorDto.getCountry()).orElseThrow(InvalidCountryIdException::new));
        return Optional.of(this.authorRepo.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepo.deleteById(id);
    }
}
