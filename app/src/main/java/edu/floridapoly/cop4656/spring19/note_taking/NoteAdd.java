package edu.floridapoly.cop4656.spring19.note_taking;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdd extends AppCompatActivity {

    private List<Note> notesList = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private TextView noNotesView;
    private Note mAdapter;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        // Add Note Button
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

//                // Show toast message when no text is entered
//                 if (TextUtils.isEmpty(inputNote.getText().toString())) {
//                     Toast.makeText(NoteAdd.this, "Please enter your note!", Toast.LENGTH_SHORT).show();
//                     return;
//                 }

                 // create new note
                 //createNote(inputNote.getText().toString());i
             }
        });

        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(NoteAdd.this, MainActivity.class);
                finish();
            }
        });

    }

//    private void createNote(String note) {
//        // inserting note in db and getting
//        // newly inserted note id
//        long id = db.insertNote(note);
//
//        // get the newly inserted note from db
//        Note n = db.getNote(id);
//
//        if (n != null) {
//            // adding new note to array list at 0 position
//            notesList.add(0, n);
//
//            // refreshing the list
//            mAdapter.notifyDataSetChanged();
//
//            toggleEmptyNotes();
//        }
//    }

//
//    /**
//     * Inserting new note in db
//     * and refreshing the list
//     */
//    private void createNote(String note) {
//        // inserting note in db and getting
//        // newly inserted note id
//        long id = db.insertNote(note);
//
//        // get the newly inserted note from db
//        Note n = db.getNote(id);
//
//        if (n != null) {
//            // adding new note to array list at 0 position
//            notesList.add(0, n);
//
//            // refreshing the list
//            mAdapter.notifyDataSetChanged();
//
//            toggleEmptyNotes();
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        // Show toast message when no text is entered
//        if (TextUtils.isEmpty(inputNote.getText().toString())) {
//            Toast.makeText(MainActivity.this, "Enter note!", Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            alertDialog.dismiss();
//        }
//
//        // check if user updating note
//        if (shouldUpdate && note != null) {
//            // update note by it's id
//            updateNote(inputNote.getText().toString(), position);
//        } else {
//            // create new note
//            createNote(inputNote.getText().toString());
//        }
//    }
//
//    /**
//     * Shows alert dialog with EditText options to enter / edit
//     * a note.
//     * when shouldUpdate=true, it automatically displays old note and changes the
//     * button text to UPDATE
//     */
//    private void showNoteDialog(final boolean shouldUpdate, final Note note, final int position) {
//        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
//        View view = layoutInflaterAndroid.inflate(R.layout.note_dialog, null);
//
//        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(MainActivity.this);
//        alertDialogBuilderUserInput.setView(view);
//
//        final EditText inputNote = view.findViewById(R.id.note);
//        TextView dialogTitle = view.findViewById(R.id.dialog_title);
//        dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_note_title) : getString(R.string.lbl_edit_note_title));
//
//        if (shouldUpdate && note != null) {
//            inputNote.setText(note.getNote());
//        }
//        alertDialogBuilderUserInput
//                .setCancelable(false)
//                .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogBox, int id) {
//
//                    }
//                })
//                .setNegativeButton("cancel",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialogBox, int id) {
//                                dialogBox.cancel();
//                            }
//                        });
//
//
//    private String formatDate(String dateStr) {
//        try {
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = fmt.parse(dateStr);
//            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
//            return fmtOut.format(date);
//        } catch (ParseException e) {
//
//        }
//
//        return "";
//    }
//
//    //deleteNote(position);
//
}


