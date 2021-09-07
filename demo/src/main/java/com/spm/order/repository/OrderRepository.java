package com.spm.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.order.model.orderEntity;

public interface OrderRepository extends JpaRepository<orderEntity, Integer>{

}
