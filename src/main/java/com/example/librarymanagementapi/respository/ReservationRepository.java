package com.example.librarymanagementapi.respository;

import com.example.librarymanagementapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lakithaprabudh
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
