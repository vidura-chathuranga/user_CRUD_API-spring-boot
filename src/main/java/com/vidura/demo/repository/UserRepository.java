package com.vidura.demo.repository;

import com.vidura.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    custom query for getting user by ID
    @Query(value = "SELECT * FROM User WHERE id = ?1",nativeQuery = true)
    User getUserById(Integer id);
}
