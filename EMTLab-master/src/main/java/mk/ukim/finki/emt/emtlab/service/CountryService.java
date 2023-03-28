package mk.ukim.finki.emt.emtlab.service;

import mk.ukim.finki.emt.emtlab.models.Book;
import mk.ukim.finki.emt.emtlab.models.Country;
import mk.ukim.finki.emt.emtlab.models.dto.BookDto;
import mk.ukim.finki.emt.emtlab.models.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> findById(Long id);

    List<Country> listAll();

    Optional<Country> editCountry(Long id, CountryDto countryDto);


    Optional<Country> addNewCountry(CountryDto countryDto);

    void deleteById(Long id);

}
