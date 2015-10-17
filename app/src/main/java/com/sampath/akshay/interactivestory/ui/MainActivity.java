package com.sampath.akshay.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sampath.akshay.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameField;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mButton = (Button) findViewById(R.id.startButton);

        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mNameField.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                startStory(name);
            }
        };
        mButton.setOnClickListener(Listener);
    }

    private void startStory(String name){
        Intent intent = new Intent(MainActivity.this, StoryActivity.class); //Create an intent object
        intent.putExtra(getString(R.string.tag_name), name);
        startActivity(intent); //Start the intent
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
