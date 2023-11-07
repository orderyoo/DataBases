package com.example.databases;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM `group`")
    List<Group> getAll();

    @Query("SELECT * FROM `group` WHERE name_group IN (:id)")
    List<Group> loadAllByIds(int[] id);

    @Query("SELECT * FROM `group` WHERE name_group LIKE :first AND " + "list_student LIKE :last LIMIT 1")
    Group findByName(String first, String last);

    @Insert(entity = Group.class)
    void insertAll(Group... groups);

    @Update
    public void update(Group group);

    @Delete
    void delete(Group group);
}