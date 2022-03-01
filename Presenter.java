package presenter;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.SQLException;

public interface Presenter {

    void onCreate(int overallPerformance) throws Exception;

    int onCalculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception;

    void onRetrieve(int id) throws SQLException;

    void onUpdate(BufferedReader br) throws Exception;

    void onDelete(BufferedReader br) throws Exception;
}
