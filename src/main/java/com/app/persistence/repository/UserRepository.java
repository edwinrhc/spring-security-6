package com.app.persistence.repository;

import com.app.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


    Optional<UserEntity> findUserEntitiesByUsername(String username);

//    @Query("SELECT u FROM UserEntity u WHERE u.username = ?")
//    Optional<UserEntity> findUser(String username);



}
