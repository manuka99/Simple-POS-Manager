package com.spm.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spm.inventory.model.Product;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	@Query(value="SELECT month(product_date) as month, count(productid) as products FROM spm_inventory.product WHERE year(product_date) = :year group by month(product_date)", nativeQuery = true)
	List<Object> getProductsBasedOnMonthsForYear(@Param("year") int year);
}
