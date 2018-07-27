package com.obss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.obss.dao.UserDao;
import com.obss.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User getUser(String userName) {
		System.out.println("getUser()");

		String sql = "select * from user where userName=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			User user = null;

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEnabled(rs.getBoolean("enabled"));

			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}
	}


	public User saveUser(User user) {

		String sql = "insert into user(userName,password,enabled) values(?,?,?)";
		Object[] input = new Object[] { user.getUserName(), user.getPassword(), user.isEnabled()};
		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			return user;
		} else {
			System.out.println("Wrong!!");
			return null;
		}

	}

	public User updateUser(String userName, User user) {
		System.out.println("updateUser()");
		String sql = "update user set userName=?,password=?,enabled=? where userName=?";
		Object[] input = new Object[] { user.getUserName(),user.getPassword(),user.isEnabled(),userName };
		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			return user;
		} else {
			System.out.println("Wrong!!");
			return null;
		}

	}

	public void deleteUser(String userName) {
		System.out.println("deleteUser()");
		String sql = "delete from user where userName=?";
		Object[] input = new Object[] { userName };

		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			System.out.println("Deleted");
		}
		else {
			System.out.println("Wrong");
		}

	}

}
