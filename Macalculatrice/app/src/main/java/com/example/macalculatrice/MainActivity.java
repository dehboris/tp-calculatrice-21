package com.example.macalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView screen1;
    private HorizontalScrollView scroll1;
    private HorizontalScrollView scroll2;
    private TextView screen2;
    private List<String> liste_operateur = new ArrayList<>();
    private List<Double> liste_nombre = new ArrayList<>();
    private String chaine_nombre = "";
    private String vue1 = "";
    private boolean r = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lockDeviceRotation(true);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        screen1 = findViewById(R.id.screen1);
        screen2 = findViewById(R.id.screen2);

        scroll1 = findViewById(R.id.scroll1);
        scroll2 = findViewById(R.id.scroll2);

        Button btnEgal = findViewById(R.id.btnEgal);
        btnEgal.setOnClickListener(v -> calcul());

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(view -> clear());
    }

    public void lockDeviceRotation(boolean value) {
        if (value) {
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            }
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
            }
        }
    }

    public void updateDisplay1(){
        screen1.setText(vue1);
        scroll1.scrollTo(screen1.getWidth(), 0);
    }

    public void updateDisplay2(){
        screen2.setText(chaine_nombre);
        scroll1.scrollTo(screen1.getWidth(), 0);
    }

    public void addNumberChar(View v){
        if(r){
            screen1.setVisibility(View.GONE);
            chaine_nombre = "";
            r = false;
        }
        if(chaine_nombre.equals("0")){
            chaine_nombre= "";
        }
        chaine_nombre += ((Button)v).getText().toString();
        updateDisplay2();
    }

    public void remplaceVirgule(){
        StringBuilder chaine = new StringBuilder();
        for(int i =0; i<chaine_nombre.length(); i++){
            if(chaine_nombre.charAt(i) == ','){
                chaine.append(".");
            }
            else {
                chaine.append(chaine_nombre.charAt(i));
            }
        }
        chaine_nombre = chaine.toString();
    }

    public void remplacePoint(){
        StringBuilder chaine = new StringBuilder();
        for(int i =0; i<vue1.length(); i++){
            if(vue1.charAt(i) == '.'){
                chaine.append(",");
            }
            else {
                chaine.append(vue1.charAt(i));
            }
        }
        vue1 = chaine.toString();
    }

    public void addVirguleToNumber(View v){
        if(r){
            screen1.setVisibility(View.GONE);
            r = false;
        }

        if(!chaine_nombre.isEmpty()){
            boolean trouver =false;
            for(int i =0; i<chaine_nombre.length(); i++){
                if(chaine_nombre.charAt(i) == ',' || chaine_nombre.charAt(i) == '.'){
                    trouver = true;
                    break;
                }
            }
            if(!trouver){
                chaine_nombre += ",";
                updateDisplay2();
            }
        }
    }

    public void plusMoins(View v){
        if(r){
            screen1.setVisibility(View.GONE);
            r = false;
        }

        if(!chaine_nombre.isEmpty() && !chaine_nombre.equals("0")){
            boolean trouver =false;
            StringBuilder chaine = new StringBuilder();
            if(chaine_nombre.charAt(0) == '-'){
                trouver =true;
            }

            if(!trouver){
                chaine.append("-");
                for(int i =0; i<chaine_nombre.length(); i++){
                    chaine.append(chaine_nombre.charAt(i));
                }
            }
            else{
                for(int i =1; i<chaine_nombre.length(); i++){
                    chaine.append(chaine_nombre.charAt(i));
                }
            }
            chaine_nombre = chaine.toString();

            chaine = new StringBuilder();
            for(int i =0; i<chaine_nombre.length(); i++){
                if(chaine_nombre.charAt(i) == '.'){
                    chaine.append(",");
                }
                else {
                    chaine.append(chaine_nombre.charAt(i));
                }
            }
            chaine_nombre = chaine.toString();

            updateDisplay2();
        }
    }

    public void pourcentage(View v){
        if(r){
            screen1.setVisibility(View.GONE);
            r = false;
        }
        if(!chaine_nombre.isEmpty()){
            double nombre = Double.parseDouble(chaine_nombre);
            nombre *= 0.01;
            if(nombre<0){
                nombre *= -1;
            }

            chaine_nombre ="";
            chaine_nombre += nombre;

            StringBuilder chaine = new StringBuilder();
            for(int i =0; i<chaine_nombre.length(); i++){
                if(chaine_nombre.charAt(i) == '.'){
                    chaine.append(",");
                }
                else {
                    chaine.append(chaine_nombre.charAt(i));
                }
            }
            chaine_nombre = chaine.toString();

            updateDisplay2();
        }
    }

    public void clear(){//on réinitialise tout
        liste_operateur = new ArrayList<>();
        liste_nombre = new ArrayList<>();
        chaine_nombre = "";
        vue1 = "";

        updateDisplay1();
        screen1.setVisibility(View.GONE);
        updateDisplay2();
    }

    public void addNumberAndOp(View v){
        if(chaine_nombre.isEmpty()){
            if(!vue1.isEmpty()){//on change le dernier opérateur
                StringBuilder chaine = new StringBuilder();
                for(int i = 0; i < vue1.length()-1; i++){
                    chaine.append(vue1.charAt(i));
                }
                chaine.append(((Button)v).getText().toString());
                vue1 = chaine.toString();
                updateDisplay1();
                liste_operateur.set(liste_operateur.size()-1, ((Button)v).getText().toString());
            }
        }
        else{
            if(vue1.isEmpty()){//on ajoute le premier op et le premier nombre
                vue1 = chaine_nombre + " " + ((Button)v).getText().toString();
                remplaceVirgule();
                liste_operateur.add(((Button)v).getText().toString());
                liste_nombre.add(Double.parseDouble(chaine_nombre));
                screen1.setVisibility(View.VISIBLE);
            }
            else{
                vue1 += " " + chaine_nombre + " " + ((Button)v).getText().toString();
                remplaceVirgule();
                liste_operateur.add(((Button)v).getText().toString());
                liste_nombre.add(Double.parseDouble(chaine_nombre));
            }
            chaine_nombre = "";
            if(r){
                r = false;
                remplacePoint();
            }
            updateDisplay1();
            updateDisplay2();
        }
    }

    public void delchar(View v){
        if(r){
            chaine_nombre = "";
            updateDisplay2();
            screen1.setVisibility(View.GONE);
            r = false;
        }
        if(!chaine_nombre.isEmpty()){
            StringBuilder chaine = new StringBuilder();
            for(int i = 0; i<chaine_nombre.length()-1; i++){
                chaine.append(chaine_nombre.charAt(i));
            }
            chaine_nombre = chaine.toString();

            if(chaine_nombre.length() == 1 && chaine_nombre.charAt(0) == '-'){
                chaine_nombre = "";
            }
            updateDisplay2();
        }
    }

    public void calcul(){
        if(chaine_nombre.isEmpty()){
            if(!vue1.isEmpty()){
                char lastC = vue1.charAt(vue1.length()-1);
                if(lastC == '+' || lastC == '-'){
                    vue1+= " 0";
                    chaine_nombre ="0";
                }
                else{
                    vue1+= " 1";
                    chaine_nombre ="1";
                }
                calc();
            }
        }
        else{
            if(vue1.isEmpty()){
                vue1 = chaine_nombre;
            }
            else{
                vue1 += " " + chaine_nombre;
            }
            calc();
        }
    }

    @SuppressLint("DefaultLocale")
    public void  calc(){
        if(r){
            r = false;
            remplacePoint();
        }
        vue1 += " =";//afficher le symbole égal
        screen1.setVisibility(View.VISIBLE);
        updateDisplay1();
        remplaceVirgule();
        liste_nombre.add(Double.parseDouble(chaine_nombre));//ajouter le dernier nombre à la liste de nombre

        for(int i=0; i<liste_operateur.size(); i++){//on commence par un parcours des opérateurs *
            if(liste_operateur.get(i).equals("*")){
                Double calc = liste_nombre.get(i) * liste_nombre.get(i+1);

                liste_nombre.set(i, calc);
                liste_nombre.remove(i+1);

                liste_operateur.remove(i);
                i--;
            }
        }
        for(int i=0; i<liste_operateur.size(); i++){//ensuite les + et -
            if(liste_operateur.get(i).equals("+") || liste_operateur.get(i).equals("-")){
                Double calc;
                if(liste_operateur.get(i).equals("+"))
                    calc = liste_nombre.get(i) + liste_nombre.get(i+1);
                else
                    calc = liste_nombre.get(i) - liste_nombre.get(i+1);

                liste_nombre.set(i, calc);
                liste_nombre.remove(i+1);

                liste_operateur.remove(i);
                i--;
            }
        }
        for(int i=0; i<liste_operateur.size(); i++){//enfin les /
            if(liste_operateur.get(i).equals("/")){
                Double calc = liste_nombre.get(i) / liste_nombre.get(i+1);

                liste_nombre.set(i, calc);
                liste_nombre.remove(i+1);

                liste_operateur.remove(i);
                i--;
            }
        }

        double resultat = liste_nombre.get(0);//la liste des op est vide,il reste un seul nombre on le recupere
        int cast =  (int)resultat;
        chaine_nombre = "";
        if(cast == resultat){
            chaine_nombre +=  cast;
        }
        else{
            chaine_nombre +=  String.format("%.2f", resultat);
        }
        updateDisplay2();

        String ch = "";
        ch += resultat;
        if(ch.equals("Infinity")){
            chaine_nombre="";
        }
        else{
            StringBuilder chaine = new StringBuilder();
            for(int i =0; i<chaine_nombre.length(); i++){
                if(chaine_nombre.charAt(i) == ','){
                    chaine.append(".");
                }
                else {
                    chaine.append(chaine_nombre.charAt(i));
                }
            }
            chaine_nombre = chaine.toString();
        }

        liste_operateur = new ArrayList<>();
        liste_nombre = new ArrayList<>();
        vue1 = "";
        r = true;
    }

}