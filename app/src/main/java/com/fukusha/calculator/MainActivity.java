package com.fukusha.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnBrackets,btnEqual,btnDot,btnAdd,btnDivide,btnMulti,btnMinus,btnErase,btnPercent,btnClear;
    TextView inputValue,outputValue;
    String store;
    boolean checkBracket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnZero=findViewById(R.id.btnZero);
        btnOne=findViewById(R.id.btnOne);
        btnTwo=findViewById(R.id.btnTwo);
        btnThree=findViewById(R.id.btnThree);
        btnFour=findViewById(R.id.btnFour);
        btnFive=findViewById(R.id.btnFive);
        btnSix=findViewById(R.id.btnSix);
        btnSeven=findViewById(R.id.btnSeven);
        btnEight=findViewById(R.id.btnEight);
        btnNine=findViewById(R.id.btnNine);
        btnBrackets=findViewById(R.id.btnBrackets);
        btnEqual=findViewById(R.id.btnEqual);
        btnDot=findViewById(R.id.btnDot);
        btnAdd=findViewById(R.id.btnAdd);
        btnDivide=findViewById(R.id.btnDivide);
        btnMulti=findViewById(R.id.btnMulti);
        btnMinus=findViewById(R.id.btnMinus);
        btnErase=findViewById(R.id.btnErase);
        btnPercent=findViewById(R.id.btnPercent);
        btnClear=findViewById(R.id.btnClear);


        inputValue=findViewById(R.id.inputValue);
        outputValue=findViewById(R.id.outputValue);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue.setText("");
                outputValue.setText("");
            }
        });


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "0" );
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "1" );
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "2" );
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "3" );
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "4" );
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "5" );
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "6" );
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "7" );
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "8" );
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "9" );
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "9" );
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "+" );
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "-" );
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "×" );
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "÷" );
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "%" );
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store= inputValue.getText().toString();
                inputValue.setText(store + "." );
            }
        });
        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket) {
                    store = inputValue.getText().toString();
                    inputValue.setText(store + ")");
                    checkBracket = false;
                }else{
                    store = inputValue.getText().toString();
                    inputValue.setText(store + "(");
                    checkBracket = true;
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
