package bj.landry.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber="";
    String Operateur="+";

    boolean estunoperateur=true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(estunoperateur)
            ed1.setText("");
            estunoperateur=false;

        String number= ed1.getText().toString();
        switch (view.getId())
        {
                case R.id.un:
                number +="1";
                break;
                case R.id.deux:
                number +="2";
                break;
                case R.id.trois:
                number +="3";
                break;
                case R.id.quatre:
                number +="4";
                break;
                case R.id.cinq:
                number +="5";
                break;
                case R.id.six:
                number +="6";
                break;
                case R.id.sept:
                number +="7";
                break;
                case R.id.huit:
                number +="8";
                break;
                 case R.id.neuf:
                number +="9";
                     break;
                 case R.id.zero:
                number +="0";
                break;
                 case R.id.virgule:
                number +=".";
                break;
                 case R.id.plusoumoins:
                number ="-"+number;
                break;

        }
        ed1.setText(number);
    }

    public void operateur(View view) {
        estunoperateur=true;
        oldNumber=ed1.getText().toString();

        switch (view.getId()) {
            case R.id.division:
                Operateur  = "/";
                break;

            case R.id.multiplication:
                Operateur = "x";
                break;

            case R.id.plus:
                Operateur = "+";
                break;

            case R.id.moins:
                Operateur = "-";
                break;
        }
    }

    public void egal(View view) {
        String newnumber=ed1.getText().toString();
        Double resultat= 0.0;


        switch (Operateur) {
            case "+":
                resultat  = Double.parseDouble(oldNumber) + Double.parseDouble(newnumber);
                break;

            case "-":
                resultat  = Double.parseDouble(oldNumber) - Double.parseDouble(newnumber);
                break;

            case "/":
                resultat  = Double.parseDouble(oldNumber) / Double.parseDouble(newnumber);
                break;
            case "x":
                resultat  = Double.parseDouble(oldNumber) * Double.parseDouble(newnumber);
                break;

        }
        ed1.setText(resultat+"");
    }

    public void renitialisation(View view) {
        ed1.setText("0");
        estunoperateur=true;
    }

    public void pourcentage(View view) {
        Double pourcent=Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(pourcent+"");
        estunoperateur=true;
    }
}