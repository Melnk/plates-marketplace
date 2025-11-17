package com.plates.app.repository;

import com.plates.app.model.TransactionArchive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionArchiveRepository extends JpaRepository<TransactionArchive, Long> {

}
