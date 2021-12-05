package com.example.rickmc.javapractice10activityb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        showMessage = (TextView) findViewById(R.id.messageViewID);
        backButton = (Button) findViewById(R.id.backButtonID);

        //check

        if(extras != null) {
            String message = extras.getString("Message");
            int myInt = extras.getInt("Value");

            showMessage.setText("Text is :"+ message + String.valueOf(myInt));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                ((Intent) returnIntent).putExtra("returnData", "From SecondActivity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
