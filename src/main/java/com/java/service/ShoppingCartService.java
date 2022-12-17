package com.java.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.java.model.CartItem;
import com.java.model.Product;

@Service
public interface ShoppingCartService {

	int getCount();

	double getAmount();

	void clear();
	
	Collection<CartItem> getCartItems();

	void remove(CartItem item);

	void add(CartItem item);
	
	void decrease(CartItem item);
	
	void increase(CartItem item);

	void remove(Product product);
}
