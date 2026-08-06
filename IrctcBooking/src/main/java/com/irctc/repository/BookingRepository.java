package com.irctc.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.entity.TicketEntity;
import java.util.List;


//public interface BookingRepository extends JpaRepository<TicketEntity, Integer> {
//	List<TicketEntity> findByPnr(Integer pnr);
//	List<TicketEntity> findByUserId(Long userId, Pageable pageable);
//}

public interface BookingRepository extends JpaRepository<TicketEntity, Integer> {
	List<TicketEntity> findByPnr(Integer pnr);
	List<TicketEntity> findByUserId(long userId, Pageable pageable);
}