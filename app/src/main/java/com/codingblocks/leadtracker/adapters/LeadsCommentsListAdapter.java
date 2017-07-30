package com.codingblocks.leadtracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.model.Comment;

import java.util.List;

/**
 * Created by piyush on 30/7/17.
 */

public class LeadsCommentsListAdapter extends
        RecyclerView.Adapter<LeadsCommentsListAdapter.CommentsViewholder>{

    List<Comment> listOfCommentOnALead;

    public LeadsCommentsListAdapter(List<Comment> listOfCommentOnALead){
        this.listOfCommentOnALead=listOfCommentOnALead;
    }
    @Override
    public CommentsViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lead_list_comment_row_item,parent,false);

        return new LeadsCommentsListAdapter.CommentsViewholder(view);
    }

    @Override
    public void onBindViewHolder(CommentsViewholder holder, int position) {
        holder.studentName.setText(listOfCommentOnALead.get(position).getStudentName());
        holder.createdAt.setText(listOfCommentOnALead.get(position).getCreatedAt());
        holder.updatedAt.setText(listOfCommentOnALead.get(position).getUpdatedAt());
        holder.createdBy.setText(listOfCommentOnALead.get(position).getCreatersName());
        holder.studentCollege.setText(listOfCommentOnALead.get(position).getStudentCollege());
    }

    @Override
    public int getItemCount() {
        return listOfCommentOnALead.size();
    }

    public static class CommentsViewholder extends RecyclerView.ViewHolder{

        public TextView createdAt,updatedAt,createdBy,studentName,studentCollege;
        public CommentsViewholder(View itemView) {
            super(itemView);
            createdAt=(TextView) itemView.findViewById(R.id.lead_comment_created_at);
            updatedAt=(TextView) itemView.findViewById(R.id.lead_comment_updated_at);
            createdBy=(TextView) itemView.findViewById(R.id.lead_comment_created_by);
            studentName=(TextView) itemView.findViewById(R.id.student_name);
            studentCollege=(TextView) itemView.findViewById(R.id.student_college);
        }
    }
}
