package com.example.calculatorbyvicodart;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;

public class MainActivity extends AppCompatActivity {



    private EditText display;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setCursorVisible(false);
        display.setHorizontallyScrolling(true);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");

                }
            }
        });

    }

    private void Afficherbutton(String text){
        display.setSelection(display.getText().length());
        String initstr = display.getText().toString();
        int curseurpos = display.getSelectionStart();
        String gauche = initstr.substring(0, curseurpos);
        String droite = initstr.substring(curseurpos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(text);
            display.setSelection(curseurpos+1);
        }
        else{
            display.setText(String.format("%s%s%s",gauche,text,droite));
            display.setSelection(curseurpos+1);
        }
    }

    private void Afficherbuttoni(String text){
        String initstr = display.getText().toString();
        int curseurpos = display.getSelectionStart();
        String gauche = initstr.substring(0, curseurpos);
        String droite = initstr.substring(curseurpos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(text);
            display.setSelection(curseurpos+1);
        }
        else{
            display.setText(String.format("%s%s%s",text,gauche,droite));
            display.setSelection(curseurpos+1);
        }
    }
    public void zer(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*0");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*0");
            }else{
                Afficherbutton("0");
            }
        }else{
            Afficherbutton("0");
        }

    }

    public void one(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*1");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*1");
            }else{
                Afficherbutton("1");
            }
        }else{
            Afficherbutton("1");
        }
    }

    public void two(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*2");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*2");
            }else{
                Afficherbutton("2");
            }
        }else{
            Afficherbutton("2");
        }
    }

    public void three(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*3");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*3");
            }else{
                Afficherbutton("3");
            }
        }else{
            Afficherbutton("3");
        }
    }

    public void four(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*4");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*4");
            }else{
                Afficherbutton("4");
            }
        }else{
            Afficherbutton("4");
        }
    }

    public void five(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*5");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*5");
            }else{
                Afficherbutton("5");
            }
        }else{
            Afficherbutton("5");
        }
    }

    public void six(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*6");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*6");
            }else{
                Afficherbutton("6");
            }
        }else{
            Afficherbutton("6");
        }
    }

    public void seven(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*7");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*7");
            }else{
                Afficherbutton("7");
            }
        }else{
            Afficherbutton("7");
        }
    }

    public void eight(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
                Afficherbutton("*8");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
                Afficherbutton("*8");
            }else{
                Afficherbutton("8");
            }
        }else{
            Afficherbutton("8");
        }
    }

    public void nine(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
        if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") ){
            Afficherbutton("*9");
        }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")){
            Afficherbutton("*9");
        }else{
            Afficherbutton("9");
        }
        }else{
            Afficherbutton("9");
        }
    }

    public void multiply(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("*") && !getString(R.string.display).equals(display.getText().toString())&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
           if(longueurtext==1 && display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")){

           }else{
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("+")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("*");
                }
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
                Afficherbutton("0*");
            }
            else{
                Afficherbutton("*");
            }
           }
        }
    }

    public void divide(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") && !getString(R.string.display).equals(display.getText().toString())&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
            if(longueurtext==1 && display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")){

            }else{
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("/");
                }
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
                Afficherbutton("0/");
            }
            else{
                Afficherbutton("/");
            }
            }
        }
    }

    public void substract(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") && !getString(R.string.display).equals(display.getText().toString())&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
            if(longueurtext==1 && display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")){

            }else{
                if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")){
                    int curseurpos = display.getSelectionStart();
                    int longueurtex = display.getText().length();
                    if(curseurpos != 0 && longueurtex != 0){
                        SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                        selection.replace(curseurpos-1, curseurpos,"");
                        display.setText(selection);
                        display.setSelection(curseurpos-1);
                        Afficherbutton("-");
                    }
                }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
                    Afficherbutton("-");
                }
                else{
                    Afficherbutton("-");
                }
            }
        }
    }

    public void addition(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") && !getString(R.string.display).equals(display.getText().toString())&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
            if(longueurtext==1 && display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")){

            }else{
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("+");
                }
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
                Afficherbutton("0+");
            }
            else{
                Afficherbutton("+");
            }
            }
        }
    }

    public void clear(View view){
        display.setText("");
    }

    public void parentheses(View view){
        int curseurpos = display.getSelectionStart();
        int debutpar =0;
        int finpar = 0;
        int longueurtext = display.getText().length();

        for(int i=0 ; i<curseurpos;i++){
            if(display.getText().toString().substring(i, i+1).equals("(")){
                debutpar += 1;
            }

            if(display.getText().toString().substring(i, i+1).equals(")")){
                finpar += 1;
            }
        }

        if(debutpar == finpar || display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
            display.setSelection(display.getText().length());
            if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*(");
                display.setSelection(display.getText().length());
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("(");
                display.setSelection(display.getText().length());
            }
            }else{
                Afficherbutton("(");
                display.setSelection(display.getText().length());
            }

        }

        else if(finpar < debutpar && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
            display.setSelection(display.getText().length());
            if( display.getText().toString().substring(longueurtext-1, longueurtext).equals(".") ||display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")){

            }else{
                Afficherbutton(")");
                display.setSelection(display.getText().length());
            }

        }

    }

    public void exposant(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("^") && !getString(R.string.display).equals(display.getText().toString())&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
            if(longueurtext==1 && display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")){

            }else{
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("^");
                }
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
                Afficherbutton("0^");
            }
            else{
                Afficherbutton("^");
            }
            }
        }
    }

    public void plusoumoins(View view){
        int curseurpos = display.getSelectionStart();
        int debutparh =0;
        int longueurtext = display.getText().length();
        for(int i=0 ; i<curseurpos;i++){
            if(display.getText().toString().substring(i, i+1).equals("-")){
                debutparh += 1;
            }
        }
        if( debutparh<1 && !display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("+")){
            Afficherbuttoni("-");
        }
    }

    public void dot(View view){
        display.setSelection(display.getText().length());

        int curseurpos = display.getSelectionStart();
        int debutpar =0;
        int finpar = 0;
        int longueurtext = display.getText().length();

        for(int i=0 ; i<curseurpos;i++){
            if(display.getText().toString().substring(i, i+1).equals(".")){
                debutpar += 1;
            }

            if( display.getText().toString().substring(i, i+1).equals("-") || display.getText().toString().substring(i, i+1).equals("+") || display.getText().toString().substring(i, i+1).equals("*")|| display.getText().toString().substring(i, i+1).equals("/")|| display.getText().toString().substring(i, i+1).equals("#")|| display.getText().toString().substring(i, i+1).equals("^")){
                finpar += 1;
            }
        }
        if(!display.getText().toString().equals("")) {
            if(!display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("+")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals(")")&&!display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

                Afficherbutton(".");
                display.setSelection(display.getText().length());

            }
        }else{
            Afficherbutton("0.");
        }
    }

    public void sin(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
      if(!display.getText().toString().equals("")){
          if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
              Afficherbutton("*sin(");
          }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

          }
          else{
              Afficherbutton("sin(");
          }
      }else{
          Afficherbutton("sin(");
      }

              }

    public void exp(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*exp(");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("exp(");
            }
        }else{
            Afficherbutton("exp(");
        }

    }

    public void cos(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*cos(");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("cos(");
            }
        }else{
            Afficherbutton("cos(");
        }
    }

    public void log10(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*log10(");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("log10(");
            }
        }else{
            Afficherbutton("log10(");
        }
    }

    public void tan(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*tan(");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("tan(");
            }
        }else{
            Afficherbutton("tan(");
        }
    }

    public void rad(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*rad(");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("rad(");
            }
        }else{
            Afficherbutton("rad(");
        }

    }

    public void ln(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("")){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("!") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("0")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals(")") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("1") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("2")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("3")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("4")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("5")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("6")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("7")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("8")|| display.getText().toString().substring(longueurtext-1, longueurtext).equals("9") ){
                Afficherbutton("*ln(");
            }else if(display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){

            }
            else{
                Afficherbutton("ln(");
            }
        }else{
            Afficherbutton("ln(");
        }
    }

    public void fact(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") &&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("!")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("+")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals("(") && !getString(R.string.display).equals(display.getText().toString())&&  !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
            Afficherbutton("!");
        }
    }

    public void mod(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("#") && !getString(R.string.display).equals(display.getText().toString())&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")){
            if(longueurtext==1 && display.getText().toString().substring(longueurtext-1, longueurtext).equals("-")){

            }else {
                if (display.getText().toString().substring(longueurtext - 1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext - 1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext - 1, longueurtext).equals("*") || display.getText().toString().substring(longueurtext - 1, longueurtext).equals("^") || display.getText().toString().substring(longueurtext - 1, longueurtext).equals("/")) {
                    int curseurpos = display.getSelectionStart();
                    int longueurtex = display.getText().length();
                    if (curseurpos != 0 && longueurtex != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                        selection.replace(curseurpos - 1, curseurpos, "");
                        display.setText(selection);
                        display.setSelection(curseurpos - 1);
                        Afficherbutton("#");
                    }
                } else if (display.getText().toString().substring(longueurtext - 1, longueurtext).equals("(")) {
                    Afficherbutton("0#");
                } else {
                    Afficherbutton("#");
                }
            }
        }
    }

    public void equal(View view){
        int longueurtext = display.getText().length();
        int curseurpos = display.getSelectionStart();
        int debutpar =0;
        int finpar = 0;

        for(int i=0 ; i<curseurpos;i++){
            if(display.getText().toString().substring(i, i+1).equals("(")){
                debutpar += 1;
            }

            if(display.getText().toString().substring(i, i+1).equals(")")){
                finpar += 1;
            }
        }
        if(debutpar==finpar&&!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("*") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("^")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("#")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("n")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("s")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("p")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("d")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals(".")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
            String user = display.getText().toString();
            user = user.replaceAll("ALT+0247", "/" );
            user = user.replaceAll("ALT+0215", "*" );

            Expression exp = new Expression(user);
            String result = String.valueOf(exp.calculate());

            if("NaN".equals(result)){
                display.setText("Erreur Reprenez!");
            }else{

            display.setText(result);
            display.setSelection(result.length());

        }
        }

    }

    public void back(View view){
        display.setSelection(display.getText().length());
        int curseurpos = display.getSelectionStart();
        int longueurtext = display.getText().length();
        if(curseurpos != 0 && longueurtext != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(curseurpos-1, curseurpos,"");
            display.setText(selection);
            display.setSelection(curseurpos-1);
        }
    }
}