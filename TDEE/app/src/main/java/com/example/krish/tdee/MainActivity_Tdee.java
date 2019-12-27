package com.example.krish.tdee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_Tdee extends AppCompatActivity {

    private TextView mTextMessage;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };
private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                //mTextMessage.setText(R.string.title_home);
                mTextMessage.setText("Welcome to TDEE\nPlease click the button to get started!");
                return true;
            case R.id.navigation_dashboard:

                //mTextMessage.setText(R.string.title_dashboard);
                /*Switches to Activity2 for Calculations*/
                startActivity(new Intent(getApplicationContext(), Activity2_Calc.class));
                return true;
            case R.id.navigation_notifications:
                //mTextMessage.setText(R.string.title_notifications);
                return true;
        }
        return false;
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tdee);

        mTextMessage = (TextView) findViewById(R.id.message1);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //TESTING
        mTextMessage.setText("wooooooooooooooooooooooooo");
    }
        public void pooClicked (View view) {
            startActivity(new Intent(getApplicationContext(), Activity2_Calc.class));
        }

        /*****************************************/
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
//startActivity(new Intent(getApplicationContext(), Activity2.class));

