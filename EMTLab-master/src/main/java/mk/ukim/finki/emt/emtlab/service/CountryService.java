package mk.ukim.finki.emt.emtlab.service;

import mk.ukim.finki.emt.emtlab.models.Country;
import mk.ukim.finki.emt.emtlab.models.dto.CountryDto;

import java.util.Optional;

public interface CountryService {

    Optional<Country> findById(Long id);

    Optional<Country> addNewCountry(CountryDto countryDto);

    void deleteById(Long id);

}
