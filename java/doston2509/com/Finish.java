package doston2509.com.guesscontinent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Finish extends AppCompatActivity implements View.OnClickListener{
    TextView namePlayer, scoring;
    Button restart, shutDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Play play = new Play();
        MainActivity main = new MainActivity();

        //namePlayer = (TextView)findViewById(R.id.playing);
        scoring = (TextView)findViewById(R.id.scoring);
        restart = (Button)findViewById(R.id.restart);
        shutDown = (Button)findViewById(R.id.shut);




        scoring.setText("Are you sure ? So fast");



    }
    @Override
    public void onClick(View view){
        restart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("doston2509.com.guesscontinent.Play");
                        startActivity(intent);
                    }
                }
        );

        shutDown.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        System.exit(0);
                    }
                }
        );
    }
}
