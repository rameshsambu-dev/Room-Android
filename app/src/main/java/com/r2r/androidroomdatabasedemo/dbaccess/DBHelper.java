package com.r2r.androidroomdatabasedemo.dbaccess;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.r2r.androidroomdatabasedemo.model.Schools;

@Database(entities = {Schools.class}, version = 1)
public abstract class DBHelper extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}