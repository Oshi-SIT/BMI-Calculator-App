package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView edtRes;
        EditText edtWeight, edtHeightInch, edtHeightFt;
        Button edtBtn;
        LinearLayout main;

        edtRes = findViewById(R.id.edtRes);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightInch = findViewById(R.id.edtHeightInch);
        edtBtn = findViewById(R.id.edtBtn);
        main = findViewById(R.id.main);

        edtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int inch = Integer.parseInt(edtHeightInch.getText().toString());

                int totalInches = ((ft*12) + inch);
                double totalCm = totalInches*2.53;
                double totalM = totalCm/100;

                double BMI = wt/(Math.pow(totalM,2));

                if(BMI > 25)
                {
                    edtRes.setText("Motka Madharchod!");
                    main.setBackgroundColor(getResources().getColor(R.color.redOver));
                }
                else if(BMI<18)
                {
                    edtRes.setText("Haddi Bhosriwala!");
                    main.setBackgroundColor(getResources().getColor(R.color.yellowUnder));
                }
                else
                {
                    edtRes.setText("Yehi to Chahiye Bhenchod!");
                    main.setBackgroundColor(getResources().getColor(R.color.greenOk));
                }

            }
        });
    }
}