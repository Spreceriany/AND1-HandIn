package com.example.myapplication.ui.quotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class QuotesFragment extends Fragment {
    private QuoteAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<QuoteItem> list;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quotes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.quoteRecView);
        recyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        fillList();
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new QuoteAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void fillList() {
        list = new ArrayList<>();
        list.add(new QuoteItem(R.drawable.sam, "\"I was living a lie... I was broken. but somewhere along the way, I started changing\" ", "Sam"));
        list.add(new QuoteItem(R.drawable.fragile, "\"I am Fragile, but not that fragile\"", "Fragile"));
        list.add(new QuoteItem(R.drawable.hearthman, "\"My body may be oresent but my soul is on the beach. I'm already dead\"", "Heartman"));
        list.add(new QuoteItem(R.drawable.higgs, "\"But I wonder, when you look death in the eye, will you blink?\"", "Higgs"));
        list.add(new QuoteItem(R.drawable.amelie, "\"A strand is a part of a rope or bond, while stranded means being washed up on the shore, and being stranded is when you can't go home \"", "Amelie"));
        list.add(new QuoteItem(R.drawable.diehardman, "\"Back then, I thought I was invincible. I thought I was some kind of action hero\"", " Diehard-man"));

        list.add(new QuoteItem(R.drawable.higgs, "\"The name's Higgs, the particle of god that permeates all existence \"", "Higgs"));

        list.add(new QuoteItem(R.drawable.fragile, "\"Humanity only has a hundred thousand years left, why not end it here, right now\"", "Fragile"));
    }


    public void onCreateOptionsMenu(Menu menu,MenuInflater menuInflater) {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}

