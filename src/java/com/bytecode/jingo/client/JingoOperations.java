package com.bytecode.jingo.client;


import com.bytecode.jingo.response.LoginResponse;
import com.bytecode.jingo.response.ServiceResponse;
import com.bytecode.jingo.service.JingoService;
import com.bytecode.jingo.util.LoginInfo;
import com.bytecode.jingo.util.UserInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ahmed
 */

@Path("/jingo")
public class JingoOperations
{
    @Inject
    private JingoService service;
    
    private static final Logger LOGGER = Logger.getLogger(JingoOperations.class.getName());
    
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public ServiceResponse register(
            @FormParam("userID") String userID,
            @FormParam("emailAddress") String emailAddress,
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("phoneNumber") String phoneNumber,
            @FormParam("passwd") String passwd,
            @FormParam("uuid") String uuid,
            @FormParam("channel") String channel
    )
    {
        try {
            
            UserInfo user = new UserInfo();
            user.setEmailAddress(emailAddress);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            user.setUserName(userID);
            user.setPasswd(passwd);    
            user.setChannel(channel);
            user.setUuid(uuid);
            return service.registerUser(user);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error registering user: %s",
                    userID), e);
            ServiceResponse response = new ServiceResponse(ServiceResponse.ERROR);
            response.setDescription(ServiceResponse.GENERAL_ERROR_MESSAGE);
            return response;
        }
    }
    
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public LoginResponse login(
            @FormParam("userID") String userID,
            @FormParam("passwd") String passwd,
            @FormParam("uuid") String deviceUUID,
            @FormParam("channel") String channel,
            @FormParam("appVersion") String version
    )
    {
         try
        {
            LoginInfo user = new LoginInfo();            
            user.setUserName(userID);
            user.setPasswd(passwd);    
            user.setChannel(channel);
            user.setUuid(deviceUUID);
            return  service.login(userID, passwd);
        } catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, String.format("Error at login for user: %s", 
                    userID), e);
            LoginResponse response = new LoginResponse(ServiceResponse.ERROR);
            response.setDescription(ServiceResponse.GENERAL_ERROR_MESSAGE);
            return response;
        }
    }
    
    
    @Path("confirmRegistration")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public LoginResponse confirmReg(
            @FormParam("userID") String userID,
            @FormParam("otp") String otp,
            @FormParam("uuid") String deviceUUID,
            @FormParam("channel") String channel,
            @FormParam("appVersion") String version
    )
    {
         try
        {
            LoginInfo user = new LoginInfo();            
            user.setUserName(userID);
            user.setPasswd(otp);    
            user.setChannel(channel);
            user.setUuid(deviceUUID);
            return  service.confirmReg(userID, otp);
        } catch (Exception e)
        {
            LOGGER.log(Level.SEVERE, String.format("Error at confirming reg for user: %s", 
                    userID), e);
            LoginResponse response = new LoginResponse(ServiceResponse.ERROR);
            response.setDescription(ServiceResponse.GENERAL_ERROR_MESSAGE);
            return response;
        }
    }
    
}
