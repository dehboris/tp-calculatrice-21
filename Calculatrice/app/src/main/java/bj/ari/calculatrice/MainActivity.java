package bj.ari.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public enum Operations
    {
        PLUS("+"),
        MOINS("-"),
        FOIS("*"),
        DIV("/");

        private String name="";
        Operations(String name)
        {
            this.name=name;
        }
        public String toString()
        {
            return name;
        }
    }

    private TextView screen;
    private int nbre1=0;
    private int nbre2=0;
    private Operations sign=null;
    private boolean isOp1=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=(TextView) findViewById(R.id.screen);

        Button btnEgal=(Button) findViewById(R.id.btnEgal);
        btnEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                comupute();
            }
        });

        Button btnClear=(Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                clear();
            }
        });

    }


    private void updateDisplay()
    {
        int a=nbre1;
        if (!isOp1)
        {
            a=nbre2;
        }
        screen.setText(String.format("%9d",a));
    }

    public void comupute()
    {
        if (isOp1){
            //ne fais rien
        }
        else
        {
            switch (sign)
            {
                case PLUS: nbre1=nbre1+nbre2;
                break;
                case MOINS:nbre1=nbre1-nbre2;
                break;
                case FOIS:nbre1=nbre1*nbre2;
                break;
                case DIV:nbre1=nbre1/nbre2;
                break;
                default: return;  // ne fais rien si il n'y a pas d'operateurs
            }
            nbre2=0;
            isOp1=true;
            updateDisplay();
        }
    }

    private void clear()
    {
        nbre1=0;
        nbre2=0;
        sign=null;
        isOp1=true;
        updateDisplay();
    }

    public void setSign(View a)
    {

        switch (a.getId()){
            case R.id.btnPlus: sign=Operations.PLUS;
            break;
            case R.id.btnMoins: sign=Operations.MOINS;
                break;
            case R.id.btnFois: sign=Operations.FOIS;
                break;
            case R.id.btnDiv: sign=Operations.DIV;
                break;
            default:
                Toast.makeText(this, "Opérateur non reconnu", Toast.LENGTH_LONG);
                return;
        }
        isOp1=false;
        updateDisplay();
    }

    public void ajoutNombre(View a)
    {
       try {
           int val=Integer.parseInt(((Button)a).getText().toString());
          if (isOp1)
          {
            nbre1=nbre1*10+val;
            updateDisplay();
          }
        else {
            nbre2=nbre2*10+val;
            updateDisplay();
        }
       }
       catch (NumberFormatException|ClassCastException exception)
       {
           Toast.makeText(this,"Votre valeur est erronée", Toast.LENGTH_LONG);
       }
    }

}