package com.spring.calculator.repository;

import com.spring.calculator.model.Number;
import com.spring.calculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findById(int id);

    User findByEmail(String email);

    User findByUsername(String Username);

    @Query(value = "SELECT * from numbers" +
            "INNER JOIN users " +
            "ON numbers.user_id = users.user_id;" +
            "WHERE users.user_id = :userId", nativeQuery = true)
    List<Number> findUserNumber(int userId);
}
