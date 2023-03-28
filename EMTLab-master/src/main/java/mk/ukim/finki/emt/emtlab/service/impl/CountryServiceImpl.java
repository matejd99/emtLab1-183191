package mk.ukim.finki.emt.emtlab.service.impl;

import mk.ukim.finki.emt.emtlab.exception.InvalidBookIdException;
import mk.ukim.finki.emt.emtlab.exception.InvalidCountryIdException;
import mk.ukim.finki.emt.emtlab.exception.invalidAuthorException;
import mk.ukim.finki.emt.emtlab.models.Book;
import mk.ukim.finki.emt.emtlab.models.Country;
import mk.ukim.finki.emt.emtlab.models.dto.BookDto;
import mk.ukim.finki.emt.emtlab.models.dto.CountryDto;
import mk.ukim.finki.emt.emtlab.repository.CountryRepo;
import mk.ukim.finki.emt.emtlab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepo countryRepo;

    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepo.findById(id);
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepo.findAll();
    }

    @Override
    public Optional<Country> addNewCountry(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(),countryDto.getContinent());
        return Optional.of(this.countryRepo.save(country));
    }

    @Override
    public Optional<Country> editCountry(Long id, CountryDto countryDto) {
        Country country = this.countryRepo.findById(id).orElseThrow(InvalidCountryIdException::new);
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return Optional.of(this.countryRepo.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepo.deleteById(id);
    }
}
