package view;

import presenter.MainPresenter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainView implements View {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/softwareprojectdatabase";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "WR*=ACHoXo0$c$j+wrlt";
    private MainPresenter mainPresenter;

    public static void main(String[] args) {

        System.out.println("Welcome to the program");
        System.out.println("Please choose an option below:");
        System.out.println("Enter 1 for evaluating overall performance:");
        System.out.println("Enter 2 for retrieving specific performances");
        System.out.println("Enter 3 for updating a student's performance");
        System.out.println("Enter 4 for deleting a student's record");
        System.out.println("---------------------------------------------------------");

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);)
        {
            MainView mainView = new MainView();


            System.out.println("Please enter option");
            int option = Integer.parseInt(bufferedReader.readLine());
            System.out.println();

            if (option == 1) {
                int attendance = 0;
                int courseWorkMarks = 0;
                int examMarks = 0;
                int overallPerformance = mainView.calculateOverallPerformance(bufferedReader, attendance, courseWorkMarks, examMarks);
                mainView.create(connection, overallPerformance);

            }
            if (option == 2) {
                System.out.println("Please enter student id:");
                int idOfStudent = Integer.parseInt(bufferedReader.readLine());
                mainView.retrieve(connection, idOfStudent);
            }
            if (option == 3) {
                mainView.update(connection, bufferedReader);
            }
            if (option == 4) {
                mainView.delete(connection, bufferedReader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(Connection con, int overallPerformance) throws Exception {
        mainPresenter.onCreate(con, overallPerformance);
    }

    public int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception {
        return mainPresenter.onCalculateOverallPerformance(bufferedReader, attendance, courseWorkMarks, examMarks);
    }

    public void retrieve(Connection connection, int id) throws SQLException {
        mainPresenter.onRetrieve(connection, id);
    }

    public void update(Connection connection, BufferedReader br) throws Exception {
        mainPresenter.onUpdate(connection, br);
    }

    public void delete(Connection connection, BufferedReader br) throws Exception {
        mainPresenter.onDelete(connection, br);
    }
}