package com.example.repository.impl;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User , Integer> {
}
