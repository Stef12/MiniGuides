package com.example.miniguides;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RouteActivity extends AppCompatActivity {

    // Local variables
    private ImageButton backButton;
    private TextView inst_step_1, inst_step_2, inst_step_3, inst_step_4, inst_step_5, inst_step_6;
    // List of steps for each guide
    private String[] steps = {
            "Druk op de app 'Maps' tussen je apps.",
            "Rechts in het midden van je scherm, druk op de blauwe knop 'GA'.",
            "Druk bovenin het scherm op 'Kies je vertrek punt' en vul je vertrekpunt in.",
            "Druk vervolgens daaronder op 'Kies je bestemming' en vul je bestemming in.",
            "Je kunt meteen daaronder je vervoersmiddel kiezen door een van de iconen te drukken.",
            "Je route is nu berekent!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steps_routes);

        // Initialize the local variables
        inst_step_1 = findViewById(R.id.step1_instruction_id);
        inst_step_2 = findViewById(R.id.step2_instruction_id);
        inst_step_3 = findViewById(R.id.step3_instruction_id);
        inst_step_4 = findViewById(R.id.step4_instruction_id);
        inst_step_5 = findViewById(R.id.step5_instruction_id);
        inst_step_6 = findViewById(R.id.step6_instruction_id);

        // Add steps to the views
        inst_step_1.setText(steps[0]);
        inst_step_2.setText(steps[1]);
        inst_step_3.setText(steps[2]);
        inst_step_4.setText(steps[3]);
        inst_step_5.setText(steps[4]);
        inst_step_6.setText(steps[5]);


        // Add button(onClick) to return to the previous activity
        backButton = findViewById(R.id.backButton_id);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
