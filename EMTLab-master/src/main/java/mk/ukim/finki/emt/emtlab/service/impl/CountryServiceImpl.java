package mk.ukim.finki.emt.emtlab.service.impl;

import mk.ukim.finki.emt.emtlab.models.Country;
import mk.ukim.finki.emt.emtlab.models.dto.CountryDto;
import mk.ukim.finki.emt.emtlab.repository.CountryRepo;
import mk.ukim.finki.emt.emtlab.service.CountryService;
import org.springframework.stereotype.Service;

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
    public Optional<Country> addNewCountry(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(),countryDto.getContinent());
        return Optional.of(this.countryRepo.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepo.deleteById(id);
    }
}
