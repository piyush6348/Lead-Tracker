package com.codingblocks.leadtracker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.adapters.CourseAdapter;
import com.codingblocks.leadtracker.model.Course;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CourseListFragment() {
        // Required empty public constructor
    }

    public static CourseListFragment newInstance(String param1, String param2) {
        CourseListFragment fragment = new CourseListFragment();
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
    private ArrayList<Course> courseList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_course_list, container, false);

        RecyclerView courseRecyclerView = (RecyclerView) rootView.findViewById(R.id.course_recycler_view);
        courseRecyclerView.setHasFixedSize(true);
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        courseList = new ArrayList<>();
        addCourseData();
        courseRecyclerView.setAdapter(new CourseAdapter(courseList,getActivity()));

        return rootView;
    }

    void addCourseData() {
        HashMap<String, String> centerToInstructor = new HashMap<>();

        // Dummy course available at centers with instructor info
        centerToInstructor.put("Pitampura", "Arnav Bhaiya");
        centerToInstructor.put("Dwarka", "Arnav Bhaiya");
        centerToInstructor.put("Gurgaon", "Arnav Bhaiya");


        for (int i = 0; i < 5; i++) {
            Course course = new Course("Course " + i,
                    "Android Course", centerToInstructor, "15-08-2017", "20-10-2017");
            courseList.add(course);
        }
    }

}
