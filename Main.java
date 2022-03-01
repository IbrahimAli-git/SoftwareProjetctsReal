package com.company;

import model.MainModel;
import presenter.MainPresenter;
import view.MainView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        MainPresenter mainPresenter = new MainPresenter(mainModel);
        MainView mainView = new MainView(mainPresenter);

        mainView.run();
        
        try {
            mainModel.close();
        } catch (IOException e) {
        }
    }
}

