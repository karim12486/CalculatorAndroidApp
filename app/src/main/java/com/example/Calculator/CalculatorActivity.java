package com.example.Calculator;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tester.R;

public class CalculatorActivity extends AppCompatActivity {

    Button button7;
    TextView screenTextView;
    String operation = "";
    String LHS = "";
    boolean isOperatorClick = false;
    boolean isEqualClick = false;
    boolean isDotClick = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        button7 = findViewById(R.id.button_7);
        screenTextView = findViewById(R.id.screenTextView);

    }
    public void onDigitClick(View view) {
        if (view instanceof Button) {
            Button button = ((Button) view);
            if (button.getId() == R.id.button_dot){
                if (isDotClick){
                    return;
                } else {
                    isDotClick = true;
                }
            }
            if (isOperatorClick || isEqualClick){
                screenTextView.setText(button.getText());
                isOperatorClick = false;
                isEqualClick = false;
            }else {
                screenTextView.append(button.getText());
            }
        }
    }
    public void onOperationClick(View view) {
        if(view instanceof Button){
            Button button = ((Button) view);
            isDotClick = false;
            if (operation.equals("")){
                LHS = screenTextView.getText().toString();
                operation = button.getText().toString();
                screenTextView.setText("");
            } else {
                String RHS = screenTextView.getText().toString();
                if (!RHS.isEmpty()) {
                    LHS = calculate(LHS, operation, RHS);
                    operation = button.getText().toString();
                    screenTextView.setText(LHS);
                    isOperatorClick = true;
                } else {
                    operation = button.getText().toString();
                    isOperatorClick = true;
                }
            }
        }
    }

    public void onEqualsClick(View view) {
        if (view instanceof Button){
            Button button = ((Button) view);
            String RHS = screenTextView.getText().toString();
            if (!LHS.isEmpty()) {
                LHS = calculate(LHS, operation, RHS);
                screenTextView.setText(LHS);
                operation = "";
                LHS = "";
                isEqualClick = true;
            }
        }
    }
    private String calculate(String lhs, String operation, String rhs) {
        double left = Double.parseDouble(lhs);
        double right = Double.parseDouble(rhs);
        double result = 0.0;
        switch (operation) {
            case "+":
                result = left + right;
                break;
            case "X":
                result = left * right;
                break;
            case "/":
                if (right == 0){
                    //Handle message for user
//                    Toast.makeText(this,"You can't divide by 0!",Toast.LENGTH_LONG).show();

                    return "u dum fuck, HAYAAA";
                }
                result = left / right;
                break;
            case "-":
                result = left - right;
                break;
        }
        return result + "";
    }
}