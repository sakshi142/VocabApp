package com.example.vocab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class WordListActivity extends AppCompatActivity {

    ArrayList<Word> wordList = new ArrayList<>();
    ListView listView;
    WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordList.add(new Word("Quintessential", "adjective", "Of the nature of a quintessence (in all senses); ultimate."));
        wordList.add(new Word("Nonchalant", "adjective", " Casually calm and relaxed."));
        wordList.add(new Word("chauvinism", "adjective", "Excessive patriotism, eagerness for national superiority; jingoism."));
        wordList.add(new Word("chaperon", "adjective", "to accompany, to escort"));
        wordList.add(new Word("ambidextrous", "adjective", "(humorous) Of a person, bisexual."));

        adapter = new WordAdapter(this, wordList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word words = wordList.get(position);
                Intent intent = new Intent(WordListActivity.this, DetailWordListActivity.class);
                intent.putExtra("words", words);
                startActivity(intent);
            }
        });
    }

    public void onAdd(View v) {
        Intent intent = new Intent(this, AddWordListActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Word words = (Word) data.getSerializableExtra("word");

            //add words to the collection
            wordList.add(words);

            //refresh the list view to newly add words
            adapter.notifyDataSetChanged();
        }
    }
}