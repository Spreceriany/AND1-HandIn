package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CharacterDAO {
    @Query("SELECT * FROM character")
    List<CharacterEntity> loadAllCharacters();


}
