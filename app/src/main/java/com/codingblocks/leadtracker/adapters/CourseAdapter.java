package com.codingblocks.leadtracker.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.fragments.CourseInfoFragment;
import com.codingblocks.leadtracker.model.Course;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by nimit on 28/7/17.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<Course> courseList;
    private Activity activity;
    public CourseAdapter(ArrayList<Course> courseList, Activity activity) {
        this.courseList = courseList;
        this.activity = activity;
    }
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseAdapter.ViewHolder holder, int position) {

        final Course course = courseList.get(position);
        holder.courseName.setText(course.getName());
        holder.courseDetail.setText(course.getDetails());

        holder.courseInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to info of the course
                FragmentManager fragmentManager = ((FragmentActivity)activity).getSupportFragmentManager();
                Fragment courseInfoFragment = new CourseInfoFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("selectedCourse", course);
                courseInfoFragment.setArguments(bundle);
                fragmentManager.beginTransaction().addToBackStack("xyz").replace(R.id.content, courseInfoFragment).commit();
            }
        });

        holder.leedToCouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to leeds for that particular course

            }
        });

    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private Button courseInfo, leedToCouse;
        private TextView courseName, courseDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            courseInfo = (Button) itemView.findViewById(R.id.course_info);
            leedToCouse = (Button) itemView.findViewById(R.id.course_leeds);

            courseName = (TextView) itemView.findViewById(R.id.course_name);
            courseDetail = (TextView) itemView.findViewById(R.id.course_details);

        }
    }
}
