package mk.ukim.finki.emt.emtlab.web;

import mk.ukim.finki.emt.emtlab.models.Author;
import mk.ukim.finki.emt.emtlab.models.Book;
import mk.ukim.finki.emt.emtlab.models.Country;
import mk.ukim.finki.emt.emtlab.models.dto.AuthorDto;
import mk.ukim.finki.emt.emtlab.models.dto.CountryDto;
import mk.ukim.finki.emt.emtlab.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping({"/","/authors"})
    public List<Author> getAll(){
        return this.authorService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/authors/add")
    public ResponseEntity<Author> addNewAuthor(@RequestBody AuthorDto authorDto) {
        return this.authorService.addNewAuthor(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/authors/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return this.authorService.editAuthor(id, authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        this.authorService.deleteById(id);
        if(this.authorService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
