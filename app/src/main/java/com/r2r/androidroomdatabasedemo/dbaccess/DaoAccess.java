package com.r2r.androidroomdatabasedemo.dbaccess;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.r2r.androidroomdatabasedemo.model.Schools;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    void insertMultipleRecord(Schools... universities);

    @Insert
    void insertMultipleListRecord(List<Schools> universities);

    @Insert
    void insertOnlySingleRecord(Schools university);


    @Query("SELECT * FROM Schools")
    LiveData<List<Schools>> fetchAllData();

    @Query("SELECT * FROM Schools WHERE clgid =:college_id")
    Schools getSingleRecord(int college_id);

    @Update
    void updateRecord(Schools university);

    @Delete
    void deleteRecord(Schools university);
}