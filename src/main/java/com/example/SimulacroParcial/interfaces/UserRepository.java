package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
