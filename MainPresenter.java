package presenter;

import model.MainModel;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.SQLException;

public class MainPresenter {
    private MainModel mainModel;

    public void onCreate(Connection con, int overallPerformance) throws Exception {
        mainModel.create(con, overallPerformance);
    }

    public int onCalculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception {
        return mainModel.calculateOverallPerformance(bufferedReader, attendance, courseWorkMarks, examMarks);
    }

    public void onRetrieve(Connection connection, int id) throws SQLException {
        mainModel.retrieve(connection, id);
    }

    public void onUpdate(Connection connection, BufferedReader br) throws Exception {
        mainModel.update(connection, br);
    }

    public void onDelete(Connection connection, BufferedReader br) throws Exception {
        mainModel.delete(connection, br);
    }
}
