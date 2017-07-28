package com.codingblocks.leadtracker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.model.Course;


public class CourseInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public CourseInfoFragment() {
        // Required empty public constructor
    }

    public static CourseInfoFragment newInstance(String param1, String param2) {
        CourseInfoFragment fragment = new CourseInfoFragment();
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
    private TextView courseName, courseStartDate, courseEndDate, centerAndInstructor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_course_info, container, false);
        courseName = (TextView) rootView.findViewById(R.id.course_name);
        courseStartDate = (TextView) rootView.findViewById(R.id.course_start_date);
        courseEndDate = (TextView) rootView.findViewById(R.id.course_end_date);
        centerAndInstructor = (TextView) rootView.findViewById(R.id.center_instructor);

        if(getArguments()!=null) {
            Bundle bundle = getArguments();
            Course course = bundle.getParcelable("selectedCourse");
            Log.e("ds", course.getName());
            addCourseInfo(course);
        }


        return rootView;
    }
    private void addCourseInfo(Course course) {
        courseName.setText(course.getName());
        courseStartDate.setText(course.getStartDate());
        courseEndDate.setText(course.getEndDate());
        course.getCenterToInstructor();
    }
}
