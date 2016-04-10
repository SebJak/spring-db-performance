package com.langpath.data.repositories;

import com.langpath.data.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    Collection<User> findByIdIn(Collection<Long> ids);

}
