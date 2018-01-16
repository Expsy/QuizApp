package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int page = 1;
    int point = 0;
    boolean toggle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setVariables();

    }

    public void NextPage(View view) {

        if (page == 5) {
            if (toggle) {
                GetPoint();
                toggle = false;
            }
            Button nextButton = findViewById(R.id.next_button);
            nextButton.setText("Show Score");
            Toast.makeText(this, "Your score is: " + String.valueOf(point), Toast.LENGTH_LONG).show();

        }
        else {
            GetPoint();
            Log.v("Point increase:", " " + point);
            RadioGroup radioGroup = findViewById(R.id.radiogroup);
            radioGroup.clearCheck();
            page += 1;
        }


        setVariables();
    }

    public void setVariables () {

        TextView questionTextView = findViewById(R.id.question_text);
        ImageView icon1 = findViewById(R.id.icon1);
        ImageView icon2 = findViewById(R.id.icon2);
        ImageView icon3 = findViewById(R.id.icon3);
        ImageView icon4 = findViewById(R.id.icon4);
        CheckBox checkBox1 = findViewById(R.id.check1);
        CheckBox checkBox2 = findViewById(R.id.check2);
        CheckBox checkBox3 = findViewById(R.id.check3);
        CheckBox checkBox4 = findViewById(R.id.check4);
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        RadioButton radio3 = findViewById(R.id.radio3);
        RadioButton radio4 = findViewById(R.id.radio4);

        checkBox1.setVisibility(View.GONE);
        checkBox2.setVisibility(View.GONE);
        checkBox3.setVisibility(View.GONE);
        checkBox4.setVisibility(View.GONE);

        if (page == 1) {
            questionTextView.setText("Which ability icon belongs to Axe?");
            icon1.setImageResource(R.drawable.fireblast_icon);
            icon2.setImageResource(R.drawable.vacuum_icon);
            icon3.setImageResource(R.drawable.culling_blade_icon);
            icon4.setImageResource(R.drawable.meat_hook_icon);
        }
        else if (page == 2) {
            questionTextView.setText("How much does \"Desolator\" cost?");
            icon1.setVisibility(View.GONE);
            radio1.setText("3400G");
            icon2.setVisibility(View.GONE);
            radio2.setText("3200G");
            icon3.setVisibility(View.GONE);
            radio3.setText("3350G");
            icon4.setVisibility(View.GONE);
            radio4.setText("3500G");


        }
        else if (page == 3) {
            questionTextView.setText("Which one gives the most attack damage?");
            icon1.setVisibility(View.VISIBLE);
            radio1.setText("");
            icon2.setVisibility(View.VISIBLE);
            radio2.setText("");
            icon3.setVisibility(View.VISIBLE);
            radio3.setText("");
            icon4.setVisibility(View.VISIBLE);
            radio4.setText("");
            icon1.setImageResource(R.drawable.crystalys_icon);
            icon2.setImageResource(R.drawable.radiance_icon);
            icon3.setImageResource(R.drawable.butterfly_icon);
            icon4.setImageResource(R.drawable.battle_fury_icon);
        }
        else if (page == 4) {
            questionTextView.setText("Which one is an intelligence hero?");
            icon1.setImageResource(R.drawable.io_icon);
            icon2.setImageResource(R.drawable.earth_spirit_icon);
            icon3.setImageResource(R.drawable.meepo_icon);
            icon4.setImageResource(R.drawable.queen_of_pain_icon);
        }
        else if (page == 5) {

            radio1.setVisibility(View.GONE);
            radio2.setVisibility(View.GONE);
            radio3.setVisibility(View.GONE);
            radio4.setVisibility(View.GONE);
            checkBox1.setVisibility(View.VISIBLE);
            checkBox2.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.VISIBLE);

            questionTextView.setText("Which items increases your healt?");
            icon1.setImageResource(R.drawable.reaver_icon);
            icon2.setImageResource(R.drawable.refresher_orb_icon);
            icon3.setImageResource(R.drawable.hand_of_midas_icon);
            icon4.setImageResource(R.drawable.point_booster_icon);
        }
        else if (page == 6) {

            radio1.setVisibility(View.GONE);
            radio2.setVisibility(View.GONE);
            radio3.setVisibility(View.GONE);
            radio4.setVisibility(View.GONE);
            checkBox1.setVisibility(View.GONE);
            checkBox2.setVisibility(View.GONE);
            checkBox3.setVisibility(View.GONE);
            checkBox4.setVisibility(View.GONE);
            icon1.setVisibility(View.GONE);
            icon2.setVisibility(View.GONE);
            icon3.setVisibility(View.GONE);
            icon4.setVisibility(View.GONE);
            questionTextView.setVisibility(View.GONE);
        }

    }

    public void GetPoint() {

        CheckBox checkBox1 = findViewById(R.id.check1);
        CheckBox checkBox2 = findViewById(R.id.check2);
        CheckBox checkBox3 = findViewById(R.id.check3);
        CheckBox checkBox4 = findViewById(R.id.check4);
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        RadioButton radio3 = findViewById(R.id.radio3);
        RadioButton radio4 = findViewById(R.id.radio4);


        if (page == 1) {
            if (radio3.isChecked()) {
                point += 1;
            }
        }
        else if (page == 2) {
            if (radio4.isChecked()) {
                point += 1;
            }
        }
        else if (page == 3) {
            if (radio2.isChecked()) {
                point += 1;
            }
        }
        else if (page == 4) {
            if (radio4.isChecked()) {
                point += 1;
            }
        }
        else if (page == 5) {
            if (checkBox1.isChecked() && checkBox4.isChecked()) {
                point += 1;
            }
        }

    }

}
