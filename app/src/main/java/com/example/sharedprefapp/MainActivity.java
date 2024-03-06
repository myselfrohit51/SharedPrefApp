package com.example.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        //onCreate() will be called while starting the app but once app is started and user have entered something in
        //edittext then after closing the app DisplaySavedText() will show the saved value.
        DisplaySavedText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText.getText().toString();
                DisplaAndSaveText(text);
            }
        });
    }

    private void DisplaySavedText(){
        //retrieving the value from sharedpref

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        String s1=sharedPreferences.getString("name","");

        textView.setText(s1);
    }

    private void DisplaAndSaveText(String text) {

        //display the text
        textView.setText(text);

        //saving the Text into sharedPreferences
        SharedPreferences sharedPreferences=getSharedPreferences("MySharedPref",MODE_PRIVATE);

        //writing data to shared pref
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("name",text);

        //once changes is made we have to commit the changes
        editor.commit();



    }


}