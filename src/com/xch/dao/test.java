package com.xch.dao;

import java.util.List;

import com.xch.vo.Product;

public class test {
	public static void main(String[] args) {
		DaoI dao=new HibDaoImpl();
		List<Product> list=dao.getProducts();
		System.out.println(dao.getProducts(1));
		System.out.println(list);
		System.out.println(dao.login("1", "123"));
	}
}
