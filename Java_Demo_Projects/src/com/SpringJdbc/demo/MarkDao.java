package com.SpringJdbc.demo;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MarkDao extends JdbcDaoSupport{
	
	public void getDetails() {
		
		String sql="select count(*) from marks";
		
		System.out.println(this.getJdbcTemplate().queryForList(sql));
	}

}
