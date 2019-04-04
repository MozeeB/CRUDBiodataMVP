package com.mozeeb.crudmvp.update;

public interface UpdateContruct {
    interface View{
        void updateSuccess(String message);
        void updateFailed(String message);
    }

    interface Presenter{
        void updateData(String id, String nama, String kelas, String email);
    }
}
