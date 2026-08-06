package com.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
