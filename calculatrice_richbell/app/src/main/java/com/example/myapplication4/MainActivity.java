package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    //On déclare toutes les variables dont on aura besoin
        Button btn9,btn8,btn7,btn6,btn5,btn4,btn3,btn2,btn1,btn0,btnegalite,btnmultiplication,btnsoustraction,btnaddition,btndivision,btnclear;
    EditText ecran;

    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn9 = findViewById(R.id.btn9);
        btn8 = findViewById(R.id.btn8);
        btn7 = findViewById(R.id.btn7);
        btn6 = findViewById(R.id.btn6);
        btn5 = findViewById(R.id.btn5);
        btn4 = findViewById(R.id.btn4);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn0 = findViewById(R.id.btn0);


        btnmultiplication = findViewById(R.id.btnmultiplication);
        btnsoustraction = findViewById(R.id.btnsoustraction);
        btnaddition = findViewById(R.id.btnaddition);
        btndivision = findViewById(R.id.btndivision);
        btnclear = findViewById(R.id.btnclear);
        btnegalite = findViewById(R.id.btnegalite);





        ecran = (EditText) findViewById(R.id.EditText01);

        //On attribue un écouteur d'évènement à tous les boutons
        btnaddition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        btnsoustraction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        btndivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        btnmultiplication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        btnegalite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });


        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

    }

    //voici la méthode qui est exécutée lorsqu'on clique sur un bouton chiffre
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!ecran.getText().equals("0"))
                str = ecran.getText() + str;
        }
        ecran.setText(str);
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton +
    public void plusClick(){

        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton -
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton *
    public void mulClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton /
    public void divClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton =
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton C
    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran.setText("");
    }

    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                ecran.setText("0");
            }
        }
    }
}




