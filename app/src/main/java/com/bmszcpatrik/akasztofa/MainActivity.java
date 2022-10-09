package com.bmszcpatrik.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textViewWord, textViewChar;
private Button buttonPrevChar, buttonNextChar, buttonSubmit;
private ImageView imageViewStage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        textViewWord = findViewById(R.id.textViewWord);
        textViewChar = findViewById(R.id.textViewChar);
        buttonPrevChar = findViewById(R.id.buttonPrevChar);
        buttonNextChar = findViewById(R.id.buttonNextChar);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        imageViewStage = findViewById(R.id.imageViewStage);


    }
}