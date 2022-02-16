package model;

import model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainModel implements Model {

    @Override
    public void create(Connection con, int overallPerformance) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO tbl1_software_projects(student_overall_performance) VALUES(" + overallPerformance + ")");

        ResultSet rs = st.executeQuery("SELECT * FROM tbl1_software_projects WHERE student_overall_performance = " + overallPerformance);

        while (rs.next()) {
            int studentId = rs.getInt(1);

            System.out.println("The student's id is" + studentId);

        }
        st.close();
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

        if (attendance > 80 && courseWorkMarks > 80 && examMarks > 80) {
            System.out.println("The academic performance of student is excellent");

        }
        int overallPerformance = (attendance + courseWorkMarks + examMarks) / 3;
        return overallPerformance;
    }

    @Override
    public void retrieve(Connection connection, int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM tbl1_software_projects WHERE student_id = " + id);

        while (resultSet.next()) {
            System.out.println("The student's overall performance is " + resultSet.getInt("student_overall_performance"));
        }
    }
    @Override
    public void update(Connection connection, BufferedReader br) throws SQLException, IOException {
        System.out.println("Please enter student's id:");
        System.out.println();
        int studentId = Integer.parseInt(br.readLine());

        System.out.println("Please enter student's performance:");
        System.out.println();
        int overallPerformance = Integer.parseInt(br.readLine());

        Statement st = connection.createStatement();
        st.executeUpdate("UPDATE tbl1_software_projects SET student_overall_performance = " + overallPerformance + " WHERE student_id = " + studentId);
        st.close();
        System.out.println("Student's record has updated successfully");
    }

    @Override
    public void delete(Connection connection, BufferedReader br) throws SQLException, IOException {
        System.out.println("Please enter student's id:");
        System.out.println();
        int studentId = Integer.parseInt(br.readLine());


        Statement st = connection.createStatement();
        st.execute("DELETE FROM tbl1_software_projects WHERE student_id = " + studentId);
        st.close();
        System.out.println("Student's record has deleted successfully");
    }
}
