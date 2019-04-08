package edu.floridapoly.cop4656.spring19.Brihoum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        public int ID;
        public Context context;

        public ListViewHolder(TextView tv) {
            super(tv);
            text = tv;
            context = tv.getContext();
            tv.setOnClickListener(this);
        }

        public void setText(String text) {
            this.text.setText(text);
        }

        public void setID(int index) {
            ID = index;
        }

        @Override
        public void onClick(View view) {
            System.out.println(ID);
            Database dbh = new Database(context);
            Intent intent = new Intent(context, AddNote.class);
            intent.putExtra("action", "edit");
            intent.putExtra("time", dbh.getTimeByID(ID));
            intent.putExtra("text", dbh.getTextByID(ID));
            intent.putExtra("id", ID);
            ((Activity) context).startActivityForResult(intent, 1);
        }
    }

    private ArrayList<String> data;
    private Context context;

    public ListAdapter(Context context, ArrayList<String> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListViewHolder listViewHolder = new ListViewHolder(new TextView(context));
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.setText(data.get(position));
        holder.setID(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
