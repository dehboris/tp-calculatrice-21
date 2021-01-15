package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button zero,un,deux,trois,quatre,cinq,six,sept,huit,neuf,egal,plus,moin,div,mul,cl,ac;
    TextView info,resul;
    private final char ADDITION ='+';
    private final char SOUSTRACTION ='-';
    private final char MULTI ='x';
    private final char DIV ='/';
    private final char EQU =0;
    private double  val1= Double.NaN;
    private double val2;
    private char ACTION;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        views();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "0");
            }
        });
        un.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "1");
            }
        });
        deux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "2");
            }
        });
        trois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "3");
            }
        });
        quatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "4");
            }
        });
        cinq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "6");
            }
        });
        sept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "7");
            }
        });
        huit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "8");
            }
        });
        neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "9");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=ADDITION;
                resul.setText(String.valueOf(val1) + "+");
                info.setText(null);

            }
        });
        moin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=SOUSTRACTION;
                resul.setText(String.valueOf(val1) + "-");
                info.setText(null);

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=MULTI;
                resul.setText(String.valueOf(val1) + "x");
                info.setText(null);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=DIV;
                resul.setText(String.valueOf(val1) + "+");
                info.setText(null);

            }
        });
        egal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=EQU;
                resul.setText(resul.getText().toString()+ String.valueOf(val2) +"="+ String.valueOf(val1));
                info.setText(null);


            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               info.setText("");
               resul.setText("");

            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    resul.setText(null);
                }
            }
        });
    }
    private void views(){
        zero=(Button)findViewById(R.id.btn0);
        un=(Button)findViewById(R.id.btn1);
        deux=(Button)findViewById(R.id.btn2);
        trois=(Button)findViewById(R.id.btn3);
        quatre=(Button)findViewById(R.id.btn4);
        cinq=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        sept=(Button)findViewById(R.id.btn7);
        huit=(Button)findViewById(R.id.btn8);
        neuf=(Button)findViewById(R.id.btn9);
        egal=(Button)findViewById(R.id.btnegal);
        plus=(Button)findViewById(R.id.btnadd);
        moin=(Button)findViewById(R.id.btnsou);
        div=(Button)findViewById(R.id.btndiv);
        mul=(Button)findViewById(R.id.btnmul);
        cl=(Button)findViewById(R.id.btncl);
        ac=(Button)findViewById(R.id.btnac);
        info=(TextView)findViewById(R.id.tvcon);
        resul=(TextView)findViewById(R.id.tvres);

    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(info.getText().toString());
            switch (ACTION){
                case ADDITION:
                    val1=val1+val2;
                    break;
                case SOUSTRACTION:
                  val1=val1-val2;
                    break;
                case DIV:
                    val1=val1/val2;
                    break;
                case EQU:
                    break;
                case MULTI:
                    val1=val1*val2;
                    break;
            }
        }
        else{
            val1=Double.parseDouble(info.getText().toString());
        }
    }
}