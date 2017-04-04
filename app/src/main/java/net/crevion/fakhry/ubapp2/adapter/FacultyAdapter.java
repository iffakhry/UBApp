package net.crevion.fakhry.ubapp2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.crevion.fakhry.ubapp2.R;

import java.util.List;

/**
 * Created by Fakhry on 04/04/2017.
 */

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.MyViewHolder>{
    private List<Faculty> facultyList;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nama, weburl;

        public MyViewHolder(View view){
            super(view);
            nama = (TextView) view.findViewById(R.id.faculty);
            weburl = (TextView) view.findViewById(R.id.weburl);
        }
    }

    public FacultyAdapter(List<Faculty> facultyList){
        this.facultyList = facultyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Faculty faculty = facultyList.get(position);
        holder.nama.setText(faculty.getNama());
        holder.weburl.setText(faculty.getWeburl());
    }

    @Override
    public int getItemCount() {
        return facultyList.size();
    }
}
