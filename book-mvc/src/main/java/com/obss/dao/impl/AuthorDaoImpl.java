package com.obss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.obss.dao.AuthorDao;
import com.obss.model.Author;
import com.obss.model.Book;

@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Author getAuthor(long authorID) {
		String sql = "select * from author where authorID=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, authorID);
			Author author = null;

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				author = new Author();
				author.setAuthorID(rs.getLong("authorID"));
				author.setName(rs.getString("name"));
				author.setSurname(rs.getString("surname"));

			}
			rs.close();
			ps.close();
			return author;
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

	public Author saveAuthor(Author author) {
		String sql = "insert into author(name,surname) values(?,?)";
		Object[] input = new Object[] { author.getName(), author.getSurname() };
		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			return author;
		} else {
			System.out.println("Wrong!!");
			return null;
		}
	}

	public Author updateAuthor(Long authorID, Author author) {
		String sql = "update author set name=?,surname=? where authorID=?";
		Object[] input = new Object[] { author.getName(), author.getSurname() ,authorID};
		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			return author;
		} else {
			System.out.println("Wrong!!");
			return null;
		}
	}

	public void deleteAuthor(Long authorID) {
		String sql = "delete from author where authorID=?";
		Object[] input = new Object[] { authorID };

		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			System.out.println("Deleted");
		} else {
			System.out.println("Wrong");
		}

	}

	@Override
	public List<Author> get() {
		String sql = "select * from author";
		Connection conn = null;
		List<Author> list=new ArrayList<Author>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Author author= null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("..");
				author = new Author();
				author.setAuthorID(rs.getInt("authorID"));
				author.setName(rs.getString("name"));
				author.setSurname(rs.getString("surname"));
				list.add(author);
			}
			rs.close();
			ps.close();
			return list;
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

}
