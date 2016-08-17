
package com.bytecode.jingo.response;

/**
 *
 * @author Ahmed
 */
public class ServiceResponse
{

    public static final Integer PENDING = 5;
    public static String REGISTRATION_SUCCESSFUL="Enrolment Successful";
    public static String LOGIN_SUCCESSFUL="Login Successful";
    private int code;
    private String description;
    
    public static final int SUCCESS = 0;
    public static final int ERROR = 10;
        
    public static final String GENERAL_ERROR_MESSAGE = "Request processing error";
    public static final String GENERAL_SUCCESS_MESSAGE = "Operation Successful";
    public static final String ERROR_USER_NOT_FOUND = "User not found";    
    public static final String ERROR_INVALID_DEVICE = "Invalid device";

    public ServiceResponse(int code)
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
}
