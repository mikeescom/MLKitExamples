package com.mikeescom.mlkitexamples.smartReply;

public class ConversationRowItem {
    public static final String ENTRY = "ENTRY";
    public static final String REPLY = "REPLY";
    private String type = ENTRY;
    private String singleChat = "";

    public ConversationRowItem (String singleChat, String type) {
        this.singleChat = singleChat;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSingleChat() {
        return singleChat;
    }

    public void setSingleChat(String singleChat) {
        this.singleChat = singleChat;
    }
}
