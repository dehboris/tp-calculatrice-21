package com.login.calculatriceudes;

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
        display.setCursorVisible(true);
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
        Afficherbutton("0");
    }

    public void one(View view){
        Afficherbutton("1");
    }

    public void two(View view){
        Afficherbutton("2");
    }

    public void three(View view){
        Afficherbutton("3");
    }

    public void four(View view){
        Afficherbutton("4");
    }

    public void five(View view){
        Afficherbutton("5");
    }

    public void six(View view){
        Afficherbutton("6");
    }

    public void seven(View view){
        Afficherbutton("7");
    }

    public void eight(View view){
        Afficherbutton("8");
    }

    public void nine(View view){
        Afficherbutton("9");
    }

    public void mil(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("*") && !getString(R.string.display).equals(display.getText().toString())){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("+")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("*");
                }
            }
            else{
                Afficherbutton("*");
            }
        }
    }

    public void div(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") && !getString(R.string.display).equals(display.getText().toString())){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("/");
                }
            }
            else{
                Afficherbutton("/");
            }
        }
    }

    public void subs(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") && !getString(R.string.display).equals(display.getText().toString())){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("-");
                }
            }
            else{
                Afficherbutton("-");
            }
        }
    }

    public void add(View view){
        display.setSelection(display.getText().length());
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("+") && !getString(R.string.display).equals(display.getText().toString())){
            if(display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("/") || display.getText().toString().substring(longueurtext-1, longueurtext).equals("*")){
                int curseurpos = display.getSelectionStart();
                int longueurtex = display.getText().length();
                if(curseurpos != 0 && longueurtex != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(curseurpos-1, curseurpos,"");
                    display.setText(selection);
                    display.setSelection(curseurpos-1);
                    Afficherbutton("+");
                }
            }
            else{
                Afficherbutton("+");
            }
        }
    }

    public void cl(View view){
        display.setText("");
    }

    public void par(View view){
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
            Afficherbutton("(");
        }

        else if(finpar < debutpar && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("(")){
            Afficherbutton(")");
        }
        display.setSelection(curseurpos+1);
    }

    public void ex(View view){
        Afficherbutton("^");
    }

    public void plum(View view){
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
    

    public void equa(View view){
        int longueurtext = display.getText().length();
        if(!display.getText().toString().equals("") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("*") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("/")&& !display.getText().toString().substring(longueurtext-1, longueurtext).equals("-") && !display.getText().toString().substring(longueurtext-1, longueurtext).equals("+")){
            String user = display.getText().toString();
            user = user.replaceAll("ALT+0247", "/" );
            user = user.replaceAll("ALT+0215", "*" );

            Expression exp = new Expression(user);
            String result = String.valueOf(exp.calculate());


            display.setText(result);
            display.setSelection(result.length());

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