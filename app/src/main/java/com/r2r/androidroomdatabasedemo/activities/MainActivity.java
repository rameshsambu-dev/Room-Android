package com.r2r.androidroomdatabasedemo.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.r2r.androidroomdatabasedemo.R;
import com.r2r.androidroomdatabasedemo.dbaccess.DBHelper;
import com.r2r.androidroomdatabasedemo.model.School;
import com.r2r.androidroomdatabasedemo.model.Schools;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = Room.databaseBuilder(getApplicationContext(),
                DBHelper.class, "sample-db").build();

        new DatabaseAsync().execute();

        LiveData<List<Schools>> school = dbHelper.daoAccess().fetchAllData();
        school.observe(this, new Observer<List<Schools>>() {
            @Override
            public void onChanged(@Nullable List<Schools> universities) {
                //Update your UI here.
            }
        });
    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //Let's add some dummy data to the database.
            Schools university = new Schools();
            university.setName("ABCSCHOOL");

            School college = new School();
            college.setId(1);
            college.setName("ABC INTERNATIONAL");

            university.setSchool(college);

            //Now access all the methods defined in DaoAccess with dbHelper object
            dbHelper.daoAccess().insertOnlySingleRecord(university);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }
    }
}
