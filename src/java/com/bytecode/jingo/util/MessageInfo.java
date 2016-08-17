/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.jingo.util;

import com.bytecode.jingo.model.Messages;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class MessageInfo {

    
    private String toUserName, message, fromUserName, readStatus;
    private Date msgDate;

    public List<MessageInfo> create(List<Messages> msgs, String userName) {
        List<MessageInfo> messages = new ArrayList<>();
        for (Messages m : msgs) 
        {
            MessageInfo mi = new MessageInfo();
            if(m.getUserId().getUserName().equalsIgnoreCase(userName)){
            mi.toUserName = m.getUserId().getUserName();            
            }
            mi.fromUserName = m.getFUserId().getUserName();
            mi.message = m.getMessage();
            mi.msgDate = m.getMsgDate();
            mi.readStatus = m.getReadStatus().toString();
            
            messages.add(mi);
        }
        return messages;
    }
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    
    
    
    
}
