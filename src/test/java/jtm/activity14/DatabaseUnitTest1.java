package jtm.activity14;

import jtm.TestUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseUnitTest1 {
    static StudentManager manager;
    static StudentManager mockedManager;
    static int id1;
    static Student test1, test2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        manager = new StudentManager();
        mockedManager = mock(StudentManager.class);
        id1 = 100;
        test1 = new Student(id1, "Name10", "Surname10");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        manager.closeConnecion();
    }

    @Test
    public void test00ChangeStudent() {
        test2 = new Student(0, "Name0", "Surname0");
        test2.setFirstName("Name20");
        test2.setLastName("Surname20");
        test2.setId(20);
        assertEquals(test2.getId(), 20);
        assertEquals(test2.toString(), "Name20 Surname20");
    }

    @Test
    public void test01InsertStudentStringString() {
        manager.insertStudent("Name", "Surname");
        List<Student> students = manager.findStudent("Name", "Surname");
        assertTrue(students.toString().contains("Name Surname"));
    }

    @Test
    public void test02InsertStudentStudent() {
        manager.insertStudent(test1);
        Student students = manager.findStudent(id1);
        assertTrue(students.toString().contains("Name10 Surname10"));
    }

    @Test
    public void test03FindStudentInt() {
        manager.findStudent(id1);
    }

    @Test
    public void test04FindStudentStringString() {
        manager.findStudent("Name", "Surname");
    }

    @Test
    public void test05UpdateStudent() {
        test2 = new Student(id1, "Name20", "Surname20");
        manager.updateStudent(test2);
    }

    @Test
    public void test06DeleteStudent() {
        manager.deleteStudent(id1);
        Student students = manager.findStudent(id1);
        assertTrue(students.toString().contains("null null"));
    }

    @Test
    public void test10NegativeTest() {
        try {
            StudentManager manager = new StudentManager();
            Connection mockedConn = Mockito.spy(DriverManager.getConnection(
                "jdbc:mysql://localhost/?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf8",
                TestUtils.user,
                TestUtils.password
            ));
            doThrow(new SQLException("Commit exception")).when(mockedConn).commit();
            doThrow(new SQLException("Close exception")).when(mockedConn).close();
            doThrow(new SQLException("Change autocommit exception")).when(mockedConn).setAutoCommit(Mockito.anyBoolean());
            doThrow(new SQLException("Rollback exception")).when(mockedConn).rollback();
            doThrow(new SQLException("Prepare statement exception")).when(mockedConn).prepareStatement(Mockito.anyString());
            doThrow(new SQLException("Prepare statement exception 2")).when(mockedConn).prepareStatement(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());
            manager.conn = mockedConn;

            manager.insertStudent("", "");
            manager.insertStudent(new Student(0, "", ""));
            manager.findStudent(0);
            manager.findStudent("", "");
            manager.updateStudent(new Student(0, "", ""));
            manager.deleteStudent(0);
            manager.closeConnecion();
        } catch (SQLException e) {
            System.err.println("Test10 Expected failure: " + Arrays.asList(e.getStackTrace()));
        } catch (Exception e) {
            System.err.println("Test10Failure: " + Arrays.asList(e.getStackTrace()));
        }
    }
}