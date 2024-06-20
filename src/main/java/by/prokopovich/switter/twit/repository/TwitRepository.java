package by.prokopovich.switter.twit.repository;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TwitRepository extends CrudRepository<Twit, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Twit SET message=:message, modifiedAt = CURRENT_TIMESTAMP WHERE id = :id")
    void updateMessageById(String message, Long id);

    Page<Twit> findAllByUserProfile(UserProfile userProfile, Pageable pageable);

}
