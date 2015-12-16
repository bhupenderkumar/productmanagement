package com.xch.dao;

import java.util.List;
import java.util.Set;

import com.xch.vo.Product;
import com.xch.vo.User;

public interface DaoI {

	List<Product> getProducts();
	List<Product> getProducts(String cat);
	Product getProducts(int pid);
	Set<String> getCategories();
	int addProduct(Product prod);
	User login(String uid,String pwd);
}
