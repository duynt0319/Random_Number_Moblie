package duynt.com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText minEditText;
    private EditText maxEditText;
    private TextView randomNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minEditText = findViewById(R.id.minEditText);
        maxEditText = findViewById(R.id.maxEditText);
        randomNumberTextView = findViewById(R.id.randomNumberTextView);

        Button generateButton = findViewById(R.id.generateButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        try {
            int min = Integer.parseInt(minEditText.getText().toString());
            int max = Integer.parseInt(maxEditText.getText().toString());

            if (isInputValid(min, max)) {
                Random random = new Random();
                int randomNumber = random.nextInt((max - min) + 1) + min;
                randomNumberTextView.setText("Random Number: " + randomNumber);
            }
        } catch (NumberFormatException e) {
            randomNumberTextView.setText("Vui lòng nhập đúng hai số.");
        }
    }

    private boolean isInputValid(int min, int max) {
        if (min <= max) {
            return true;
        } else {
            randomNumberTextView.setText("Min phải nhỏ hơn hoặc bằng Max.");
            return false;
        }
    }
}