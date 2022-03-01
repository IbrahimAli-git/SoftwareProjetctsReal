package view;

import presenter.MainPresenter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainView implements View {
    private MainPresenter mainPresenter;


    public MainView(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public void create(int overallPerformance) throws Exception {
        mainPresenter.onCreate(overallPerformance);
    }

    public int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception {
        return mainPresenter.onCalculateOverallPerformance(bufferedReader, attendance, courseWorkMarks, examMarks);
    }

    public void retrieve(int id) throws SQLException {
        mainPresenter.onRetrieve(id);
    }

    public void update(BufferedReader br) throws Exception {
        mainPresenter.onUpdate(br);
    }

    public void delete(BufferedReader br) throws Exception {
        mainPresenter.onDelete(br);
    }

    public void run() {
        System.out.println("Welcome to the program");
        System.out.println("Please choose an option below:");
        System.out.println("Enter 1 for evaluating overall performance:");
        System.out.println("Enter 2 for retrieving specific performances");
        System.out.println("Enter 3 for updating a student's performance");
        System.out.println("Enter 4 for deleting a student's record");
        System.out.println("---------------------------------------------------------");

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));)
        {
            System.out.println("Please enter option");
            int option = Integer.parseInt(bufferedReader.readLine());
            System.out.println();

            if (option == 1) {
                int attendance = 0;
                int courseWorkMarks = 0;
                int examMarks = 0;
                int overallPerformance = calculateOverallPerformance(bufferedReader, attendance, courseWorkMarks, examMarks);
                create(overallPerformance);

            }
            if (option == 2) {
                System.out.println("Please enter student id:");
                int idOfStudent = Integer.parseInt(bufferedReader.readLine());
                retrieve(idOfStudent);
            }
            if (option == 3) {
                update(bufferedReader);
            }
            if (option == 4) {
                delete(bufferedReader);
            }
        } catch (Exception e) {
            System.out.println("Error performing operations \n Please try again");
        }
    }

}
