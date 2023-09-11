package com.example.bookmanagementback;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class BookDao {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BookDao(JdbcTemplate jdbcTemplate2) {
		super();
		this.jdbcTemplate = jdbcTemplate2;
	}

	public List<Books> list(){
		String sql = "SELECT * FROM Books";
		List<Books> listbook = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Books.class));
		return listbook;
	}
	
	public void save(Books books) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Books").usingColumns("name","author","genre","numberofpages","price","rating");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(books);
		insertActor.execute(param);
	}
	
	public Books get(int id) {
		String sql = "Select * from Books where id = ?";
		Object[] args = {id};
		@SuppressWarnings("deprecation")
		Books book = jdbcTemplate.queryForObject(sql, args,BeanPropertyRowMapper.newInstance(Books.class));
		
		return book;
	}

	public void update(Books book) {
		String sql = "UPDATE Books SET name=:name,numberofpages=:numberofpages, price=:price, rating=:rating, author=:author, genre=:genre WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(book);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	public void delete(int id) {
	String sql = "Delete from Books where id = ?";
	jdbcTemplate.update(sql,id);
	}
	
	
}
