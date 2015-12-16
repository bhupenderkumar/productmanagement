package com.xch.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xch.vo.Product;
import com.xch.vo.User;

public class HibDaoImpl implements DaoI{
    private static SessionFactory sfac;
    static{
    	 Configuration  cfg = new Configuration().configure();
		 sfac=cfg.buildSessionFactory();
    }
	@Override
	public List<Product> getProducts() {
		Session ses = sfac.openSession();
		String hql="from Product";
		Query query=ses.createQuery(hql);
		List<Product> list=query.list();
		ses.close();
		return list;
	}

	@Override
	public List<Product> getProducts(String cat) {
		Session ses = sfac.openSession();
		String hql="from Product where cat=?";
		Query query=ses.createQuery(hql);
		query.setString(0, cat);
		List<Product> list=query.list();
		ses.close();
		return list;
	}

	@Override
	public Product getProducts(int pid) {
		Session ses = sfac.openSession();
		String hql="from Product where pid=?";
		Query query=ses.createQuery(hql);
		query.setInteger(0, pid);
		Product list=(Product) query.uniqueResult();
		ses.close();
		return list;
	}

	@Override
	public Set<String> getCategories() {
		Session ses = sfac.openSession();
		
		String hql="select category from Product ";
		Query query=ses.createQuery(hql);
		List<String> list=query.list();
		Set<String> set=new HashSet<String>();
		set.addAll(list);
		ses.close();
		return set;
	}

	@Override
	public int addProduct(Product prod) {
		Session ses = sfac.openSession();
		Transaction td=null;
		try{
			td=ses.beginTransaction();
			ses.save(prod);
			td.commit();
		}catch(HibernateException hb){
			if(td!=null)
				td.rollback();
			return -1;
		}finally{
			if(ses!=null)
				ses.close();
		}
		
		return 1;
	}

	@Override
	public User login(String uid, String pwd) {
		
		Session ses = sfac.openSession();
		String hql="from User where id=? and password=?";
		Query query=ses.createQuery(hql);
		query.setString(0, uid);
		query.setString(1, pwd);
		User list=(User) query.uniqueResult();
		ses.close();
		return list;
	}

}
