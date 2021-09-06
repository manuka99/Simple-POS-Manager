package com.spm.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.order.model.Items;

public interface itemRepository extends JpaRepository<Items, Integer>{

}
