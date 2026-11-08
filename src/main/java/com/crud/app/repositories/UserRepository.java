package com.crud.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.app.entities.User;

/**
 * UserRepository
 */
@Repository 
public interface UserRepository extends JpaRepository<User, UUID>
{
    User findByEmail(String email);
    
}