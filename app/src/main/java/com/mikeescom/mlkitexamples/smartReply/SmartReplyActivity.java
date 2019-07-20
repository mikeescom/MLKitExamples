package com.mikeescom.mlkitexamples.smartReply;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseSmartReply;
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage;
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion;
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestionResult;
import com.mikeescom.mlkitexamples.R;

import java.util.ArrayList;
import java.util.List;

public class SmartReplyActivity extends AppCompatActivity {

    private List<FirebaseTextMessage> mMessagesList = new ArrayList<>();
    private ListView mConversation;
    private EditText mEntryText;
    private Button mSendBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_reply);
        initViews();
        initListeners();
        initA
    }

    private void initViews () {
        mConversation = findViewById(R.id.conversation_lv);
        mEntryText = findViewById(R.id.entry_text);
        mSendBt = findViewById(R.id.send_bt);
    }

    private void initListeners () {
        mSendBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void updateAdapter ()

    private void updateListView (List<ConversationRowItem> chatItems) {
        mConversation.setAdapter(new CustomAdapter());
    }

    private void sendMessage () {
        mMessagesList.add(FirebaseTextMessage.createForLocalUser(
                "heading out now", System.currentTimeMillis()));
        mMessagesList.add(FirebaseTextMessage.createForRemoteUser(
                "Are you coming back soon?", System.currentTimeMillis(), "1"));
        getMessagesReplies(mMessagesList);
    }

    private void getMessagesReplies (List<FirebaseTextMessage> conversation) {
        FirebaseSmartReply smartReply = FirebaseNaturalLanguage.getInstance().getSmartReply();
        smartReply.suggestReplies(conversation)
                .addOnSuccessListener(new OnSuccessListener<SmartReplySuggestionResult>() {
                    @Override
                    public void onSuccess(SmartReplySuggestionResult result) {
                        if (result.getStatus() == SmartReplySuggestionResult.STATUS_NOT_SUPPORTED_LANGUAGE) {
                            Toast.makeText(getApplicationContext(), "Language not supported", Toast.LENGTH_LONG).show();
                        } else if (result.getStatus() == SmartReplySuggestionResult.STATUS_SUCCESS) {
                            for (SmartReplySuggestion suggestion : result.getSuggestions()) {
                                String replyText = suggestion.getText();
                                Toast.makeText(getApplicationContext(), replyText, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Task failed with an exception
                        // ...
                    }
                });
    }
}
