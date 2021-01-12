package com.login.calculatrice1;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity  {
    
    private EditText afficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        afficher =(EditText) findViewById(R.id.affichage);
        afficher.setShowSoftInputOnFocus(false);

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString (R.string.afficher).equals(afficher.getText().toString())){
                    afficher.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd) {
        String oldStr = afficher.getText().toString();
        int cursorPos = afficher.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.afficher).equals(afficher.getText().toString())){
            afficher.setText(strToAdd);
            afficher.setSelection(cursorPos + 1);
        }
        else{
            afficher.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            afficher.setSelection(cursorPos + 1);
        }


    }
    public void cBTN (View view) {
        afficher.setText("");
    }

    public void parentBTN(View view){
        int cursorPos = afficher.getSelectionStart();
        int ouvPar = 0;
        int ferPar = 0;
        int texTail = afficher.getText().length();

        for(int i = 0; i < cursorPos; i++){
            if(afficher.getText().toString().substring(i, i +1).equals("(")){
                ouvPar += 1;
            }

            if(afficher.getText().toString().substring(i, i+1).equals(")")){
                ferPar += 1;
            }
        }
        if (ouvPar == ferPar || afficher.getText().toString().substring(texTail-1, texTail).equals("(")){
            updateText("(");
        }
        else if (ferPar < ouvPar && !afficher.getText().toString().substring(texTail-1, texTail).equals("(")){
            updateText(")");

        }
        afficher.setSelection(cursorPos + 1);
    }
    public void expoBTN(View view){
        updateText("^");
    }
    public void plusoumoinsBTN(View view){
        updateText("-");
    }
    public void unBTN(View view){
        updateText("1");
    }

    public void deuxBTN(View view){
        updateText("2");
    }

    public void troisBTN (View view){
        updateText("3");
    }

    public void additionBTN(View view) { updateText("+"); }

    public void quatreBTN (View view) { updateText("4"); }

    public void cinqBTN (View view){
        updateText("5");
    }

    public void sixBTN (View view){
        updateText("6");
    }

    public void soustractionBTN (View view){
        updateText("-");
    }

    public void septBTN (View view){
        updateText("7");
    }

    public void huitBTN (View view){
        updateText("8");
    }

    public void neufBTN (View view) { updateText("9");}

    public void multiplicationBTN (View view) { updateText("x"); }

    public void zeroBTN (View view) { updateText("0"); }



    public void égaleBTN (View view){
        String userExp = afficher.getText().toString();

        userExp = userExp.replaceAll("/", "/");
        userExp = userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        afficher.setText(result);
        afficher.setSelection(result.length());
    }


    public void divisionBTN (View view){
        updateText("/");
    }

    public void effacerBTN(View view){
        int cursorPos = afficher.getSelectionStart();
        int tailleTxt = afficher.getText().length();

        if (cursorPos !=0 && tailleTxt != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) afficher.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            afficher.setSelection(cursorPos - 1);
        }
    }
}