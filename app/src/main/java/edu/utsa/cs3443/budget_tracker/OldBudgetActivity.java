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


public class OldBudgetActivity extends AppCompatActivity {
    float wants, needs;
    TextView wantsTV, needsTV;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldbudget);
        Button subButton;
        EditText wantsSpent, needsSpent;
        wantsSpent = findViewById(R.id.editViewWants);
        needsSpent = findViewById(R.id.editViewNeeds);
        subButton = findViewById(R.id.subtractButton);
        needsTV = findViewById(R.id.savingsTV);
        wantsTV = findViewById(R.id.wantsTV);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
         wants = Float.parseFloat(df.format(sp.getFloat("wants",0)));
         needs = Float.parseFloat(df.format(sp.getFloat("needs",0)));

        needsTV.setText("$"+Float.toString(needs));
        wantsTV.setText("$"+Float.toString(wants));

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float temp1, temp2;
               String wantsStr = wantsSpent.getText().toString();
               String needsStr = needsSpent.getText().toString();
               if(needsStr.equals("")){
                   temp2 = 0;
               }
               else{
                   temp2 = Float.parseFloat(needsStr);
               }
               if(wantsStr.equals("")){
                   temp1 = 0;
               }
               else {
                   temp1 = Float.parseFloat(wantsStr);
               }
               subFromBudget(temp1, temp2, editor);
            }

        });


    }
    public void subFromBudget(float subWants, float subNeeds, SharedPreferences.Editor editor){
        wants -= subWants;
        needs -= subNeeds;
        wantsTV.setText("$"+Float.toString(wants));
        needsTV.setText("$"+Float.toString(needs));
        editor.putFloat("needs", needs);
        editor.putFloat("wants", wants);
        editor.commit();

    }
}
