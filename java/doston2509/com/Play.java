package doston2509.com.guesscontinent;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Play extends AppCompatActivity implements View.OnClickListener{
    private Button answer, finishing;
    private TextView questionNum, scoreF, question, asia, africa, sAmerica, nAmerica, euro;
    private EditText choice;





    int rand = Random();
    int number = 1;
    public int score = 0;
    public int publishScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);



        answer = (Button)findViewById(R.id.answer);
        finishing = (Button)findViewById(R.id.tugat);
        questionNum = (TextView)findViewById(R.id.questionNum);
        scoreF = (TextView)findViewById(R.id.score);
        question = (TextView)findViewById(R.id.question);
        asia = (TextView)findViewById(R.id.asia);
        africa = (TextView)findViewById(R.id.africa);
        sAmerica = (TextView)findViewById(R.id.southAmerica);
        nAmerica = (TextView)findViewById(R.id.northAmerica);
        euro = (TextView)findViewById(R.id.europa);
        choice = (EditText)findViewById(R.id.choice);

        answer.setText("Start Game");
        questionNum.setVisibility(View.GONE);
        choice.setVisibility(View.GONE);
        scoreF.setVisibility(View.GONE);
        asia.setVisibility(View.GONE);
        africa.setVisibility(View.GONE);
        sAmerica.setVisibility(View.GONE);
        nAmerica.setVisibility(View.GONE);
        euro.setVisibility(View.GONE);



        //question.setText();
    }
    @Override
    public void onClick(View view){

        //questionNum.setText("Question Number: " + number);
        giveQuestion(rand);
        answer.setText("Check");
        questionNum.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        asia.setVisibility(View.VISIBLE);
        africa.setVisibility(View.VISIBLE);
        sAmerica.setVisibility(View.VISIBLE);
        nAmerica.setVisibility(View.VISIBLE);
        euro.setVisibility(View.VISIBLE);
        scoreF.setVisibility(View.VISIBLE);
        choice.setVisibility(View.VISIBLE);

        answer.setOnClickListener(



                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int selected = Integer.parseInt(choice.getText().toString());
                        if ( selected == 25091995){
                            Intent intent = new Intent("doston2509.com.guesscontinent.Details");
                            startActivity(intent);
                        } else {
                            Matching(rand, selected);
                            rand = Random();

                            number++;
                            questionNum.setVisibility(View.VISIBLE);
                            questionNum.setText("Question Number: " + number);
                            choice.setText("");
                            giveQuestion(rand);
                        }
                    }
                }



        );

//        finishing.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        publishScore = score;
//
//
//                        Intent intent = new Intent("doston2509.com.guesscontinent.Finish");
//                        startActivity(intent);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                    }
//                }
//        );
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure, you want to close app?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                                finish();
                                System.exit(0);
                            }
                        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Play.this, "Wel-come back go game", Toast.LENGTH_SHORT);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void giveQuestion(int random){
        question.setText("In which continent is " + Country(random) + " located ?");
    }

    public static int Random(){
        Random rand = new Random();
        return rand.nextInt(65);
    }
    public String Country(int random){
        ArrayList<String> list = new ArrayList<String>();


        list.add("China");list.add("Japan");list.add("South Korea");list.add("Uzbekistan");list.add("India"); // in Asia
        list.add("Bangladesh");list.add("Iran");list.add("Nepal");list.add("Pakistan");list.add("Turkey");
        list.add("Tajikistan");list.add("Russian Federation");list.add("United Arab Emirates");list.add("Vietnam");list.add("Singapore");

        list.add("Namibia");list.add("Ghana");list.add("Egypht");list.add("Congo");list.add("Algeria"); // in Africa
        list.add("Angola");list.add("Cameroon");list.add("Gambia");list.add("Kenya");list.add("Libya");
        list.add("Liberia");list.add("Ethiopia");list.add("Nigeria");list.add("Niger");list.add("Somalia");

        list.add("Brazil");list.add("Chile");list.add("Argentina");list.add("Peru");list.add("Ecuador"); // in South America
        list.add("Bolivia");list.add("Guyana");list.add("Paraguay");list.add("Uruguay");list.add("Venezuela");
        //list.add("");list.add("");list.add("");list.add("");list.add("");

        list.add("Canada");list.add("Mexico");list.add("Cuba");list.add("Dominica");list.add("USA"); //North America
        list.add("Honduras");list.add("Panama");list.add("Honduras");list.add("Cuba");list.add("Mexico");
        //list.add("");list.add("");list.add("");list.add("");list.add("");

        list.add("Malta");list.add("Liechtenstein");list.add("Iceland");list.add("Georgia");list.add("Cyrpus"); //Europe
        list.add("Albania");list.add("Armenia");list.add("Azerbaijan");list.add("Bulgaria");list.add("Czech Republic");
        list.add("Finland");list.add("Hungary");list.add("Luxembourg");list.add("Moldova");list.add("Norway");

        return list.get(random);

    }

    public void Matching(int random, int choice){

        if(random < 16 && choice == 1){
            score = score + 1;
            scoreF.setText("Your score is " + score);
            Toast.makeText(Play.this, "Correct answer", Toast.LENGTH_SHORT).show();
        }
        else if(random > 15 && random < 31 && choice == 2){
            score = score + 1;
            scoreF.setText("Your score is " + score);
            Toast.makeText(Play.this, "Correct answer", Toast.LENGTH_SHORT).show();
        }
        else if(random > 30 && random < 41 && choice == 3){
            score = score + 1;
            scoreF.setText("Your score is " + score);
            Toast.makeText(Play.this, "Correct answer", Toast.LENGTH_SHORT).show();
        }
        else if(random > 40 && random < 51 && choice == 4){
            score = score + 1;
            scoreF.setText("Your score is " + score);
            Toast.makeText(Play.this, "Correct answer", Toast.LENGTH_SHORT).show();
        }
        else if(random > 50 && random < 66 && choice == 5){
            score = score + 1;
            scoreF.setText("Your score is " + score);
            Toast.makeText(Play.this, "Correct answer", Toast.LENGTH_SHORT).show();
        }else{
            scoreF.setText("Your score is " + score);
            Toast.makeText(Play.this, "Incorrect answer", Toast.LENGTH_SHORT).show();
        }

    }
}
