package com.javaproject.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LDao {
	DataSource dataSource;

	public LDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/todo");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void signUp() {
		
	}
	public void signIn() {
		
	}

	public void modify() {
		
	}
	public void delete() {
		
	}
	public void list() {
		
	}
	public void signOut() {
		
	}

	public void create(Object user_uId, String content, Timestamp finishdate, String isImportant) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into list (user_uId, lContent, lFinishDate, lisImportant, lisDone, insertDate) values (?, ?, ?, ?, 1, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, (String) user_uId);
			preparedStatement.setString(2, content);
			preparedStatement.setTimestamp(3, finishdate);
			preparedStatement.setString(4, isImportant);
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


}
