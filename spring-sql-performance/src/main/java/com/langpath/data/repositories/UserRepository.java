package com.langpath.data.repositories;

import com.langpath.data.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    Collection<User> findByIdIn(Collection<Long> ids);

    @Query(value = "Select * from getWorstAnsweredWord(?1)", nativeQuery = true)
    String getWorstAnswered(long id);


    @Modifying
    @Query(value = "update User u set u.lastName= ?2 where u.id=?1")
    void updateName(long id, String lastName);

}
