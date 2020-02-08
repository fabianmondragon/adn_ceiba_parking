package com.example.parkingapp.data;

import android.os.AsyncTask;

import com.example.parkingapp.BaseApplication;

public class TaskDataBase extends AsyncTask<Void, Void , String > {

    RoomResponds roomResponds;
    @Override
    protected String doInBackground(Void... voids) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.motorCycleDao().getAll();
        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);

        roomResponds.setResult("hola");
    }


}
