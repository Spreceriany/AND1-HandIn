package com.example.myapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.CharacterDAO;

import java.util.List;

public class CharacterRepository {
    private CharacterDAO characterDAO;
    private LiveData<List<Character>> allCharacters;

    public CharacterRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        characterDAO = database.characterDAO();
        allCharacters = (LiveData<List<Character>>) characterDAO.loadAllCharacters();
    }


    public LiveData<List<Character>> getAllCharacters(){
        return allCharacters;
    }
}
