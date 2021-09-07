package com.spm.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spm.order.model.ItemEntity;



@Repository
public interface itemRepository extends JpaRepository<ItemEntity, Long> {

}

