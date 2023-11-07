package com.example.databases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Group implements Serializable {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name_group")
    public String name_group;

    @ColumnInfo(name = "list_student")
    public String listStudents;

    public Group (int id, String name_group, String listStudents){
        this.id = id;
        this.name_group = name_group;
        this.listStudents = listStudents;
    }
}

