package com.r2r.androidroomdatabasedemo.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Schools {

    @PrimaryKey(autoGenerate = true)
    private int slNo;
    private String name;

    @Embedded(prefix = "school")
    School college;

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return college;
    }

    public void setSchool(School college) {
        this.college = college;
    }
}