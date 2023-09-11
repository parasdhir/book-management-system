package com.example.bookmanagementback;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




class BookDaoTest {
	
	private BookDao dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("system");
		datasource.setPassword("paras");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new BookDao(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {

		List <Books> ls = dao.list();
		assertTrue(ls.isEmpty());
	}

	@Test
	void testSave() {
		Books b = new Books("The Power Of Your Subconsious Mind", "Joseph murphy", "Self Help",340,120,3);
		dao.save(b);
	}
	@Test
	void testGet() {
		int id = 4;
		Books b = dao.get(id);
		System.out.println(b);
		assertNotNull(b);
	}

	@Test
	void testUpdate() {
		Books b = new Books();
		b.setId(5);
		b.setName("Verbose addtion");
		b.setAuthor("dfd");
		b.setGenre("mystry");
		b.setNumberofpages(130);
		b.setPrice(450);
		b.setRating(3);
		dao.update(b);

	}
	
	@Test
	void testDelete() {
		int id = 4;
		dao.delete(id);
	}

}
