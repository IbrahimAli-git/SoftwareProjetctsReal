package presenter;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.SQLException;

public interface Presenter {



    void onCreate(Connection con, int overallPerformance) throws Exception;

    int onCalculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception;

    void onRetrieve(Connection connection, int id) throws SQLException;

    void onUpdate(Connection connection, BufferedReader br) throws Exception;

    void onDelete(Connection connection, BufferedReader br) throws Exception;
}
