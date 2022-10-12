package com.example.basicnoteappmaybe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutVertical;

    Button buttonSaveData;
    Button buttonDeleteData;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutVertical = findViewById(R.id.linearLayoutVertical);

        buttonSaveData = findViewById(R.id.buttonSaveData);

        editText = findViewById(R.id.editTextData);

        buttonDeleteData = findViewById(R.id.buttonDelete);

        buttonSaveData.setOnClickListener(view -> addLabel());

        buttonDeleteData.setOnClickListener(view -> deleteWidgets());
    }

    public void addLabel(){

        //create textview of text that user wants to save
        CheckBox cb = new CheckBox(getApplicationContext());
        cb.setText(editText.getText());
        cb.setTextIsSelectable(true);



        //add widget to vertical linearLayout parent
        linearLayoutVertical.addView(cb);

    }

    public void deleteWidgets(){
        int count = linearLayoutVertical.getChildCount();

        for(int i = 0; i < count; i++){
            if(linearLayoutVertical.getChildAt(i) instanceof CheckBox){
                if(((CheckBox)linearLayoutVertical.getChildAt(i)).isChecked()) {
                    linearLayoutVertical.removeView(linearLayoutVertical.getChildAt(i));
                }
            }
        }
    }
}