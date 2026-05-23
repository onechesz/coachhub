package com.ivanminyaev.coachhub.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 20)
    String name;

    @Column(nullable = false)
    String pass;

    @Column(length = 50, unique = true)
    String phone;

    @Column(name = "card_number", length = 4)
    String cardNumber;

    @Column(unique = true)
    String email;
}
