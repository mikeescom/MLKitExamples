package com.mikeescom.mlkitexamples.smartReply;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mikeescom.mlkitexamples.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ConversationRowItem>{

    private ArrayList<ConversationRowItem> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView myText;
        TextView theirReply;
    }

    public CustomAdapter(ArrayList<ConversationRowItem> data, Context context) {
        super(context, R.layout.conversation_row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConversationRowItem dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.conversation_row_item, parent, false);
            viewHolder.myText = convertView.findViewById(R.id.my_text);
            viewHolder.theirReply = convertView.findViewById(R.id.their_reply);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? android.R.anim.slide_in_left : android.R.anim.slide_out_right);
        result.startAnimation(animation);
        lastPosition = position;

        if (dataModel.getType().endsWith(ConversationRowItem.ENTRY)) {
            viewHolder.myText.setText(dataModel.getSingleChat());
            viewHolder.theirReply.setVisibility(View.GONE);
        } else {
            viewHolder.theirReply.setText(dataModel.getSingleChat());
            viewHolder.myText.setVisibility(View.GONE);
        }

        return convertView;
    }
}
