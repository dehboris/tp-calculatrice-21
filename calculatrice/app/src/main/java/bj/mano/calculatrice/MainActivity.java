package bj.mano.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private TextView screen;
private double number;
private boolean isNewOp = false;
private boolean update = false;
private Button AC, Plus, Minus, Mul, Div, Dot, Equal, bu0, bu1, bu2, bu3, bu4, bu5, bu6, bu7, bu8, bu9;
private String operateur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen= (TextView) findViewById(R.id.screen);
        bu0= (Button) findViewById(R.id.btn0);
        bu1= (Button) findViewById(R.id.btn1);
        bu2= (Button) findViewById(R.id.btn2);
        bu3= (Button) findViewById(R.id.btn3);
        bu4= (Button) findViewById(R.id.btn4);
        bu5= (Button) findViewById(R.id.btn5);
        bu6= (Button) findViewById(R.id.btn6);
        bu7= (Button) findViewById(R.id.btn7);
        bu8= (Button) findViewById(R.id.btn8);
        bu9= (Button) findViewById(R.id.btn9);
        AC= (Button) findViewById(R.id.btnac);
        Plus= (Button) findViewById(R.id.btnPlus);
        Minus= (Button) findViewById(R.id.btnMinus);
        Mul= (Button) findViewById(R.id.btnMul);
        Div= (Button) findViewById(R.id.btnDiv);
        Dot= (Button) findViewById(R.id.btnDot);
        Equal= (Button) findViewById(R.id.btnEqual);


        Plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                plusClick();
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                minusClick();
            }
        });

        Mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mulClick();
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                divClick();
            }
        });

        AC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                acClick();
            }
        });

        Equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                equalClick();
            }
        });

        Dot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick(".");
            }
        });

        bu0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("0");
            }
        });

        bu1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("1");
            }
        });

        bu2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("2");
            }
        });

        bu3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("3");
            }
        });

        bu4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("4");
            }
        });

        bu5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("5");
            }
        });

        bu6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("6");
            }
        });

        bu7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("7");
            }
        });

        bu8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("8");
            }
        });

        bu9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numberClick("9");
            }
        });
    }
    public void numberClick(String str) {
        if(update){
            update = false;
        }else{
            if(!screen.getText().equals("0"))
                str = screen.getText() + str;
        }
        screen.setText(str);
    }

    public void plusClick(){

        if(isNewOp){
            calcul();
            screen.setText(String.valueOf(number));
        }else{
            number = Double.valueOf(screen.getText().toString()).doubleValue();
            isNewOp = true;
        }
        operateur = "+";
        update = true;
    }

    public void minusClick(){
        if(isNewOp){
            calcul();
            screen.setText(String.valueOf(number));
        }else{
            number = Double.valueOf(screen.getText().toString()).doubleValue();
            isNewOp = true;
        }
        operateur = "-";
        update = true;
    }

    public void mulClick(){
        if(isNewOp){
            calcul();
            screen.setText(String.valueOf(number));
        }else{
            number = Double.valueOf(screen.getText().toString()).doubleValue();
            isNewOp = true;
        }
        operateur = "*";
        update = true;
    }

    public void divClick(){
        if(isNewOp){
            calcul();
            screen.setText(String.valueOf(number));
        }else{
            number = Double.valueOf(screen.getText().toString()).doubleValue();
            isNewOp = true;
        }
        operateur = "/";
        update = true;
    }

    public void equalClick(){
        calcul();
        update = true;
        isNewOp = false;
    }

    public void acClick(){
        isNewOp = false;
        update = true;
        number = 0;
        operateur = "";
        screen.setText("");
    }

    private void calcul(){
        if(operateur.equals("+")){
            number = number + Double.valueOf(screen.getText().toString()).doubleValue();
            screen.setText(String.valueOf(number));
        }

        if(operateur.equals("-")){
            number = number - Double.valueOf(screen.getText().toString()).doubleValue();
            screen.setText(String.valueOf(number));
        }

        if(operateur.equals("*")){
            number = number * Double.valueOf(screen.getText().toString()).doubleValue();
            screen.setText(String.valueOf(number));
        }

        if(operateur.equals("/")){
            try{
                number = number / Double.valueOf(screen.getText().toString()).doubleValue();
                screen.setText(String.valueOf(number));
            }catch(ArithmeticException e){
                screen.setText("0");
            }
        }
    }
}