package com.SpringJdbc.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


// Use of component annotation 

@Component("StudentBean")
public class Student {
	
	
	private DataSource dataSource;
	//private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
	
	
	
	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}



	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}



	public DataSource getDataSource() {
		return dataSource;
	}


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public List NoOfStudents() {
		
		String query="SELECT COUNT(*) FROM student";
		//jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForList(query);
		
	}
	
	public void updateOp() {
		String query="UPDATE student SET age=? where sname=?";
		
		jdbcTemplate.update(query,19,"Abhi");
	}
	
	public void deleteOp() {
		String query="DELETE FROM student WHERE sid=106";
		jdbcTemplate.execute(query);
		
	}
	
	public void insertOp() {
		
		
		
		
		  String
		  query="INSERT INTO student VALUES(:sid,:sname,:sem,:age,:mobile,:email)";
		  
		  Map<String,Object> values=new HashMap<String,Object>();
		  values.put("sid",107); values.put("sname","Arun"); values.put("sem",1);
		  values.put("age",17); values.put("mobile","9647180532");
		  values.put("email","arun@asdf.com");
		  
		  
		  template.update(query, values);
		 
		 
		// Insertion using jdbc template
		
		/* 
		 * String sql="INSERT INTO student VALUES(?,?,?,?,?,?)";
		 * jdbcTemplate.setDataSource(getDataSource());
		 * jdbcTemplate.update(sql,108,"Arjun",1,17,"9647851032","arju@asdf.com");
		 */
		 
		
	}
	
	public void getInfo() {
		
		String query="SELECT * FROM student";
		List<Map<String,Object>> ls=jdbcTemplate.queryForList(query);
		
		Iterator<Map<String,Object>> it=ls.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
