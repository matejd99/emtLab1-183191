package mk.ukim.finki.emt.emtlab.web;

import mk.ukim.finki.emt.emtlab.models.Author;
import mk.ukim.finki.emt.emtlab.models.Book;
import mk.ukim.finki.emt.emtlab.models.Country;
import mk.ukim.finki.emt.emtlab.models.dto.BookDto;
import mk.ukim.finki.emt.emtlab.models.dto.CountryDto;
import mk.ukim.finki.emt.emtlab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping({"/countries"})
    public List<Country> getAll(){
        return this.countryService.listAll();
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id){
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/countries/add")
    public ResponseEntity<Country> addNewCountry(@RequestBody CountryDto countryDto){
       return this.countryService.addNewCountry(countryDto)
               .map(country -> ResponseEntity.ok().body(country))
               .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/countries/edit/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id, @RequestBody CountryDto countryDto){
        return this.countryService.editCountry(id, countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/countries/delete/{id}")
    public ResponseEntity deleteCountry(@PathVariable Long id){
        this.countryService.deleteById(id);
        if(this.countryService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
