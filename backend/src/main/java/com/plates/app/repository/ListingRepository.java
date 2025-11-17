package com.plates.app.repository;

import com.plates.app.model.Listing;
import com.plates.app.model.ListingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByStatus(ListingStatus status);
    List<Listing> findByOwner_Id(Long ownerId);
}
