package jtm.activity14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		 * TODO #1 When new StudentManager is created, create connection to the database server:
		 * - url = "jdbc:mysql://localhost/?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf8"
		 * - user = TestUtils.user
		 * - pass = TestUtils.password
		 * Notes:
		 * 1. Use database name imported from jtm.TestUtils.database
		 * 2. Do not pass database name into url, because some statements in tests need to be executed
		 * server-wise, not just database-wise.
		 * 3. Set AutoCommit to false and use conn.commit() where necessary in other methods
		 */
	}

	/**
	 * Returns a Student instance represented by the specified ID.
	 * 
	 * @param id the ID of student
	 * @return a Student object
	 */
	public Student findStudent(int id) {
		// TODO #2 Write an sql statement that searches student by ID.
		// If student is not found return Student object with zero or null in
		// its fields!
		// Hint: Because default database is not set in connection,
		// use full notation for table "databaseXX.Student"
		return null;
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
		// TODO #3 Write an sql statement that searches student by first and
		// last name and returns results as List<Student>.
		// Note that search results of partial match
		// in form ...like '%value%'... should be returned
		// Note, that if nothing is found return empty list!
		return null;

	}

	/**
	 * Insert an new student (first name and last name) into the repository.
	 * 
	 * @param firstName the first name of student
	 * @param lastName  the last name of student
	 * @return true if success, else false.
	 */

	public boolean insertStudent(String firstName, String lastName) {
		// TODO #4 Write an sql statement that inserts student in database.
		return false;
	}

	/**
	 * Insert student object into database
	 * 
	 * @param student
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertStudent(Student student) {
		// TODO #5 Write an sql statement that inserts student in database.
		return false;
	}

	/**
	 * Updates an existing Student in the repository with the values represented by
	 * the Student object.
	 * 
	 * @param student a Student object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateStudent(Student student) {
		boolean status = false;
		// TODO #6 Write an sql statement that updates student information.
		return false;
	}

	/**
	 * Delete an existing Student in the repository with the values represented by
	 * the ID.
	 * 
	 * @param id the ID of student.
	 * @return true if row was deleted.
	 */
	public boolean deleteStudent(int id) {
		// TODO #7 Write an sql statement that deletes student from database.
		return false;
	}

	public void closeConnecion() {
		// TODO Close connection to the database server
	}

}
