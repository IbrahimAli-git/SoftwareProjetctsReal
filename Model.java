package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Model {

    void create(int overallPerformance) throws SQLException;
    int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws IOException;
    void update(BufferedReader br) throws SQLException, IOException;
    void delete(BufferedReader br) throws SQLException, IOException;
    void retrieve(int id) throws SQLException;
}

