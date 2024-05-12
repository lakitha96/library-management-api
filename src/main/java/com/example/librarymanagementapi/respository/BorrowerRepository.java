package com.example.librarymanagementapi.respository;

import com.example.librarymanagementapi.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lakithaprabudh
 */
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
