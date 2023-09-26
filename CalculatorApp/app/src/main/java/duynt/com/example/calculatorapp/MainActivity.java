package duynt.com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation('/');
            }
        });
    }

    private void performCalculation(char operation) {
        try {
            double number1 = Double.parseDouble(editTextNumber1.getText().toString());
            double number2 = Double.parseDouble(editTextNumber2.getText().toString());
            double result = 0;

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        textViewResult.setText("Không thể chia cho 0");
                        return;
                    }
                    break;
            }

            textViewResult.setText("Kết quả: " + result);
        } catch (NumberFormatException e) {
            textViewResult.setText("Vui lòng nhập hai số hợp lệ.");
        }
    }
}