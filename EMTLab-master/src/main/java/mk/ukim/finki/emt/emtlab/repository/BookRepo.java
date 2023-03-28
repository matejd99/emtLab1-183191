package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
