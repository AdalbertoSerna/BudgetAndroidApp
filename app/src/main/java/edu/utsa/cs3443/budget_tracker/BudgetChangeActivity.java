package edu.utsa.cs3443.budget_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.budget_tracker.Model.Budgeter;

public class BudgetChangeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticvity_budgetchange);

        Button applyButton = findViewById(R.id.changeButton);
        EditText needsEdit = findViewById(R.id.editTextNumber);
        EditText wantEdit = findViewById(R.id.editTextNumber2);
        EditText savingEdit = findViewById(R.id.editTextNumber3);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String needsStr = needsEdit.getText().toString();
                String wantsStr = wantEdit.getText().toString();
                String savingsStr = savingEdit.getText().toString();
                if(savingsStr.equals("") || needsStr.equals("") || wantsStr.equals("")){
                    Toast t = Toast.makeText(BudgetChangeActivity.this , "Please fill in all the fields",Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    float needs = Float.parseFloat(needsStr);
                    float wants = Float.parseFloat(wantsStr);
                    float savings = Float.parseFloat(savingsStr);

                    if(needs+wants+savings != 100){
                        Toast t = Toast.makeText(BudgetChangeActivity.this , "Your budget numbers must equal 100",Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else {
                        Budgeter budgeter = Budgeter.getInstance(needs, wants, savings);
                    }

                }
            }
        });


    }

}
