package presenter;

import model.MainModel;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.SQLException;

public class MainPresenter {
    private MainModel mainModel;

    public MainPresenter(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void onCreate(int overallPerformance) throws Exception {
        mainModel.create(overallPerformance);
    }

    public int onCalculateOverallPerformance(BufferedReader bufferedReader, int attendance, int courseWorkMarks, int examMarks) throws Exception {
        return mainModel.calculateOverallPerformance(bufferedReader, attendance, courseWorkMarks, examMarks);
    }

    public void onRetrieve(int id) throws SQLException {
        mainModel.retrieve(id);
    }

    public void onUpdate(BufferedReader br) throws Exception {
        mainModel.update(br);
    }

    public void onDelete(BufferedReader br) throws Exception {
        mainModel.delete(br);
    }
}
