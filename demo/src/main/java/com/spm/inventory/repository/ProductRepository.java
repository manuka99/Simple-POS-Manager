package com.spm.inventory.repository;
/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spm.inventory.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
