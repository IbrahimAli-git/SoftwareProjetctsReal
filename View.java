package view;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.SQLException;

public interface View {


    void create(int overallPerformance) throws Exception;

    int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception;

    void retrieve(int id) throws SQLException;

    void update(BufferedReader br) throws Exception;

    void delete(BufferedReader br) throws Exception;
}

