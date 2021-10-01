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
	
//	---------------
	
	@Query(value="SELECT sum(initial_stock_count) as initialStocks, sum(initial_stock_count * price) as value FROM spm_inventory.product WHERE year(product_date) = :year", nativeQuery = true)
	List<Object> getTotalAndValueStockForYear(@Param("year") int year);
	
	@Query(value="SELECT month(product_date) as month, sum(initial_stock_count - remaining_stock_count) as stockDifference FROM spm_inventory.product WHERE year(product_date) = :year group by month(product_date)", nativeQuery = true)
	List<Object> getStockDifferenceBasedOnMonthsForYear(@Param("year") int year);
	
//	------------------
	
	@Query(value="SELECT sum(initial_stock_count) as initialStocks, sum(remaining_stock_count) as remainingStocks FROM spm_inventory.product WHERE year(product_date) = :year", nativeQuery = true)
	List<Object> getInitialAndRemainingStockForYear(@Param("year") int year);
	
	@Query(value="SELECT month(product_date) as month, sum(remaining_stock_count / initial_stock_count) * 100 as stockDifference FROM spm_inventory.product WHERE year(product_date) = :year group by month(product_date)", nativeQuery = true)
	List<Object> getStockDifferentPercentageBasedOnMonthsForYear(@Param("year") int year);
	
//	--------------------
	
	@Query(value="SELECT sum(initial_stock_count * price) as initialStocksValue, sum(initial_stock_count) as initialStocks, sum(remaining_stock_count * price) as remainingStocksValue, sum(remaining_stock_count) as remainingStocks FROM spm_inventory.product WHERE year(product_date) = :year", nativeQuery = true)
	List<Object> getStockForYear(@Param("year") int year);
	
	@Query(value="SELECT month(product_date) as month, sum(initial_stock_count) as initialStocks, sum(remaining_stock_count) as remainingStocks FROM spm_inventory.product WHERE year(product_date) = :year group by month(product_date)", nativeQuery = true)
	List<Object> getStockBasedOnMonthsForYear(@Param("year") int year);
}
