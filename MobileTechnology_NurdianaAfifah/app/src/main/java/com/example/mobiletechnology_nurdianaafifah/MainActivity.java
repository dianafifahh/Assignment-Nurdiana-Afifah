package com.example.mobiletechnology_nurdianaafifah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText vehiclePrice, downPayment, loanPeriod, interestRate;
    private Button calcBtn;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        Button homeBtn = findViewById(R.id.btnHome);
        Button aboutBtn = findViewById(R.id.btnAbout);

        homeBtn.setOnClickListener(v -> {
        });

        aboutBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
        });

        vehiclePrice = findViewById(R.id.inputVehiclePrice);
        downPayment = findViewById(R.id.inputDownPayment);
        loanPeriod = findViewById(R.id.inputLoanPeriod);
        interestRate = findViewById(R.id.inputInterestRate);
        calcBtn = findViewById(R.id.calcBtn);
        resultText = findViewById(R.id.resultText);

        calcBtn.setOnClickListener(v -> calculateLoan());
    }

    private void calculateLoan() {
        try {
            String priceStr = vehiclePrice.getText().toString();
            String downStr = downPayment.getText().toString();
            String yearsStr = loanPeriod.getText().toString();
            String rateStr = interestRate.getText().toString();

            // Check empty fields
            if (priceStr.isEmpty() || downStr.isEmpty() || yearsStr.isEmpty() || rateStr.isEmpty()) {
                resultText.setText("Please fill in all fields.");
                return;
            }

            double price = Double.parseDouble(priceStr);
            double down = Double.parseDouble(downStr);
            double years = Double.parseDouble(yearsStr);
            double rate = Double.parseDouble(rateStr);

            // New validation: down payment cannot exceed vehicle price
            if (down > price) {
                resultText.setText("Error: Down payment cannot be greater than vehicle price.");
                return;
            }

            if (price < down) {
                resultText.setText("Error: Vehicle price cannot be lower than down payment.");
                return;
            }

            // Continue only if valid
            double loanAmount = price - down;
            double totalInterest = loanAmount * (rate / 100) * years;
            double totalPayment = loanAmount + totalInterest;
            double monthlyPayment = totalPayment / (years * 12);

            String result = "Loan Amount: RM " + String.format("%.2f", loanAmount) + "\n\n" +
                    "Total Interest: RM " + String.format("%.2f", totalInterest) + "\n\n" +
                    "Total Payment: RM " + String.format("%.2f", totalPayment) + "\n\n" +
                    "Monthly Payment: RM " + String.format("%.2f", monthlyPayment);

            resultText.setText(result);

        } catch (NumberFormatException e) {
            resultText.setText("Please enter valid numbers.");
        }
    }
}

