package com.ivanminyaev.coachhub.entity;

import com.ivanminyaev.coachhub.entity.enumeration.TransactionDirection;
import com.ivanminyaev.coachhub.entity.enumeration.TransactionType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_id", nullable = false)
    BalanceEntity balance;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    TransactionType type;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    TransactionDirection direction;

    @Column
    String comment;

    @Column(nullable = false)
    BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

    @Column(nullable = false)
    LocalDateTime createdAt;
}
