package by.prokopovich.switter.twit.repository;

import by.prokopovich.switter.twit.model.Twit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitRepository extends JpaRepository<Twit,Long> {
}
