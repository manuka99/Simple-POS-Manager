package com.spm.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.inventory.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
