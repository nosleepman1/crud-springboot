package com.crud.app.entities;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

/**
 * User
 */

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String password;



    
}