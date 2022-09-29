package nl.fhict.s3.hsdm.repositories;

import nl.fhict.s3.hsdm.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICardRepository extends JpaRepository<Card, Integer> {
}
