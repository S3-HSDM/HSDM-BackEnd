package nl.fhict.s3.hsdm.repositories;

import nl.fhict.s3.hsdm.models.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHeroCardRepository extends ICardRepository {
    @Query("SELECT x FROM Card x WHERE x.heroPower != null")
    List<Card> findAllHeroCards();
}
