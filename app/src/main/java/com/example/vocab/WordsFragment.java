package com.example.vocab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vocab.utils.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.BuildConfig;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.Builders;

import java.util.ArrayList;

public class WordsFragment extends Fragment {
    ListView listView;
    WordAdapter adapter;
    ArrayList<Word>words=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_words,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.listView);
        adapter=new  WordAdapter(getActivity(),words);
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        String url= Utils.createURL("http://192.168.0.105:7000/word/add");
        Ion.with(this)
                .load("POST",url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        String status =result.get("status").getAsString();

                        if(status.equals("success")) {

                            words.clear();

                            JsonArray data = result.get("data").getAsJsonArray();

                            for (int index = 0; index < data.size(); index++) {

                                JsonObject object = data.get(index).getAsJsonObject();

                                Word word = new Word();
                                word.setName(object.get("name").getAsString());
                                word.setAdjective(object.get("adjective").getAsString());
                                word.setDescription(object.get("description").getAsString());

                                words.add(word);
                            }

                            adapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(getActivity(), "Error While Loading Word", Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}
