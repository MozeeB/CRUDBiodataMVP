package com.mozeeb.crudmvp.main;

public class MainPresenter implements MainContruct.Presenter {

    private MainContruct.View view;

    public MainPresenter(MainContruct.View view) {
        this.view = view;
    }

    @Override
    public void seeAllBiodata() {
        view.goToListBiodata();

    }

    @Override
    public void addBiodata() {
        view.goToAddBiodata();

    }
}
