package com.plates.app.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="listings")
@Getter
@Setter
public class Listing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name="owner_id") private User owner;
    private String plate;
    private String city;
    private BigDecimal price;
    private String description;
    @Enumerated(EnumType.STRING) private ListingStatus status = ListingStatus.PENDING;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime approvedAt;
}
