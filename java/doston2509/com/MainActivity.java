package doston2509.com.guesscontinent;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private Button enter;
    public String namePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //starting();


    }
    @Override
    public void onClick(View view){
        name = (EditText)findViewById(R.id.name);
        enter = (Button)findViewById(R.id.enter);




        enter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        namePlayer = name.getText().toString();

                        Toast.makeText(MainActivity.this, "Game started", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent("doston2509.com.guesscontinent.Play");
                        startActivity(intent);

                    }
                }
        );

    }
}
//android:layout_marginTop="30px"