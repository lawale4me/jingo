
package com.bytecode.jingo.response;

/**
 *
 * @author Ahmed
 */
public class MessageResponse
{

    public static final Integer PENDING = 5;    
    public static String ACTIVE="1";
    public static String INACTIVE="0";
    private int code;
    private String description, sessionID;
    
    public static final int SUCCESS = 0;
    public static final int ERROR = 10;
        
    public static final String MESSAGE_SENT="Message Sent";
    public static final String GENERAL_ERROR_MESSAGE = "Request processing error";
    public static final String GENERAL_SUCCESS_MESSAGE = "Operation Successful";
    public static final String ERROR_USER_NOT_FOUND = "User not found";    
    public static final String ERROR_INVALID_DEVICE = "Invalid device";

    public MessageResponse(int code)
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

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    
    
}
