package com.example.myapplication.ui.quotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.character.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> implements Filterable {
    private List<QuoteItem> mQuoteList;
    private List<QuoteItem> listFull;

    QuoteAdapter(List<QuoteItem> quoteList) {
        this.mQuoteList = quoteList;
        listFull = new ArrayList<>(mQuoteList);
    }

    static class QuoteViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView character_name;
        public TextView quote;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.quote_image);
            character_name = itemView.findViewById(R.id.quote_name);
            quote = itemView.findViewById(R.id.quote);
        }
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_item, parent, false);
        QuoteViewHolder quoteViewHolder = new QuoteViewHolder(view);
        return quoteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
       QuoteItem currentItem = mQuoteList.get(position);
       holder.imageView.setImageResource(currentItem.getImageResource());
       holder.quote.setText(currentItem.getQuote());
       holder.character_name.setText(currentItem.getQuoteName());
    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    @Override
    public Filter getFilter() {
        return quoteFilter;
    }

    private final Filter quoteFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<QuoteItem> filteredList = new ArrayList<>();


            if(constraint == null || constraint.length() == 0){   //showing all items
                filteredList.addAll(listFull);

            } else{
                String filterPattern = constraint.toString().toLowerCase().trim(); // not case sensitive string
                for (QuoteItem item : listFull) {
                    if(item.getQuote().toLowerCase().contains(filterPattern) || item.getQuoteName().toLowerCase().contains(filterPattern))  {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mQuoteList.clear();
            mQuoteList.addAll( (List) results.values);
            notifyDataSetChanged();
        }
    };
}
