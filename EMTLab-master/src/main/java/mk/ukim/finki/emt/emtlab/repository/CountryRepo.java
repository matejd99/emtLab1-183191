package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {
}
