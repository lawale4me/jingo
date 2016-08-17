
package com.bytecode.jingo.response;

import com.bytecode.jingo.util.MessageInfo;
import com.bytecode.jingo.util.UserInfo;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public class JingoResponse
{

    public static final Integer PENDING = 5;    
    private int code;
    private String description;
    private List<MessageInfo> messages;
    private UserInfo userInfo;
    
    public static final int SUCCESS = 0;
    public static final int ERROR = 10;
        
    public static final String GENERAL_ERROR_MESSAGE = "Request processing error";
    public static final String GENERAL_SUCCESS_MESSAGE = "Operation Successful";        

    public JingoResponse(int code)
    {
        this.code = code;        
    }
    
    

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public List<MessageInfo> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageInfo> messages) {
        this.messages = messages;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    
    
    
}
