/*
 * IT19152288
 * Bandara M.H.M.N.D.T.
 */
package com.spm.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spm.inventory.model.ItemEntity;



@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}

