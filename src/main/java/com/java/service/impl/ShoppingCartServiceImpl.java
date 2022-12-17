package com.java.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.java.model.CartItem;
import com.java.model.Product;
import com.java.service.ShoppingCartService;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		//return map.values().size();
		return map.values().stream().mapToInt(item -> item.getQuantity()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getUnitPrice()).sum();
	}

	@Override
	public void clear() {
		map.clear();

	}

	@Override
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	@Override
	public void remove(CartItem item) {
		map.remove(item.getProductId());

	}

	@Override
	public void add(CartItem item) {
		CartItem existedItem = map.get(item.getProductId());
		if (existedItem != null) {
			existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
			existedItem.setTotalPrice(item.getTotalPrice() + existedItem.getUnitPrice() * existedItem.getQuantity());
		} else {
			map.put(item.getProductId(), item);
		}

	}
	
	@Override
	public void decrease(CartItem item) {
		CartItem existedItem = map.get(item.getProductId());
		if (existedItem != null) {
			if(existedItem.getQuantity() > 1 ) {
			existedItem.setQuantity(existedItem.getQuantity() - 1);
			existedItem.setTotalPrice(existedItem.getTotalPrice() - existedItem.getUnitPrice() * 1);
			}
		} else {
			map.put(item.getProductId(), item);
		}

	}
	
	@Override
	public void increase(CartItem item) {
		CartItem existedItem = map.get(item.getProductId());
		if (existedItem != null) {
			if(existedItem.getQuantity() > 0 ) {
			existedItem.setQuantity(existedItem.getQuantity() + 1);
			existedItem.setTotalPrice(existedItem.getTotalPrice() + existedItem.getUnitPrice() * 1);
			}
		} else {
			map.put(item.getProductId(), item);
		}

	}

	@Override
	public void remove(Product product) {

	}

}
