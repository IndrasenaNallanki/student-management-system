package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() {
        conn = DBConnection.getConnection();
    }

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        stmt.setString(3, student.getGrade());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Student s = new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("grade")
            );
            list.add(s);
        }
        return list;
    }

    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        stmt.setString(3, student.getGrade());
        stmt.setInt(4, student.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
}
