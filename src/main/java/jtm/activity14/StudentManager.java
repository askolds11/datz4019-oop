package jtm.activity14;

import jtm.TestUtils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
	protected Connection conn;

	// use user value from src/resources/application.properties file
	static final String user = "u00";
	// use password value from src/resources/application.properties file
	static final String password = "u00";
	// use database value from src/resources/application.properties file
	static final String database = "database00";

	public StudentManager() {
		/*-
		 * #1 When new StudentManager is created, create connection to the database server:
		 * - url = "jdbc:mysql://localhost/?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf8"
		 * - user = TestUtils.user
		 * - pass = TestUtils.password
		 * Notes:
		 * 1. Use database name imported from jtm.TestUtils.database
		 * 2. Do not pass database name into url, because some statements in tests need to be executed
		 * server-wise, not just database-wise.
		 * 3. Set AutoCommit to false and use conn.commit() where necessary in other methods
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver class
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf8",
					TestUtils.user,
					TestUtils.password
			); //Create connection
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a Student instance represented by the specified ID.
	 * 
	 * @param id the ID of student
	 * @return a Student object
	 */
	public Student findStudent(int id) {
		// #2 Write an sql statement that searches student by ID.
		// If student is not found return Student object with zero or null in
		// its fields!
		// Hint: Because default database is not set in connection,
		// use full notation for table "databaseXX.Student"
		String sql = "SELECT * FROM `" + database + "`.`Student` WHERE id = ?;";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
				return new Student(
						resultSet.getInt("id"),
						resultSet.getString("firstName"),
						resultSet.getString("lastName")
				);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return new Student(0, null, null);
	}

	/**
	 * Returns a list of Student object that contain the specified first name and
	 * last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName the first name of student.
	 * @param lastName  the last name of student.
	 * @return a list of Student object.
	 */
	public List<Student> findStudent(String firstName, String lastName) {
		// #3 Write an sql statement that searches student by first and
		// last name and returns results as List<Student>.
		// Note that search results of partial match
		// in form ...like '%value%'... should be returned
		// Note, that if nothing is found return empty list!
		List<Student> result = new LinkedList<>();
		String sql = "SELECT * FROM `" + database + "`.`Student` WHERE firstName like ? AND lastName like ?;";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + firstName + "%");
			preparedStatement.setString(2, "%" + lastName + "%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				result.add(
						new Student(
								resultSet.getInt("id"),
								resultSet.getString("firstName"),
								resultSet.getString("lastName")
						)
				);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * Insert an new student (first name and last name) into the repository.
	 * 
	 * @param firstName the first name of student
	 * @param lastName  the last name of student
	 * @return true if success, else false.
	 */

	public boolean insertStudent(String firstName, String lastName) {
		// #4 Write an sql statement that inserts student in database.
		String sql = "INSERT INTO `" + database + "`.`Student` (`firstname`, `lastname`) VALUES (?, ?);";
		PreparedStatement preparedStatement;
		int rowsAffected = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString (2, lastName);
			rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rowsAffected > 0;
	}

	/**
	 * Insert student object into database
	 * 
	 * @param student
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertStudent(Student student) {
		// #5 Write an sql statement that inserts student in database.
		String sql = "INSERT INTO `" + database + "`.`Student` (`id`, `firstname`, `lastname`) VALUES (?, ?, ?);";
		PreparedStatement preparedStatement;
		int rowsAffected = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString (3, student.getLastName());
			rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rowsAffected > 0;
	}

	/**
	 * Updates an existing Student in the repository with the values represented by
	 * the Student object.
	 * 
	 * @param student a Student object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateStudent(Student student) {
		//  #6 Write an sql statement that updates student information.
		String sql = "UPDATE `" + database + "`.`Student` SET `firstname` = ?, `lastname` = ? WHERE `id` = ?;";
		PreparedStatement preparedStatement;
		int rowsAffected = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString (2, student.getLastName());
			preparedStatement.setInt(3, student.getId());
			rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rowsAffected > 0;
	}

	/**
	 * Delete an existing Student in the repository with the values represented by
	 * the ID.
	 * 
	 * @param id the ID of student.
	 * @return true if row was deleted.
	 */
	public boolean deleteStudent(int id) {
		// #7 Write an sql statement that deletes student from database.
		String sql = "DELETE FROM `" + database + "`.`Student` WHERE `id` = ?;";
		PreparedStatement preparedStatement;
		int rowsAffected = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rowsAffected > 0;
	}

	public void closeConnecion() {
		// Close connection to the database server
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
