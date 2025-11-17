package com.plates.app.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="purchase_requests")
@Getter
@Setter
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name="listing_id") private Listing listing;
    @ManyToOne @JoinColumn(name="buyer_id") private User buyer;
    private String status = "REQUESTED";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime processedAt;
}
