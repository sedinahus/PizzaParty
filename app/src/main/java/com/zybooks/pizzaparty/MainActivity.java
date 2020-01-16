package com.zybooks.pizzaparty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public final int SLICES_PER_PIZZA = 8;

    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mHowHungryRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Yay!");
        setContentView(R.layout.activity_main);
        mNumAttendEditText = findViewById(R.id.attendEditText);
        mNumPizzasTextView = findViewById(R.id.answerTextView);
        mHowHungryRadioGroup = findViewById(R.id.hungryRadioGroup);

    }

    public void calculateClick(View view){
        String numAttendStr = mNumAttendEditText.getText().toString();
        int numAttend = Integer.parseInt(numAttendStr);

        int slicesPerPerson = 0;
        int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
        if(checkedId == R.id.lightRadioButton){
            slicesPerPerson = 2;
        }
        else if (checkedId == R.id.mediumRadioButton){
            slicesPerPerson = 3;
        }
        else if (checkedId == R.id.ravenousRadioButton){
            slicesPerPerson = 4;
        }
        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
    }
}
