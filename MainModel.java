package model;

import model.Model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

public class MainModel implements Model, Closeable {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/softwareprojectdatabase";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "WR*=ACHoXo0$c$j+wrlt";
    private static final Connection con = null;
    private Statement st;
    private ResultSet rs;


    private static Connection getCon() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    @Override
    public void create(int overallPerformance) throws SQLException {
        st = getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        st.executeUpdate("INSERT INTO software_projects_overall_performance(student_overall_performance) VALUES(" + overallPerformance + ")");

        ResultSet rs = st.executeQuery("SELECT * FROM software_projects_overall_performance WHERE student_overall_performance = " + overallPerformance);
        rs.last();
        int studentId = rs.getInt(1);
        System.out.println("The student's id is " + studentId);
    }

    @Override
    public int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws IOException {
        System.out.println("Please enter attendance marks");
        attendance = Integer.parseInt(bufferedReader.readLine());
        System.out.println();

        System.out.println("Please enter coursework marks");
        courseWorkMarks = Integer.parseInt(bufferedReader.readLine());
        System.out.println();

        System.out.println("Please enter examination marks");
        examMarks = Integer.parseInt(bufferedReader.readLine());
        System.out.println();

        int overallPerformance = (int) ((int)(attendance * 0.2) + (courseWorkMarks * 0.4)+ (examMarks * 0.4));
        System.out.println("The student's overall performance is " + overallPerformance);
        return overallPerformance;
    }

    @Override
    public void retrieve(int id) throws SQLException {
        st = getCon().createStatement();
        rs = st.executeQuery("SELECT * FROM software_projects_overall_performance WHERE student_id = " + id);

        while (rs.next()) {
            System.out.println("The student's overall performance is " + rs.getInt("student_overall_performance"));
        }
    }
    @Override
    public void update( BufferedReader br) throws SQLException, IOException {
        System.out.println("Please enter student's id:");
        System.out.println();
        int studentId = Integer.parseInt(br.readLine());

        System.out.println("Please enter student's performance:");
        System.out.println();
        int overallPerformance = Integer.parseInt(br.readLine());

        st = getCon().createStatement();
        st.executeUpdate("UPDATE software_projects_overall_performance SET student_overall_performance = " + overallPerformance + " WHERE student_id = " + studentId);
        System.out.println("Student's record has updated successfully");
    }

    @Override
    public void delete(BufferedReader br) throws SQLException, IOException {
        System.out.println("Please enter student's id:");
        System.out.println();

        int studentId = Integer.parseInt(br.readLine());

        st = getCon().createStatement();
        st.execute("DELETE FROM software_projects_overall_performance WHERE student_id = " + studentId);
        System.out.println("Student's record has deleted successfully");
    }

    @Override
    public void close() throws IOException {
        try {
            getCon().close();
            st.close();
            rs.close();
        } catch (SQLException e) {
        }
    }
}
