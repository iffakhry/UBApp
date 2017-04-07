package net.crevion.fakhry.ubapp2.adapter;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import net.crevion.fakhry.ubapp2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Fakhry on 04/04/2017.
 */

public class FacultyAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Faculty> mDataSource;

    public FacultyAdapter(Context context, List<Faculty> items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder{
        private TextView facultyName;
        private TextView webUrl;

    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.faculty_list_row, viewGroup, false);
            holder = new ViewHolder();
            holder.facultyName = (TextView) view.findViewById(R.id.faculty_name);
            holder.webUrl = (TextView) view.findViewById(R.id.weburl);

            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }

        Faculty faculty = (Faculty) getItem(position);
        holder.facultyName.setText(faculty.getNama());
        holder.webUrl.setText(faculty.getWeburl());

//        View rowView = mInflater.inflate(R.layout.faculty_list_row, viewGroup, false);
//        TextView facultyName = (TextView) rowView.findViewById(R.id.faculty_name);
//        TextView webUrl = (TextView) rowView.findViewById(R.id.weburl);
//
//        Faculty faculty = (Faculty) getItem(position);
//        facultyName.setText(faculty.getNama());
//        webUrl.setText(faculty.getWeburl());

        return view;
    }


//    private ArrayList<Faculty> facultyList;
//    Context mContext;
//
//    private static class ViewHolder {
//        TextView faculty;
//        TextView weburl;
//    }
//
//    public FacultyAdapter(ArrayList<Faculty> data, Context context){
//        super(context, R.layout.faculty_list_row, data);
//        this.facultyList = data;
//        this.mContext = context;
//    }
//
//    @Override
//    public void onClick(View view) {
//        int position = (Integer) view.getTag();
//        Object object = getItem(position);
//        Faculty faculty = (Faculty)object;
//
//        switch (view.getId()){
//            case R.id.item_info:
//                Toast.makeText(getContext(), "Info : " +faculty.getNama(), Toast.LENGTH_LONG).show();
//        }
//    }
//
//    private int lastPosition = -1;



////////////
//    private List<Faculty> facultyList;
//
//
//    public class MyViewHolder extends RecyclerView.ViewHolder{
//        public TextView nama, weburl;
//
//        public MyViewHolder(View view){
//            super(view);
//            nama = (TextView) view.findViewById(R.id.faculty);
//            weburl = (TextView) view.findViewById(R.id.weburl);
//        }
//    }
//
//    public FacultyAdapter(List<Faculty> facultyList){
//        this.facultyList = facultyList;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_list_row, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Faculty faculty = facultyList.get(position);
//        holder.nama.setText(faculty.getNama());
//        holder.weburl.setText(faculty.getWeburl());
//    }
//
//    @Override
//    public int getItemCount() {
//        return facultyList.size();
//    }
}
