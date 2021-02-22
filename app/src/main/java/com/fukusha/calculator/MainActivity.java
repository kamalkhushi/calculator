package com.fukusha.calculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnBrackets, btnEqual, btnDot, btnAdd, btnDivide, btnMulti, btnMinus, btnErase, btnPow, btnClear;
    TextView inputValue, outputValue;
    String store, equation, resfin;
    double result;
    boolean checkBracket = false;
    boolean powFlag = false;
    boolean eqFlag = false;

    //Feel free to add more documentation to this would be helpful to anyone who reads the code
    //A small note if anything goes wrong do check logcat as most events and meaningless errors are logged
    //And a small suggestion if something does'nt work just Log.d it to hell until you find the source
    //If for some reason any error comes up about android sdk location goto project_view > local.properties and replace the sdk.dir value with your computers android sdk location

    public void checkLoginStatus() {

        // Check if user is signed in (non-null) and update UI accordingly.

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Intent loggedIn = new Intent(MainActivity.this,Login.class);
            finish();
            Log.d("FireBase Login (Login class)","User is not logged in sending user to login");
            startActivity(loggedIn);
        } else {
            Log.d("Firebase Login (Login class)","User is logged in");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkLoginStatus();

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnBrackets = findViewById(R.id.btnBrackets);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);
        btnAdd = findViewById(R.id.btnAdd);
        btnDivide = findViewById(R.id.btnDivide);
        btnMulti = findViewById(R.id.btnMulti);
        btnMinus = findViewById(R.id.btnMinus);
        btnErase = findViewById(R.id.btnErase);
        btnPow = findViewById(R.id.btnPow);
        btnClear = findViewById(R.id.btnClear);


        inputValue = findViewById(R.id.inputValue);
        outputValue = findViewById(R.id.outputValue);

        equation = "0";
        store = "0";

        //Here starts a long list of on click listeners honestly wish there was a way to do it with one on click listener

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue.setText("0");
                outputValue.setText("0");
                equation = "0";
                store = "";
                resfin = "";
                result = 0;
                checkBracket = false;
                powFlag = false;
                eqFlag = false;
                btnPow.setTextColor(Color.parseColor("#FFFFFF"));
                btnBrackets.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("0");
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁰");
                        equation+=0;
                    }
                    else {
                        inputValue.setText(store + "0");
                        equation += 0;
                    }
                }
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("1");
                    equation="1";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "¹");
                        equation+=1;
                    }
                    else {
                        inputValue.setText(store + "1");
                        equation += 1;
                    }
                }
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("2");
                    equation="2";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "²");
                        equation+=2;
                    }
                    else {
                        inputValue.setText(store + "2");
                        equation += 2;
                    }
                }
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("3");
                    equation="3";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "³");
                        equation+=3;
                    }
                    else {
                        inputValue.setText(store + "3");
                        equation += 3;
                    }
                }
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("4");
                    equation="4";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁴");
                        equation+=4;
                    } else {
                        inputValue.setText(store + "4");
                        equation += 4;
                    }
                }
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("5");
                    equation="5";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁵");
                        equation+=5;
                    }
                    else {
                        inputValue.setText(store + "5");
                        equation += 5;
                    }
                }
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("6");
                    equation="6";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁶");
                        equation+=6;
                    }
                    else {
                        inputValue.setText(store + "6");
                        equation += 6;
                    }
                }
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("7");
                    equation="7";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁷");
                        equation+=7;
                    }
                    else {
                        inputValue.setText(store + "7");
                        equation += 7;
                    }
                }
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("8");
                    equation="8";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁸");
                        equation+=8;
                    }
                    else {
                        inputValue.setText(store + "8");
                        equation += 8;
                    }
                }
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("9");
                    equation="9";
                } else {
                    if (powFlag){
                        inputValue.setText(store + "⁹");
                        equation+=9;
                    }
                    else {
                        inputValue.setText(store + "9");
                        equation += 9;
                    }
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("+");
                    equation+=" + ";
                } else {
                    if (powFlag){
                        //Toast.makeText(MainActivity.this,"This functinality is currently pending",Toast.LENGTH_SHORT).show();
                        inputValue.setText(store + "⁺");
                        equation+= " + ";
                    }
                    else {
                        inputValue.setText(store + "+");
                        equation += " + ";
                    }
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("-");
                    equation+=" - ";
                } else {
                    if (powFlag){
                        //Toast.makeText(MainActivity.this,"This functinality is currently pending",Toast.LENGTH_SHORT).show();
                        inputValue.setText(store + "⁻");
                        equation+=" - ";
                    }
                    else {
                        inputValue.setText(store + "-");
                        equation += " - ";
                    }
                }
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("x");
                    equation+=" * ";
                } else {
                    if (powFlag){
                        //Toast.makeText(MainActivity.this,"This functinality is currently pending",Toast.LENGTH_SHORT).show();
                        inputValue.setText(store + "ˣ");
                        equation+=" * ";
                    }
                    else {
                        inputValue.setText(store + "x");
                        equation += " * ";
                    }
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText("/");
                    equation+=" / ";
                } else {
                    if (powFlag){
                        //Toast.makeText(MainActivity.this,"This functinality is currently pending",Toast.LENGTH_SHORT).show();
                        inputValue.setText(store + "/");
                        equation+= " / ";
                    }
                    else {
                        //If somehow you can get the below one line to show up as superscript please change it
                        inputValue.setText(store + "/");
                        equation += " / ";
                    }
                }
            }
        });

        //Added power mode
        //Added a way to calculate equations in power and currently don't support decimals and brackets yet
        // Yet another way of torturing yourself with a long list of null pointer bugs which makes no sense whatsoever
        // Logcat to the rescue
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(powFlag){
                    equation += " ] ";
                    btnPow.setTextColor(Color.parseColor("#FFFFFF"));
                    powFlag = false;
                    Toast.makeText(MainActivity.this,"Power mode disabled",Toast.LENGTH_SHORT).show();
                    Log.d("pow flag","Power flag reset");
                } else {
                    Toast.makeText(MainActivity.this,"Power mode enabled",Toast.LENGTH_SHORT).show();
                    btnPow.setTextColor(Color.parseColor("#FF0000"));
                    equation+=" ^ [ ";
                    powFlag = true;
                    Log.d("pow flag","Power flag set");
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();
                if (store.equals("0")) {
                    inputValue.setText(".");
                    equation=".";
                } else {
                    if (powFlag){
                        Toast.makeText(MainActivity.this,"This functinality is currently pending",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        inputValue.setText(store + ".");
                        equation += ".";
                    }
                }
            }
        });
        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                store = inputValue.getText().toString();
                if(powFlag){
                    Toast.makeText(MainActivity.this,"This action is not yet supported",Toast.LENGTH_SHORT).show();
                } else if (store.equals("0")) {
                        Log.d("zero check","value is zero set equation and store as (");
                        inputValue.setText("(");
                        equation="( ";
                        Toast.makeText(MainActivity.this, "Bracket mode enabled", Toast.LENGTH_SHORT).show();
                        btnBrackets.setTextColor(Color.parseColor("#FF0000"));
                        checkBracket = true;

                    } else {

                        if (checkBracket) {
                            Toast.makeText(MainActivity.this, "Bracket mode disabled", Toast.LENGTH_SHORT).show();
                            btnBrackets.setTextColor(Color.parseColor("#FFFFFF"));
                            store = inputValue.getText().toString();
                            inputValue.setText(store + ")");
                            equation += " ) ";
                            checkBracket = false;
                        } else {
                            Toast.makeText(MainActivity.this, "Bracket mode enabled", Toast.LENGTH_SHORT).show();
                            btnBrackets.setTextColor(Color.parseColor("#FF0000"));
                            store = inputValue.getText().toString();
                            inputValue.setText(store + "(");


                            // Gets the previous character to check for a number presence

                            String lastSecond = equation.substring(equation.length() - 1, equation.length() - 0);

                            Log.d("lsBrkt", lastSecond);

                            if (lastSecond.equals(" ")) {
                                equation += "( ";
                                checkBracket = true;
                                // To make sure this is executed only if previous input is null
                                Log.d("chkBracketNull", equation);
                            } else {
                                equation += " * ( ";
                                checkBracket = true;
                                // To make sure this is executed only if previous input is not null
                                Log.d("chkBracketNotNull", equation);
                            }

                            // No longer needed added a way to detect if previous input is a number or not and take action appropriately

                            //equation+="( ";
                            //checkBracket = true;
                        }
                    }
                }
        });

        // Equal Button
        // If you are looking at this block of code after you run this you are probably having some stupid runtime error or null pointer or god knows what error
        // On a side note if you want to verify your equations just comment out the expression evaluation part and put the variable to check in output value set text code

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!eqFlag){
                    eqFlag = true;
                    store = inputValue.getText().toString();
                    inputValue.setText(store);
                    EvaluateString ev = new EvaluateString();

                    //Verify equation then send for evaluation

                    verifyEquationCorrectness();

                    double rev = ev.evaluate(equation);
                    resfin = Double.toString(rev);
                    outputValue.setText(resfin);
                    //equation = "";
                }else {
                    eqFlag = false;
                    store = inputValue.getText().toString();
                    inputValue.setText(store);
                    outputValue.setText(resfin);
                }
            }
        });

        btnErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store = inputValue.getText().toString();

                try {
                    eqFlag = false;
                    String tmp1 = store.substring(0, store.length() - 1);
                    store = tmp1;
                    inputValue.setText(store);

                    //Another way to torture yourself is working with strings
                    //See if the last second character is null and delete last 2 chars if null and remove only last char if not null

                    String lastSecond = equation.substring(equation.length()-2,equation.length()-1);

                    Log.d("Before eq",equation);
                    Log.d("Last Second Character",lastSecond);

                    if(lastSecond.equals(" ")){  // .equals(null) and .equals(" ") are the same thing don't know why the hell this wont accept null
                        equation = equation.substring(0,equation.length() - 2);
                        Log.d("eqTestnull",equation);   //If this executes it means last second character is null and last 2 characters are removed since in equation values are space seperated
                    } else {
                        equation = equation.substring(0,equation.length() - 1);
                        Log.d("eqTestnotnull",equation);  //If this executes it means last second character is probably a number or dot so remove only one character
                    }

                    //If equation is null set equation as 0 and input view as 0 solving is done y evaluateString class

                    if (isNullOrEmpty(equation)){
                        equation = "0 ";
                        inputValue.setText("0");
                    }

                    Log.d("Store eq",store);
                    Log.d("After eq",equation);
                } catch (IndexOutOfBoundsException e) {
                    Log.d("Index Out Of Bounds Exception", "Index out of bounds in btnErase.");
                    inputValue.setText("0");
                    equation = "0";
                }
            }
        });


    }

    //To check the basics of the equation can be modified for more functionality

    private void verifyEquationCorrectness() {

        //String tmp = equation;

        String last = equation.substring(equation.length()-1);
        String lastSecond = equation.substring(equation.length()-2,equation.length()-1);

        Log.d("Last",last);
        Log.d("LastSecond",lastSecond);
        Log.d("Prev Equation",equation);

        if((powFlag || checkBracket) && last != "]"){

            if(powFlag){
                if(last.equals(" ")){
                    equation += "0 ]";
                    powFlag = false;
                    btnPow.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    equation += " ]";
                    powFlag = false;
                    btnPow.setTextColor(Color.parseColor("#FFFFFF"));
                }
            } else if(checkBracket){
                if(last.equals(" ")){
                    equation += "0 )";
                    checkBracket = false;
                    btnBrackets.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    equation += " )";
                    checkBracket = false;
                    btnBrackets.setTextColor(Color.parseColor("#FFFFFF"));
                }
            }
        }
        if (last.equals(" ") && !lastSecond.equals(")") && !lastSecond.equals("(") && !lastSecond.equals("]") && !lastSecond.equals("[")){
            Log.d("Last1",last);
            Log.d("LastSecond1",lastSecond);
            equation += "0";
            Log.d("ChkEquationEnd",equation);
        }
    }

    //Check if equation is null or zero and return the status
    //Honestly don't remember why did i write it and use it it just works so better left alone

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

    //Menu Handler

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logoutUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Gets the user and ends session
    private void logoutUser() {
        Intent signOut = new Intent(MainActivity.this,Login.class);
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(signOut);
    }

    //For the side logout menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.op_menu,menu);

        return true;
    }
}
