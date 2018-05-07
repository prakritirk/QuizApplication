/*
 * Author Prakriti Rajbhandari
 *
 * Project 3 Quiz App for Android Basics Nano Degree Program
 * In total there are 8 questions all related to Capitals.
 * Submit button calls submitAnswers that calculates result total and highlights all incorrectly answered questions.
 */

package com.example.android.quizapplication;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.InputFilter.AllCaps;

public class MainActivity extends AppCompatActivity {
    int rightAnswers = 0;


    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox Santiago, Valparaiso, LaPaz, Pretoria, CapeTown, Johannesburg;
    private EditText editTextQ5, editTextQ2;
    private DatePicker datePicker;
    private NumberPicker numberPicker;
    private TextView Question1, Question2, Question3, Question4, Question5, Question6, Question7, Question8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Question1 = (TextView) findViewById(R.id.q1);
        Question2 = (TextView) findViewById(R.id.q2);
        Question3 = (TextView) findViewById(R.id.q3);
        Question4 = (TextView) findViewById(R.id.q4);
        Question5 = (TextView) findViewById(R.id.q5);
        Question6 = (TextView) findViewById(R.id.q6);
        Question7 = (TextView) findViewById(R.id.q7);
        Question8 = (TextView) findViewById(R.id.q8);



        //Assigning Minimum and Maximum value for number picker//
        numberPicker = findViewById(R.id.numberPickerQ4);
        numberPicker.setMaxValue(5);
        numberPicker.setMinValue(0);
    }

    /**
     * Checks answers for all the questions, returns number of right answers.Highlights all the questions that were incorrectly answered.
     */
    public void submitAnswers(View view) {

        // Checking the answer for question No. 1//

        Santiago = (CheckBox) findViewById(R.id.checkBoxQ1_O2);
        Valparaiso = (CheckBox) findViewById(R.id.checkBoxQ1_O1);
        LaPaz = (CheckBox) findViewById(R.id.checkBoxQ1_O3);

        if (Santiago.isChecked() && Valparaiso.isChecked() && !LaPaz.isChecked()) {
            rightAnswers++;
        } else {
            Question1.setBackgroundColor(Color.parseColor("#F44336"));
        }
        //Checking the answer for question No. 2//
        editTextQ2 = (EditText) findViewById(R.id.editTextQ2);
        editTextQ2.setFilters(new InputFilter[]{new AllCaps()});
        if (editTextQ2.getText().toString().equalsIgnoreCase("DELHI") || editTextQ2.getText().toString().equalsIgnoreCase("NEW DELHI")) {
            rightAnswers++;
        } else {
            Question2.setBackgroundColor(Color.parseColor("#F44336"));
        }

        //Checking the answer for question No. 3//
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ3);
        radioButton = (RadioButton) findViewById(R.id.radioFalse);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == radioButton.getId()) {
            rightAnswers++;
        } else {
            Question3.setBackgroundColor(Color.parseColor("#F44336"));
        }

        //Checking the answer for question No. 4//
        if (numberPicker.getValue() == 2) {
            rightAnswers++;
        } else {
            Question4.setBackgroundColor(Color.parseColor("#F44336"));
        }

        // Checking the answer for question No. 5//

        editTextQ5 = (EditText) findViewById(R.id.editTextQ5);
        editTextQ5.setFilters(new InputFilter[]{new AllCaps()});
        if (editTextQ5.getText().toString().equalsIgnoreCase("VALLETTA")) {
            rightAnswers++;
        } else {
            Question5.setBackgroundColor(Color.parseColor("#F44336"));
        }

        //Checking the answer for question No. 6 //

        Pretoria = (CheckBox) findViewById(R.id.checkBoxQ6_O1);
        Johannesburg = (CheckBox) findViewById(R.id.checkBoxQ6_O2);
        CapeTown = (CheckBox) findViewById(R.id.checkBoxQ6_O3);


        if (Pretoria.isChecked() && CapeTown.isChecked() && !Johannesburg.isChecked()) {
            rightAnswers++;
        } else {
            Question6.setBackgroundColor(Color.parseColor("#F44336"));
        }

        //Checking the answer for question No. 7//

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ7);
        radioButton = (RadioButton) findViewById(R.id.radioGroupQ7_O1);
        selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == radioButton.getId()) {
            rightAnswers++;
        } else {
            Question7.setBackgroundColor(Color.parseColor("#F44336"));
        }

        //Checking the answer for question No. 8 //
        datePicker = (DatePicker) findViewById(R.id.DatePickerQ8);
        if ((datePicker.getMonth() == 5) && (datePicker.getDayOfMonth() == 24) && (datePicker.getYear() == 1976)) {
            rightAnswers++;
            Question8.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            Question8.setBackgroundColor(Color.parseColor("#F44336"));
        }

        //Toast to display result//
        //Get player's name//
        EditText player;
        player = (EditText) findViewById(R.id.playername);
        String playerName = player.getText().toString();
        Resources res = getResources();
        String resultMsg = res.getString(R.string.toastMessage, playerName, rightAnswers);
        Toast toast = Toast.makeText(this, resultMsg, Toast.LENGTH_LONG);
        toast.show();
        rightAnswers = 0;

        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(25);

    }
}
