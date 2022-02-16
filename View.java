package view;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.SQLException;

public interface View {


    void create(Connection con, int overallPerformance) throws Exception;

    int calculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception;

    void retrieve(Connection connection, int id) throws SQLException;

    void update(Connection connection, BufferedReader br) throws Exception;

    void delete(Connection connection, BufferedReader br) throws Exception;
}
