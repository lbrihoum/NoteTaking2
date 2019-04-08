package edu.floridapoly.cop4656.spring19.Brihoum;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "NoteTaking.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE notes (ID INTEGER NOT NULL PRIMARY KEY,text TEXT,time TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> getList() {
        Cursor cursor = getWritableDatabase().rawQuery("SELECT text, time FROM notes;", null);
        ArrayList<String> list = new ArrayList<>();
        while(cursor.moveToNext()) {
            list.add(cursor.getString(1)+" - "+cursor.getString(0));
        }
        cursor.close();
        return list;
    }

    public void addItem(String string, String dateTime) {
        getWritableDatabase().execSQL("INSERT INTO notes(ID, text, time) VALUES("+getTableLength()+",'"+string+"','"+dateTime+"');");
    }

    private int getTableLength() {
        Cursor cursor = getWritableDatabase().rawQuery("SELECT ID FROM notes;", null);
        int ret = cursor.getCount();
        cursor.close();
        return ret;
    }

    public void editItem(int index, String string) {
        getWritableDatabase().execSQL("UPDATE notes SET text = '"+string+"' WHERE ID = "+index+";");
    }

    public void deleteItem(int index) {
        getWritableDatabase().execSQL("DELETE FROM notes WHERE ID = "+index+";");
        getWritableDatabase().execSQL("UPDATE notes SET ID = ID - 1 WHERE ID > "+index+";");
    }

    public String getTextByID(int index) {
        Cursor cursor = getWritableDatabase().rawQuery("SELECT text FROM notes WHERE ID = "+index+";", null);
        cursor.moveToFirst();
        String ret = cursor.getString(0);
        cursor.close();
        return ret;
    }

    public String getTimeByID(int index) {
        Cursor cursor = getWritableDatabase().rawQuery("SELECT time FROM notes WHERE ID = "+index+";", null);
        cursor.moveToFirst();
        String ret = cursor.getString(0);
        cursor.close();
        return ret;
    }

    public void recreateDB() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE notes;");
        db.execSQL("CREATE TABLE notes (ID INTEGER NOT NULL PRIMARY KEY,text TEXT,time TEXT);");
    }
}
