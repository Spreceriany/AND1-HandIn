package com.example.myapplication.ui.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

public class CharacterFragment extends Fragment{

    public List<String> names;
    public List<Integer> images;
    CharacterAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_characters, container,false);
        RecyclerView recyclerView = view.findViewById(R.id.characterRecView);

        names = new ArrayList<>();
        images = new ArrayList<>();

        adapter = new CharacterAdapter(getActivity(),names,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        setNamesAndImages();

        return  view;
    }

    public void setNamesAndImages(){

        names.add("Sam");
        names.add("Fragile");
        names.add("Deadman");
        names.add("Mama");
        names.add("Diehardman");
        names.add("Higgs");
        names.add("Amelie");
        names.add("Cliff");
        names.add("Lockne");
        names.add("Hearthman");

        images.add(R.drawable.sam);
        images.add(R.drawable.fragile);
        images.add(R.drawable.deadman);
        images.add(R.drawable.mama);
        images.add(R.drawable.diehardman);
        images.add(R.drawable.higgs);
        images.add(R.drawable.amelie);
        images.add(R.drawable.cliff);
        images.add(R.drawable.lockne);
        images.add(R.drawable.hearthman);
    }


}
