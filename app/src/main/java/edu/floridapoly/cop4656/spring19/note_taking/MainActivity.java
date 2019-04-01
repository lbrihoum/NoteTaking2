package edu.floridapoly.cop4656.spring19.note_taking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private NotesAdapter mAdapter;
    private List<Note> notesList = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private TextView noNotesView;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NoteAdd.class);
                startActivity(i);
            }
        });
        //db = new Database(this);

//        noNotesView = findViewById(R.id.empty_notes_view);
//
//        notesList.addAll(db.getAllNotes());
//
//        //mAdapter = new NotesAdapter(this, notesList);
//        //recyclerView.setAdapter(mAdapter);
//
//        toggleEmptyNotes();
//
//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
//                recyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, final int position) {
//                // go to second screen and pass note to it
//            }
//        }));
    }
}

//
//    /**
//     * Updating note in db and updating
//     * item in the list by its position
//     */
//    private void updateNote(String note, int position) {
//        Note n = notesList.get(position);
//        // updating note text
//        n.setNote(note);
//
//        // updating note in db
//        db.updateNote(n);
//
//        // refreshing the list
//        notesList.set(position, n);
//        mAdapter.notifyItemChanged(position);
//
//        toggleEmptyNotes();
//    }
//
//    /**
//     * Deleting note from SQLite and removing the
//     * item from the list by its position
//     */
//    private void deleteNote(int position) {
//        // deleting the note from db
//        db.deleteNote(notesList.get(position));
//
//        // removing the note from the list
//        notesList.remove(position);
//        mAdapter.notifyItemRemoved(position);
//
//        toggleEmptyNotes();
//    }
//
//    /**
//     * Opens dialog with Edit - Delete options
//     * Edit - 0
//     * Delete - 0
//     */
//    private void showActionsDialog(final int position) {
//        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Choose option");
//        builder.setItems(colors, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (which == 0) {
//                    showNoteDialog(true, notesList.get(position), position);
//                } else {
//                    deleteNote(position);
//                }
//            }
//        });
//        builder.show();
//    }
//
//    /**
//     * Toggling list and empty notes view
//     */
//    private void toggleEmptyNotes() {
//        // you can check notesList.size() > 0
//
//        if (db.getNotesCount() > 0) {
//            noNotesView.setVisibility(View.GONE);
//        } else {
//            noNotesView.setVisibility(View.VISIBLE);
//        }
//    }
