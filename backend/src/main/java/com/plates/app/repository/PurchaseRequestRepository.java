package com.plates.app.repository;

import com.plates.app.model.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {
    List<PurchaseRequest> findByListing_Id(Long listingId);
}
