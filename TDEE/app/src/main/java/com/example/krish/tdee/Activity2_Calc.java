package com.example.krish.tdee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Activity2_Calc extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    /*Switches back to Main_Activity*/
                    startActivity(new Intent(getApplicationContext(), MainActivity_Tdee.class));
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2__calc);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void calculate1 (View v){
        EditText heightView = (EditText) findViewById(R.id.height1);
        String height = heightView.getText().toString();
        EditText weightView = (EditText) findViewById(R.id.weight1);
        String weight = weightView.getText().toString();
        EditText ageView = (EditText) findViewById(R.id.age1);
        String age = ageView.getText().toString();

        RadioGroup radio_group = (RadioGroup) findViewById(R.id.gender);
        //get selected radio button(male or female) from the radiogroup(gender)
        int selectedID = radio_group.getCheckedRadioButtonId();

        //finds the radiobutton that was clicked (by the id)
        //RadioButton radio_button = (RadioButton) findViewById(selectedID);

        Boolean gender_boolean = false; //false means female
        if(selectedID == R.id.male1){
            gender_boolean = true;
        }
        MainCalculation calc = new MainCalculation(weight, height, age, gender_boolean);

        //gets BMI and BMR and puts it as a String
        String bMI1 = calc.getBMI();
        String bMR1 = calc.getBMR();

        ((TextView) findViewById(R.id.output1)).setText("BMI: " + bMI1 + "\nBMR: " + bMR1);
    }

//    public void pooClicked (View view) {
//        startActivity(new Intent(getApplicationContext(), Activity2_Calc.class));
//    }


//        EditText weightView = (EditText) findViewById(R.id.weightBox);
//        String weight = weightView.getText().toString();
//        EditText heightView = (EditText) findViewById(R.id.heightBox);
//        String height = heightView.getText().toString();
//
//        BMIModel myModel = new BMIModel(weight, height);
//        String myBMI = myModel.getBMI();
//
//        ((TextView) findViewById(R.id.answer)).setText(myBMI);




}
