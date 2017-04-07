package net.crevion.fakhry.ubapp2.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import net.crevion.fakhry.ubapp2.ProfileActivity;
import net.crevion.fakhry.ubapp2.R;
import net.crevion.fakhry.ubapp2.adapter.Faculty;
import net.crevion.fakhry.ubapp2.adapter.FacultyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private List<Faculty> facultyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FacultyAdapter mAdapter;
    private ListView facultyListView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int [] bannerImages = {R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3};
    CarouselView carouselView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        recyclerView = (RecyclerView) view.findViewById(R.id.faculty_recycler_view);
//
//        mAdapter = new FacultyAdapter(facultyList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);



        facultyListView = (ListView) view.findViewById(R.id.faculty_list_view);
        prepareFacultyData();
        mAdapter = new FacultyAdapter(getContext(), facultyList);
        facultyListView.setAdapter(mAdapter);

        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setPageCount(bannerImages.length);
        carouselView.setImageListener(imageListener);

        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.v("cekklik", "clicked "+position);
            }
        });

        return view;

    }


    private String loadJSONFromAssets(){
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("faculty.json");
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

    private void prepareFacultyData() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAssets());
            JSONArray jsonArray = obj.getJSONArray("faculties");
            Faculty faculty;
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.v("cekdetail", jsonObject.getString("faculty"));
                String faculty_value = jsonObject.getString("faculty");
                String url_value = jsonObject.getString("url");
                String description_value = jsonObject.getString("description");

                faculty = new Faculty(faculty_value, url_value, description_value);
                facultyList.add(faculty);
            }



        }catch (JSONException e){
            e.printStackTrace();
        }
//        Faculty faculty = new Faculty("Fakultas Hukum", "fh.ub.ac.id");
//        facultyList.add(faculty);
//
//        faculty = new Faculty("Fakultas Hukum", "fh.ub.ac.id");
//        facultyList.add(faculty);
//
//        faculty = new Faculty("Fakultas Ekonomi & Bisnis", "feb.ub.ac.id");
//        facultyList.add(faculty);
//
//        faculty = new Faculty("Fakultas Ilmu Administrasi", "fia.ub.ac.id");
//        facultyList.add(faculty);
//
//        faculty = new Faculty("Fakultas Hukum", "fh.ub.ac.id");
//        facultyList.add(faculty);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Home");
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(bannerImages[position]);
        }
    };

}
