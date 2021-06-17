package com.example.vocab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    ArrayList<Word> words;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context, R.layout.list_wordlist);
        this.words=words;
    }

    @Override
    public int getCount() {

        return words.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());

        LinearLayout layout=(LinearLayout)inflater.inflate(R.layout.list_wordlist,null);

        TextView textname=layout.findViewById(R.id.textName);
        TextView textadjective=layout.findViewById(R.id.textAdjective);
        TextView textdescription=layout.findViewById(R.id.textDescription);

        Word word = words.get(position);
        textname.setText("Name:" + word.getName());
        textadjective.setText("Adjective:" + word.getAdjective());
        textdescription.setText("Description:" + word.getDescription());

        return layout;
    }

}
