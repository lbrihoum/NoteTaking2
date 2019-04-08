package edu.floridapoly.cop4656.spring19.Brihoum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNote extends AppCompatActivity {

    private EditText text;
    private TextView time;

    private boolean creating;
    private int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        text = findViewById(R.id.editText);
        time = findViewById(R.id.timeView);
        Button addButton = findViewById(R.id.addButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        Intent intent = getIntent();
        if (intent.getStringExtra("action").equals("new")) {
            creating = true;
        } else {
            creating = false;
        }

        if (creating) {
            deleteButton.setVisibility(Button.INVISIBLE);
            deleteButton.setEnabled(false);

            Date date = new Date();
            DateFormat df = new SimpleDateFormat("MMM dd yyyy hh:mm:ss a");
            time.setText(df.format(date));
        } else {
            addButton.setText("Edit Text");
            time.setText(intent.getStringExtra("time"));
            text.setText(intent.getStringExtra("text"));
            ID = intent.getIntExtra("id", -1);
        }

        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Database dbh = new Database(AddNote.this);
                dbh.deleteItem(ID);
                dbh.close();
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Database dbh = new Database(AddNote.this);
                if (creating) {
                    dbh.addItem(text.getText().toString(), time.getText().toString());
                } else {
                    if (ID != -1)
                        dbh.editItem(ID, text.getText().toString());
                }
                dbh.close();
                finish();
            }
        });

    }
}
