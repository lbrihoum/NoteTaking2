package edu.floridapoly.cop4656.spring19.Brihoum;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Database databaseHelper = new Database(this);

        RecyclerView list = findViewById(R.id.list);
        RecyclerView.Adapter adapter = new ListAdapter(this, databaseHelper.getList());
        databaseHelper.close();

        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Database database = new Database(MainActivity.this);
                database.recreateDB();
            }
        });

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNote = new Intent(MainActivity.this, AddNote.class);
                addNote.putExtra("action", "new");
                startActivityForResult(addNote, 1);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        super.onActivityResult(request, result, data);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
