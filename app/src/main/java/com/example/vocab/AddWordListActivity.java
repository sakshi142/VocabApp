package com.example.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddWordListActivity extends AppCompatActivity {
    EditText editTextName,editTextAdjective,editTextDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word_list);

        editTextName=findViewById(R.id.Name);
        editTextAdjective=findViewById(R.id.Adjective);
        editTextDescription=findViewById(R.id.Description);
    }

    public void onAdd(View view){
        String name=editTextName.getText().toString();
        String adjective=editTextAdjective.getText().toString();
        String description=editTextDescription.getText().toString();

        Word word=new Word(name,adjective,description);
        Intent intent=new Intent();
        intent.putExtra("words",word);
        setResult(0,intent);
        finish();
    }

    public void onBack(View view){
      finish();
    }
}