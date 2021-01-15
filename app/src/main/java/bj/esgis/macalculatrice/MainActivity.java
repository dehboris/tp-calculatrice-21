package bj.esgis.macalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView Screen;
private Button AC,plus,less,div,one,two,three,foor,five,six,seven,eight,nine,zero,times,point,del,ans,equal;
private String input,answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=(TextView) findViewById(R.id.screen);
        AC=findViewById(R.id.AC);
        //continuer pareillement pour tout le reste
        plus=findViewById(R.id.plus);
        less=findViewById(R.id.less);
        div=findViewById(R.id.div);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        foor=findViewById(R.id.foor);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        zero=findViewById(R.id.zero);
        times=findViewById(R.id.times);
        point=findViewById(R.id.point);
        del=findViewById(R.id.del);
        ans=findViewById(R.id.ans);
        equal=findViewById(R.id.equal);
    }
    //ajouter un editeur pour chaque bouton
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data) {
            case "AC":
                input="";
                break;
            case "ANS":
                    input+=answer;
                break;
            case "*":
                Solve ();
                input+="*";
                break;
            case "=":
                Solve ();
                answer=input;
                break;
            case "DEL":
                String newText = input.substring(0,input.length()-1);
                 input = newText;
                 break;
            default:
                if (input ==null){
                    input="";
                }
                if (data.equals("+") || data.equals("-") ||data.equals("/")) {
                    Solve ();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private void Solve (){
        if ( input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double times = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = times+"";
            }
            catch (Exception e){
                // pour les erreurs
            }
        }
        else if (input.split("/").length==2) {
            String number[]=input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e){
                // pour les erreurs
            }
        }
        else if ( input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double plus = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = plus+"";
            }
            catch (Exception e){
                // pour les erreurs
            }
        }
        else if ( input.split("-").length>1){
            String number[]=input.split("-");
            // pour les nombres negatifs
        if (number[0]=="" && number.length==2){
            number[0]=0+"";
            }
            try {
                double less = 0;
                if( number.length==2){
                    less =Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if( number.length==3){
                    less = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = less+"";
            }
            catch (Exception e){
                // pour les erreurs
            }
        }
        //supprimer
        String n[]=input.split("\\.");
        if (n.length>1){
        if ( n[1].equals("0")){
            input=n[0];
        }
        Screen.setText(input);

    }
}
}