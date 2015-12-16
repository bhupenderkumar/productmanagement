package com.xch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.xch.vo.Product;
import com.xch.vo.User;

public class DaoImpl extends AbsDao implements DaoI {

	private static DaoI dao;
	
	private DaoImpl(){
		
	}
	//singleton - creates only one instance through out application
	public static DaoI getInstance(){
		if (dao == null)
			dao = new HibDaoImpl();
		return dao;
	}
	
	public List<Product> getProducts() {
		Connection conn = null;
		PreparedStatement st = null;
		List<Product> lst = new ArrayList<Product>();
		Product prod = null;
		try {
			conn = getConn();
			String sql = "select * from product";
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				prod = new Product();
				prod.setPid(rs.getInt("pid"));
				prod.setPname(rs.getString("pname"));
				prod.setPrice(rs.getDouble("price"));
				prod.setCat(rs.getString("category"));
				prod.setPimg(rs.getString("pimg"));
				System.out.println("asdsaD");
				lst.add(prod);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return lst;
	}

	
	public List<Product> getProducts(String cat) {
		Connection conn = null;
		PreparedStatement st = null;
		List<Product> lst = new ArrayList<Product>();
		Product prod = null;
		try {
			conn = getConn();
			String sql = "select * from product where category=?";
			st = conn.prepareStatement(sql);
			st.setString(1, cat);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				prod = new Product();
				prod.setPid(rs.getInt("pid"));
				prod.setPname(rs.getString("pname"));
				prod.setPrice(rs.getDouble("price"));
				prod.setCat(rs.getString("category"));
				prod.setPimg(rs.getString("pimg"));
				lst.add(prod);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return lst;
	}

	
	public Product getProducts(int pid) {
		Connection conn = null;
		PreparedStatement st = null;

		Product prod = null;
		try {
			conn = getConn();
			String sql = "select * from product where pid =?";
			st = conn.prepareStatement(sql);
			st.setInt(1, pid);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				prod = new Product();
				prod.setPid(rs.getInt("pid"));
				prod.setPname(rs.getString("pname"));
				prod.setPrice(rs.getDouble("price"));
				prod.setCat(rs.getString("category"));
				prod.setPimg(rs.getString("pimg"));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return prod;
	}

	
	public Set<String> getCategories() {
		Connection conn = null;
		PreparedStatement st = null;
		Set<String> set = new HashSet<String>();
		try {
			conn = getConn();
			String sql = "select * from product";
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				set.add(rs.getString("category"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return set;
	}

	
	public int addProduct(Product prod) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConn();
			String sql = "insert into product values (?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, prod.getPid());
			st.setString(2, prod.getPname());
			st.setDouble(3, prod.getPrice());
			st.setString(4, prod.getCat());
			st.setString(5, prod.getPimg());
			int  rs = st.executeUpdate();
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return 0;
	}
	@Override
	public User login(String uid, String pwd) {
		String sql = "select * from test.login where uid=? and pwd=?";
		Connection con = null;
		User user=new User();
		try {
			con = getConn();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUid(rs.getString("uid"));
				user.setUsername(rs.getString("username"));
				user.setPwd(rs.getString("pwd"));
			}
			return user;
		} catch (Exception e) {

		} finally {
			closeConn(con);
		}
		return null;

	}
}
