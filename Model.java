package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Model {

    void create(Connection con, int overallPerformance) throws SQLException;
    int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws IOException;
    void update(Connection connection, BufferedReader br) throws SQLException, IOException;
    void delete(Connection connection, BufferedReader br) throws SQLException, IOException;
    void retrieve(Connection connection, int id) throws SQLException;
}
