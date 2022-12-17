package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// Display latest product LIMIT = 8
	@Query(value = "SELECT * FROM products ORDER BY entered_date DESC limit 8", nativeQuery = true)
	public List<Product> listProduct8();

	// display number of product per category
	@Query(value = "SELECT c.category_id,c.category_name,\r\n" + "COUNT(*) AS SoLuong\r\n" + "FROM products b\r\n"
			+ "JOIN categories c ON b.category_id = c.category_id\r\n" + "GROUP BY c.category_name, c.category_id;", nativeQuery = true)
	public List<Object[]> listCategoryByProductName();

	// display product by category
	@Query(value = "SELECT * FROM products where category_id = ?", nativeQuery = true)
	public List<Product> listProductByCategory(Integer id);

	// Suggest product by category
	@Query(value = "SELECT \r\n" + "*FROM products AS p\r\n" + "WHERE p.category_id = ?", nativeQuery = true)
	public List<Product> productsByCategory(Integer categoryId);

	// Search Product
	@Query(value = "SELECT * FROM products WHERE name LIKE %?1%", nativeQuery = true)
	public List<Product> searchProduct(String name);

}
