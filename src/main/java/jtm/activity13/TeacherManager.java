package jtm.activity13;

import jtm.TestUtils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TeacherManager {
	protected Connection conn;

	// use user value from src/resources/application.properties file
	static final String user = "u00";
	// use password value from src/resources/application.properties file
	static final String password = "u00";
	// use database value from src/resources/application.properties file
	static final String database = "database00";

	public TeacherManager() {
		/*-
		 * #1 When new TeacherManager is created, create connection to the database server:
		 * - url = "jdbc:mysql://localhost/?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf8"
		 * - user = TestUtils.user
		 * - pass = TestUtils.password
		 * Notes:
		 * 1. Use database name imported from jtm.TestUtils.database
		 * 2. Do not pass database name into url, because some statements in tests need to be executed
		 * server-wise, not just database-wise.
		 * 3. Set AutoCommit to false and use commit() where necessary in other methods
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
	 * Returns a Teacher instance represented by the specified ID.
	 * 
	 * @param id the ID of teacher
	 * @return a Teacher object
	 */
	public Teacher findTeacher(int id) {

		/*- #2 Write an sql statement that searches teacher by ID.
		 * If teacher is not found return Teacher object with zero or null in its fields!
		 * Hints:
		 * 1. Because default database is not set in connection,
		 *    use full notation for table "databaseXX.Teacher"
		 * 2. Do not't use transactions for search (autocommit=false, commit() is not called)
		 *    because table should not be blocked for concurrent write during search
		 */
		String sql = "SELECT * FROM `" + database + "`.`Teacher` WHERE id = ?;";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
				return new Teacher(
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
		return new Teacher(0, null, null);
	}

	/**
	 * Returns a list of Teacher object that contain the specified first name and
	 * last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName the first name of teacher.
	 * @param lastName  the last name of teacher.
	 * @return a list of Teacher object.
	 */
	public List<Teacher> findTeacher(String firstName, String lastName) {
		/*- #3 Write an sql statement that searches teacher by first and
		 * last name and returns results as List<Teacher>.
		 * Note that search results of partial match
		 * in form ...like '%value%'... should be returned
		 * Note, that if nothing is found return empty list!
		 * Do not't use transactions for search (autocommit=false, commit() is not called)
		 * because table should not be blocked for concurrent write during search
		 */
		List<Teacher> result = new LinkedList<>();
		String sql = "SELECT * FROM `" + database + "`.`Teacher` WHERE firstName like ? AND lastName like ?;";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + firstName + "%");
			preparedStatement.setString(2, "%" + lastName + "%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				result.add(
					new Teacher(
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
	 * Insert an new teacher (first name and last name) into the repository.
	 * 
	 * @param firstName the first name of teacher
	 * @param lastName  the last name of teacher
	 * @return true if success, else false.
	 */

	public boolean insertTeacher(String firstName, String lastName) {
		String sql = "INSERT INTO `" + database + "`.`Teacher` (`firstname`, `lastname`) VALUES (?, ?);";
		PreparedStatement preparedStatement;
		int rowsAffected;
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
			return false;
		}
		return rowsAffected > 0;
	}

	/**
	 * Insert teacher object into database
	 * 
	 * @param teacher
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertTeacher(Teacher teacher) {
		// #5 Write an sql statement that inserts teacher in database.
		String sql = "INSERT INTO `" + database + "`.`Teacher` (`id`, `firstname`, `lastname`) VALUES (?, ?, ?);";
		PreparedStatement preparedStatement;
		int rowsAffected;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, teacher.getId());
			preparedStatement.setString(2, teacher.getFirstName());
			preparedStatement.setString (3, teacher.getLastName());
			rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return rowsAffected > 0;
	}

	/**
	 * Updates an existing Teacher in the repository with the values represented by
	 * the Teacher object.
	 * 
	 * @param teacher a Teacher object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateTeacher(Teacher teacher) {
		// #6 Write an sql statement that updates teacher information.
		String sql = "UPDATE `" + database + "`.`Teacher` SET `firstname` = ?, `lastname` = ? WHERE `id` = ?;";
		PreparedStatement preparedStatement;
		int rowsAffected;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getFirstName());
			preparedStatement.setString (2, teacher.getLastName());
			preparedStatement.setInt(3, teacher.getId());
			rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return rowsAffected > 0;
	}

	/**
	 * Delete an existing Teacher in the repository with the values represented by
	 * the ID.
	 * 
	 * @param id the ID of teacher.
	 * @return true if row was deleted.
	 */
	public boolean deleteTeacher(int id) {
		// #7 Write an sql statement that deletes teacher from database.
		String sql = "DELETE FROM `" + database + "`.`Teacher` WHERE `id` = ?;";
		PreparedStatement preparedStatement;
		int rowsAffected;
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
			return false;
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
