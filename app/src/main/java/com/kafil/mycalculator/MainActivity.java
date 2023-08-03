package com.kafil.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String status=null,history;
    Boolean operator=false,dot=true,btnequalControl=false,btnACControl=true;
    private StringBuilder historyBuilder = new StringBuilder();
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAC,btnDel,btnDiv,btnMul,btnAdd,btnMin,btnequal,btnDot;
    private TextView TextViewResult,TextViewHistory;
    private String number=null;
    double firstNumber=0;
    double lastNumber=0;
    private boolean equalClicked = false;
    DecimalFormat myFormat=new DecimalFormat("######.######");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        history = "";
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnMul=findViewById(R.id.btnMul);
        btnAdd=findViewById(R.id.btnAdd);
        btnAC=findViewById(R.id.btnAC);
        btnDiv=findViewById(R.id.btnDiv);
        btnDel=findViewById(R.id.btnDel);
        btnDot=findViewById(R.id.btndot);
        btnMin=findViewById(R.id.btnMin);
        btnequal=findViewById(R.id.btnequal);


        TextViewHistory=findViewById(R.id.TextViewHistory);
        TextViewResult=findViewById(R.id.TextViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dot){

                    if (number==null)
                    {
                        number="0.";
                    }
                    else {
                        number=number+".";
                    }
                }

                TextViewResult.setText(number);
                dot=false;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equalClicked) {
                    historyBuilder.setLength(0);
                    equalClicked = false;
                }
                historyBuilder.append(TextViewResult.getText().toString()).append("+");
                TextViewHistory.setText(historyBuilder.toString());
                if (operator){
                    if(status=="subtraction"){
                        min();
                    }
                    else if (status=="multiplication"){
                        multiply();
                    }
                    else if (status=="divide") {
                        divide();
                    }
                    else {
                        add();
                    }
                }
                status="sum";
                operator=false;
                number=null;

            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equalClicked) {
                    historyBuilder.setLength(0);
                    equalClicked = false;
                }
                historyBuilder.append(TextViewResult.getText().toString()).append("*");
                TextViewHistory.setText(historyBuilder.toString());
                if (operator){
                    if(status=="subtraction"){
                        min();
                    }
                    else if (status=="sum"){
                        add();
                    }
                    else if (status=="divide") {
                        divide();
                    }
                    else {
                        multiply();
                    }
                }
                status="multiplication";
                operator=false;
                number=null;
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equalClicked) {
                    historyBuilder.setLength(0);
                    equalClicked = false;
                }
                historyBuilder.append(TextViewResult.getText().toString()).append("-");
                TextViewHistory.setText(historyBuilder.toString());
                if (operator){
                    if(status=="sum"){
                        add();
                    }
                    else if (status=="multiplication"){
                        multiply();
                    }
                    else if (status=="divide") {
                        divide();
                    }
                    else {
                        min();
                    }
                }
                status="subtraction";
                operator=false;
                number=null;

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equalClicked) {
                    historyBuilder.setLength(0);
                    equalClicked = false;
                }
                historyBuilder.append(TextViewResult.getText().toString()).append("/");
                TextViewHistory.setText(historyBuilder.toString());
                if (operator){
                    if(status=="sum"){
                        add();
                    }
                    else if (status=="multiplication"){
                        multiply();
                    }
                    else if (status=="subtraction") {
                        min();
                    }
                    else {
                        divide();
                    }
                }
                status="divide";
                operator=false;
                number=null;

            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                status=null;
                TextViewHistory.setText("");
                TextViewResult.setText("0");
                firstNumber=0;
                lastNumber=0;
                dot=true;
                btnACControl=true;
                clearHistory();

            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator){
                    if(status=="sum"){
                        add();
                    }
                    else if (status=="multiplication"){
                        multiply();
                    }
                    else if (status=="subtraction") {
                        min();
                    }
                    else if (status=="divide"){
                        divide();
                    }
                    else {
                        firstNumber=Double.parseDouble(TextViewResult.getText().toString());
                    }
                }
//
                historyBuilder.setLength(0);
                historyBuilder.append(myFormat.format(firstNumber));
                TextViewHistory.setText(historyBuilder.toString());
//                historyBuilder.append(myFormat.format(firstNumber)).append("=");
//                TextViewHistory.setText(historyBuilder.toString());
                operator=false;
                btnequalControl=true;
                equalClicked = true;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnACControl){
                    TextViewResult.setText("0");
                }
                else {
                    number=number.substring(0,number.length()-1);
                    if (number.length() == 0){
                        btnDel.setClickable(false);
                    } else if (number.contains(".")) {
                        dot=false;
                    }
                    else {
                        dot=true;
                    }
                    TextViewResult.setText(number);
                }


            }
        });
    }
    public void numberClick(String view){
        if(number==null){
            number=view;

        } else if (btnequalControl) {
            firstNumber=0;
            lastNumber=0;
            number=view;

        } else {
            number=number+view;
        }
        TextViewResult.setText(number);
        operator=true;
        btnACControl=false;
        btnDel.setClickable(true);
        btnequalControl=false;

    }
    public void add(){
        lastNumber=Double.parseDouble(TextViewResult.getText().toString());
        firstNumber=firstNumber+lastNumber;
        history = myFormat.format(lastNumber) + " +";
        TextViewResult.setText(myFormat.format(firstNumber));
        TextViewHistory.setText(history);
        dot=true;
    }
    public void min(){
        if(firstNumber==0){
            firstNumber=Double.parseDouble(TextViewResult.getText().toString());
            history = myFormat.format(firstNumber) + " -";
        }
        else {
            lastNumber=Double.parseDouble(TextViewResult.getText().toString());
            firstNumber=firstNumber-lastNumber;
            history = myFormat.format(lastNumber) + " -";

        }
         TextViewResult.setText(myFormat.format(firstNumber));
        TextViewHistory.setText(history);
        dot=true;
    }

public void multiply() {
    double currentNumber = Double.parseDouble(TextViewResult.getText().toString());


    if (firstNumber == 0) {
        firstNumber = currentNumber;

    } else {
        // Perform the multiplication with the firstNumber and the currentNumber.
        firstNumber *= currentNumber;
    }

    // Update the history and result in the TextViews.
    if (firstNumber == 0) {
        history = "0 *";
    } else {
        history = myFormat.format(firstNumber) + " *";
    }
    TextViewHistory.setText(history);
    TextViewResult.setText(myFormat.format(firstNumber));
    dot = true;
}

    public void divide() {
        double currentNumber = Double.parseDouble(TextViewResult.getText().toString());

        // Handle division by zero.
        if (currentNumber == 0) {
            TextViewResult.setText("Error"); // Display "Error" in case of division by zero.
            return;
        }

        // If the firstNumber is zero, initialize it with the currentNumber.
        if (firstNumber == 0) {
            firstNumber = currentNumber;
        } else {
            // Perform the division with the firstNumber and the currentNumber.
            firstNumber /= currentNumber;
        }

        // Update the history and result in the TextViews.
        if (firstNumber == 0) {
            history = "0 /";
        } else {
            history = myFormat.format(firstNumber) + " /";
        }
        TextViewHistory.setText(history);
        TextViewResult.setText(myFormat.format(firstNumber));
        dot = true;
    }

    public void clearHistory() {
        historyBuilder.setLength(0);
        TextViewHistory.setText(historyBuilder.toString());
    }
}
