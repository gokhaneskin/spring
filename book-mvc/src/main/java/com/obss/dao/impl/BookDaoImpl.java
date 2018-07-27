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

import com.obss.dao.BookDao;
import com.obss.model.Author;
import com.obss.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

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

	public Book getBook(Long bookID) {
		String sql = "select * from book where bookID=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, bookID);
			Book book= null;

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setBookID(rs.getInt("bookID"));
				book.setPage(rs.getInt("page"));
				book.setTitle(rs.getString("title"));
				Author author = new Author();
				author.setAuthorID(rs.getInt("authorID"));
				book.setAuthorID(author);
						
			}
			rs.close();
			ps.close();
			return book;
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

	public Book saveBook(Book book) {
		String sql = "insert into book(title,page,authorID) values(?,?,?)";
		Object[] input = new Object[] { book.getTitle(), book.getPage(), book.getAuthorID().getAuthorID()};
		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			return book;
		} else {
			System.out.println("Wrong!!");
			return null;
		}
	}

	public Book updateBook(Long bookID, Book book) {
		System.out.println("updateUser()");
		String sql = "update book set title=?,page=?,authorID=? where bookID=?";
		Object[] input = new Object[] { book.getTitle(),book.getPage(),book.getAuthorID().getAuthorID(), bookID };
		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			return book;
		} else {
			System.out.println("Wrong!!");
			return null;
		}
	}

	public void deleteBook(Long bookID) {
		String sql = "delete from book where bookID=?";
		Object[] input = new Object[] { bookID };

		int result = getJdbcTemplate().update(sql, input);
		if (result > 0) {

			System.out.println("Deleted");
		}
		else {
			System.out.println("Wrong");
		}
	}
	public List<Book> get() {
		String sql = "select * from book";
		Connection conn = null;
		List<Book> list=new ArrayList<Book>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Book book= null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("..");
				book = new Book();
				book.setBookID(rs.getInt("bookID"));
				book.setPage(rs.getInt("page"));
				book.setTitle(rs.getString("title"));
				int authorID=rs.getInt("authorID");
				Author author =getAuthorInfo(authorID);
				book.setAuthorID(author);
				list.add(book);
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

	private Author getAuthorInfo(long authorID) {
		String sql = "select * from author where authorID=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, authorID);
			Author author= null;

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				author = new Author();
				author.setAuthorID(authorID);
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

}
