package com.codingblocks.leadtracker.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.adapters.LeadsCommentsListAdapter;
import com.codingblocks.leadtracker.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadsCommentsChildFragment extends Fragment {

    private RecyclerView leadsCommentsList;
    private List<Comment> commentList;
    private LeadsCommentsListAdapter leadsCommentsListAdapter;
    public LeadsCommentsChildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView= inflater.inflate(R.layout.fragment_leads_comments_child, container, false);


        commentList=new ArrayList<>();

        Comment comment=new Comment("Piyush Gupta","MAIT","Arnav Bhaiya","28/07/2017","28/08/2017");

        commentList.add(comment);
        /*
        commentList.add(comment);
        commentList.add(comment);
        commentList.add(comment);
        commentList.add(comment);*/
        leadsCommentsListAdapter = new LeadsCommentsListAdapter(commentList);

        leadsCommentsList=(RecyclerView) mainView.findViewById(R.id.leads_comments_list);
        leadsCommentsList.setHasFixedSize(true);
        leadsCommentsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        leadsCommentsList.setAdapter(leadsCommentsListAdapter);
        return mainView;
    }

}
