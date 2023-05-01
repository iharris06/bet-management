package com.zonabets.betmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bank", columnDefinition = "float default", nullable = false)
    private float bank;

    // @NotBlank(message = "username cannot be blank")
    // @NonNull
    // @Column(nullable = false, unique = true)
    // private String username;

    // @NotBlank(message = "password cannot be blank")
    // @NonNull
    // @Column(nullable = false)
    // private String password;

}
