# NoteTaking2
# Project Details: 
- Create a project named NoteTaking_YourLastNameb.  
- Your app name will be ‘NoteTakingWithListAndDB’
- The package name for your project should be: edu.floridapoly.cop4656.spring19.yourlastname

# Main Screen
- Your first (main) screen will have a list (recyclerview)
- Each row of the list will present the note and the date/time it was recorded 
- Row data will come from an SQLite DB
- Initially, list will be empty, (there will be no row) since the DB will be empty

- Add a FloatingActionButton on top of the list to add new notes to the database
- When clicked, it is going to start a new activity to allow new note entry

# Add Note Screen
- On the ‘Add Note’ screen, at minimum, you will have the following widgets:
- EditText to enter the note (user can enter the note into this widget)
- TextView to show the current date/time (user cannot enter data into this widget, current date/time is set when activity starts)
- Cancel button (closes the activity)d.  Add button (adds the note to the database and then closes the activity)

- When a row of the list is clicked, it will start an activity where user can do the followings:
- Update (updates the same note and closes the activity) User will be able to update only the note, date/time cannot be changed.
- Delete (deletes the note from the database and closes the activity)
- Cancel (closes the activity)

- As user returns from the screens to add or update/delete note back to the list screen, the list will get refreshed.
