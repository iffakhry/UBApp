package net.crevion.fakhry.ubapp2;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import net.crevion.fakhry.ubapp2.adapter.Faculty;
import net.crevion.fakhry.ubapp2.fragment.MapFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        CardView cardView1 = (CardView) findViewById(R.id.card_view_description);
        TextView textViewDescription = (TextView) cardView1.findViewById(R.id.desc_textview);

        String faculty_value = "-";
        String url_value = "-";
        String description_value = "-";

        Intent resultIntent = getIntent();
        int position = resultIntent.getIntExtra("position",-1);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAssets());
            JSONArray jsonArray = obj.getJSONArray("faculties");

            JSONObject jsonObject = jsonArray.getJSONObject(position);
            Log.v("cekprofil", jsonObject.getString("faculty"));
             faculty_value = jsonObject.getString("faculty");
             url_value = jsonObject.getString("url");
             description_value = jsonObject.getString("description");

//            Faculty faculty;
//            for (int i = 0; i < jsonArray.length(); i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                Log.v("cekdetail", jsonObject.getString("faculty"));
//                String faculty_value = jsonObject.getString("faculty");
//                String url_value = jsonObject.getString("url");
//                String description_value = jsonObject.getString("description");
//
//                faculty = new Faculty(faculty_value, url_value, description_value);
//                facultyList.add(faculty);
//            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        collapsingToolbar.setTitle(faculty_value);
        textViewDescription.setText(description_value);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, WebActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MapFragment maps = new MapFragment();
        fragmentTransaction.add(R.id.fragment_map, maps, "MAP");
        fragmentTransaction.commit();
    }

    private String loadJSONFromAssets(){
        String json = null;
        try {
//            InputStream is = getActivity().getAssets().open("faculty.json");
            InputStream is = this.getAssets().open("faculty.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void prepareFacultyData(int position) {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAssets());
            JSONArray jsonArray = obj.getJSONArray("faculties");

            JSONObject jsonObject = jsonArray.getJSONObject(position);
            Log.v("cekprofil", jsonObject.getString("faculty"));

//            Faculty faculty;
//            for (int i = 0; i < jsonArray.length(); i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                Log.v("cekdetail", jsonObject.getString("faculty"));
//                String faculty_value = jsonObject.getString("faculty");
//                String url_value = jsonObject.getString("url");
//                String description_value = jsonObject.getString("description");
//
//                faculty = new Faculty(faculty_value, url_value, description_value);
//                facultyList.add(faculty);
//            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
