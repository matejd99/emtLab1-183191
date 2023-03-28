package mk.ukim.finki.emt.emtlab.service;

import mk.ukim.finki.emt.emtlab.models.Author;
import mk.ukim.finki.emt.emtlab.models.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

    Optional<Author> addNewAuthor(AuthorDto authorDto);

    void deleteById(Long id);

}
