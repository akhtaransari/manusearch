package com.makersharks.ManuSearch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a User.
 * This class maps to the "users" table in the database and is used to persist user data.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        /**
         * Unique identifier for each user.
         * Automatically generated by the database.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /**
         * Email of the user.
         * Cannot be null or blank.
         * Must be a valid email format and unique.
         * Maximum length is 50 characters.
         */
        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        @Size(max = 50, message = "Email must be less than 50 characters")
        @Column(nullable = false, unique = true, length = 50)
        private String email;

        /**
         * Password of the user.
         * Cannot be null or blank.
         * Maximum length is 100 characters.
         */
        @NotBlank(message = "Password is mandatory")
        @Size(max = 100, message = "Password must be less than 100 characters")
        @Column(nullable = false, length = 100)
        private String password;
}
