package com.example.android.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import junit.runner.BaseTestRunner;

public class MainActivity extends AppCompatActivity {
    int rightAnswers = 0;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox Kathmandu, Brussels;
    private EditText editTextQ5, editTextQ2;
    private DatePicker datePicker;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assigning Minimum and Maximum value for number picker//

        numberPicker = findViewById(R.id.numberPickerQ4);
        numberPicker.setMaxValue(5);
        numberPicker.setMinValue(0);
    }

    public void submitAnswers(View view) {


        // Checking the answer for question No. 1//
        Kathmandu = (CheckBox) findViewById(R.id.checkBoxQ1_O3);

        if (Kathmandu.isChecked()) {
            rightAnswers++;
        }
        //Checking the answer for question No. 2//
        editTextQ2 = (EditText) findViewById(R.id.editTextQ2);
        if (editTextQ2.getText().toString().equals("Delhi") || editTextQ2.getText().toString().equals("New Delhi")) {
            rightAnswers++;
        }

        //Checking the answer for question No. 3//
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ3);
        radioButton = (RadioButton) findViewById(R.id.radioFalse);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == radioButton.getId()) {
            rightAnswers++;
        }


        //Checking the answer for question No. 4//
        if (numberPicker.getValue() == 2) {
            rightAnswers++;
        }


        // Checking the answer for question No. 5//

        editTextQ5 = (EditText) findViewById(R.id.editTextQ5);
        if (editTextQ5.getText().toString().equals("Valletta")) {
            rightAnswers++;
        }

        //Checking the answer for question No. 6 //

        Brussels = (CheckBox) findViewById(R.id.checkBoxQ6_O2);


        if (Brussels.isChecked()) {
            rightAnswers++;
        }


        //Checking the answer for question No. 7//

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ7);
        radioButton = (RadioButton) findViewById(R.id.radioGroupQ7_O1);
        selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == radioButton.getId()) {
            rightAnswers++;
        }


        //Checking the answer for question No. 8 //
        datePicker = (DatePicker) findViewById(R.id.DatePickerQ8);
        if ((datePicker.getMonth() == 7) && (datePicker.getDayOfMonth() == 16) && (datePicker.getYear() == 1790)) {
            rightAnswers++;
        }


        //Toast to display result//

        Toast toast = Toast.makeText(this, "You answered " + rightAnswers + " questions correctly out of 8.", Toast.LENGTH_LONG);
        toast.show();
        rightAnswers = 0;

        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(25);

    }
}
