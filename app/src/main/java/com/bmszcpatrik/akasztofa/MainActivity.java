package com.bmszcpatrik.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView textViewWord;
    private TextView textViewChar;
private Button buttonPrevChar, buttonNextChar, buttonSubmit;
private ImageView imageViewStage;
private List<String> words = new ArrayList<>();
private final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
private int letterStage = 0;
private String chosenWord;
private Random r = new Random();
private String usedChar = "";
private String placeholders = "";
private int stage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonPrevChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (letterStage == 0){
                    letterStage = 25;
                    textViewChar.setText(letters[letterStage]);
                    isUsed();
                }
                else{
                    letterStage--;
                    textViewChar.setText(letters[letterStage]);
                    isUsed();
                }
            }
        });
        buttonNextChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (letterStage == 25){
                    letterStage = 0;
                    textViewChar.setText(letters[letterStage]);
                    isUsed();
                }
                else{
                    letterStage++;
                    textViewChar.setText(letters[letterStage]);
                    isUsed();
                }
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usedChar += letters[letterStage];
                isUsed();

                if (chosenWord.contains(letters[letterStage])){
                    //textViewWord.setText("Letter found!");
                    for (int i = 0; i < chosenWord.length(); i++) {
                        if (String.valueOf(chosenWord
                                        .charAt(i))
                                        .equals(letters[letterStage]))
                        {
                            placeholders = placeholders.substring(0, i)
                                         + letters[letterStage]
                                         + placeholders.substring(i + 1);
                            textViewWord.setText(placeholders);
                            if (!placeholders.contains("_")){
                                Win();
                            }
                        }
                    }
                }
                else{
                    stage++;
                    if (stage == 13){
                        tookTheL();
                    }
                    switch (stage){
                        case 1: imageViewStage.setBackgroundResource(R.drawable.akasztofa01); break;
                        case 2: imageViewStage.setBackgroundResource(R.drawable.akasztofa02); break;
                        case 3: imageViewStage.setBackgroundResource(R.drawable.akasztofa03); break;
                        case 4: imageViewStage.setBackgroundResource(R.drawable.akasztofa04); break;
                        case 5: imageViewStage.setBackgroundResource(R.drawable.akasztofa05); break;
                        case 6: imageViewStage.setBackgroundResource(R.drawable.akasztofa06); break;
                        case 7: imageViewStage.setBackgroundResource(R.drawable.akasztofa07); break;
                        case 8: imageViewStage.setBackgroundResource(R.drawable.akasztofa08); break;
                        case 9: imageViewStage.setBackgroundResource(R.drawable.akasztofa09); break;
                        case 10: imageViewStage.setBackgroundResource(R.drawable.akasztofa10); break;
                        case 11: imageViewStage.setBackgroundResource(R.drawable.akasztofa11); break;
                        case 12: imageViewStage.setBackgroundResource(R.drawable.akasztofa12); break;
                        case 13: imageViewStage.setBackgroundResource(R.drawable.akasztofa13); break;
                    }
                    /*new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Nincs benne")
                            .setNegativeButton(android.R.string.no,null)
                            .show();*/
                }
            }
        });


    }
    private void newGame(){
        stage = 0;
        usedChar = "";
        placeholders = "";
        letterStage = 0;
        textViewChar.setText(letters[letterStage]);
        textViewChar.setTextColor(Color.BLACK);
        imageViewStage.setBackgroundResource(R.drawable.akasztofa00);
        getRandomWord();
    }
    private void init(){
        textViewWord = findViewById(R.id.textViewWord);
        textViewChar = findViewById(R.id.textViewChar);
        buttonPrevChar = findViewById(R.id.buttonPrevChar);
        buttonNextChar = findViewById(R.id.buttonNextChar);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        imageViewStage = findViewById(R.id.imageViewStage);
        stage = 0;

        textViewChar.setText("A");
        words.add("AUTO");
        words.add("HAJO");
        words.add("BICIKLI");
        words.add("TANK");
        words.add("GORDESZKA");
        words.add("GORKORCSOLYA");
        words.add("REPULO");
        words.add("HELIKOPTER");
        words.add("METRO");
        words.add("VILLAMOS");
        getRandomWord();
        // -------------------
    }

    private void isUsed(){
        if (usedChar.contains(letters[letterStage])){
            textViewChar.setTextColor(Color.RED);
        }
        else{
            textViewChar.setTextColor(Color.BLACK);
        }
    }
    private void Win(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Nyertel!")
                .setMessage("Kitalaltad a szot!")
                .setPositiveButton("Kovetkezo kor", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                }) //TODO: kovetkezo kor
                .setNegativeButton("Kilepes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })       //TODO: kilepes
                .show();


    }
    private void tookTheL(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Vesztettel!")
                .setMessage("Nem talaltad ki a szot!")
                .setPositiveButton("Kovetkezo kor", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setNegativeButton("Kilepes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();
    }
    private void getRandomWord(){
        int index = r.nextInt(9);
        //int index = 2;
        chosenWord = words.get(index);

        for (int i = 0; i < chosenWord.length(); i++) {
            placeholders += "_";
        }
        textViewWord.setText(placeholders);
        //textViewWord.setText(chosenWord);

    }
}