package com.example.b2dcalci;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextBinary;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextBinary = findViewById(R.id.editTextBinary);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        button.setOnClickListener(view -> {
            String binaryinput=editTextBinary.getText().toString();
            if(TextUtils.isEmpty(binaryinput)){
                Toast.makeText(MainActivity.this, "please enter the binary no,", Toast.LENGTH_SHORT).show();
            return;
            }
            int decimalresult =binarytoDecimal(binaryinput);
            textView.setText("Decimal: " + decimalresult);
        });
    }

    private boolean isvalidbinary(String binaryinput){
        for (char c:binaryinput.toCharArray()){
            if(c!='0' && c!='1'){
                return false;
            }
        }
        return true;
    }

    private int binarytoDecimal(String binaryinput) {
        int decimalValue=0;
        int length = binaryinput.length();

        for(int i=0;i<length;i++){
            if(binaryinput.charAt(length-i-1)=='1'){
                decimalValue+=Math.pow(2,i);

            }
        }
        return decimalValue;
    }
}