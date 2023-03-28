package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long>{
}
