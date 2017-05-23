package doston2509.com.guesscontinent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Details extends AppCompatActivity implements View.OnClickListener{

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        button = (Button)findViewById(R.id.movingBack);
    }
    @Override
    public void onClick(View view){

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Details.this, "Your visit is sent to server", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent("doston2509.com.guesscontinent.Play");
                        startActivity(intent);
                    }
                }
        );


    }
}
