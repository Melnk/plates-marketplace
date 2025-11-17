package com.plates.app.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions_archive")
@Getter
@Setter
public class TransactionArchive {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long listeningId;
    private Long sellerId;
    private Long buyerId;
    private BigDecimal price;
    @Column(columnDefinition = "jsonb")
    private String contactInfo;
    private LocalDateTime completedAt = LocalDateTime.now();
}
