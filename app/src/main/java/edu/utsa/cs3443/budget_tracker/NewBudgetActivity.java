package edu.utsa.cs3443.budget_tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import edu.utsa.cs3443.budget_tracker.Model.Budgeter;
import edu.utsa.cs3443.budget_tracker.Model.PaycheckCalc;

public class NewBudgetActivity extends AppCompatActivity {
    SharedPreferences sp;
    float wants, needs, savings, week1, week2;
    String week1str, week2str;
    PaycheckCalc paycheck = new PaycheckCalc();
    Budgeter budget = Budgeter.getInstance();
    DecimalFormat df = new DecimalFormat("#.##");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbudget);
        EditText week1Hours = findViewById(R.id.week1ET);
        EditText week2Hours = findViewById(R.id.week2ET);
        TextView needsTV = findViewById(R.id.needsView);
        TextView grossPayTV = findViewById(R.id.grossPayTV);
        TextView wantsTV = findViewById(R.id.wantsView);
        TextView savingsTV = findViewById(R.id.savingsView);
        Button calculateButton = findViewById(R.id.calcBudget);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week1str = week1Hours.getText().toString();
                week2str = week2Hours.getText().toString();
                week1 = Float.parseFloat(week1str);
                week2 = Float.parseFloat(week2str);
                paycheck.setTotalhours(week1, week2);
                paycheck.grossPayCalc();
                double grossPay = paycheck.getGrossPay();
                budget.calcBudget(grossPay);
                wants = Float.parseFloat(df.format(budget.getWants()));
                needs = Float.parseFloat(df.format(budget.getNeeds()));
                savings = Float.parseFloat(df.format(budget.getSavings()));
                grossPay = Double.parseDouble(df.format(grossPay));

                needsTV.setText("$"+Float.toString(needs));
                wantsTV.setText("$"+Float.toString(wants));
                savingsTV.setText("$"+Float.toString(savings));
                grossPayTV.setText("$"+Double.toString(grossPay));

                SharedPreferences.Editor editor = sp.edit();

                editor.putFloat("needs",  needs);
                editor.putFloat("wants", wants);
                editor.commit();

            }
        });
    }

}
