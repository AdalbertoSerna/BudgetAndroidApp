package edu.utsa.cs3443.budget_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button continueButton = findViewById(R.id.continueButton);
        Button newBudgetButton = findViewById(R.id.newbudgetButton);
        Button applyButton = findViewById(R.id.changeButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if(button.getText().equals("Continue")){
                    Intent i = new Intent(MainActivity.this, OldBudgetActivity.class);
                    startActivity(i);
                }

            }
        });
        newBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if(button.getText().equals("New Budget")){
                    Intent i = new Intent(MainActivity.this, NewBudgetActivity.class);
                    startActivity(i);
                }

            }
        });
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BudgetChangeActivity.class);
                startActivity(i);

            }
        });

    }
}