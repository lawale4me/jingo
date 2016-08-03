package com.bytecode.jingo.service;

import com.bytecode.jingo.model.Jingoers;
import com.bytecode.jingo.response.LoginResponse;
import com.bytecode.jingo.response.ServiceResponse;
import com.bytecode.jingo.response.Statuses;
import com.bytecode.jingo.util.UserInfo;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Ahmed
 */
@Stateless
public class JingoService
{

    @Inject
    private JingoRepository jingoRepo;

   

    private static final Logger LOGGER = Logger.getLogger(JingoService.class.getName());

    

    private ServiceResponse validateUser(UserInfo user)
    {
        ServiceResponse response = new ServiceResponse(ServiceResponse.ERROR);
        if (StringUtils.isBlank(user.getUserName()))
        {
            response.setDescription("User name is required");
            return response;
        }
        if (StringUtils.isBlank(user.getFirstName()))
        {
            response.setDescription("First name is required");
            return response;
        }
        if (StringUtils.isBlank(user.getLastName()))
        {
            response.setDescription("Last name is required");
            return response;
        }
        if (StringUtils.isBlank(user.getEmailAddress()))
        {
            response.setDescription("Email address is required");
            return response;
        }
        if (StringUtils.isBlank(user.getPhoneNumber()))
        {
            response.setDescription("Phone number is required");
            return response;
        }
        if (StringUtils.isBlank(user.getPasswd()))
        {
            response.setDescription("Password is required");
            return response;
        }
        if (StringUtils.isBlank(user.getChannel()))
        {
            response.setDescription("Channel is required");
            return response;
        }
        if (StringUtils.isBlank(user.getUuid()))
        {
            response.setDescription("UUID is required");
            return response;
        }
        response.setCode(ServiceResponse.SUCCESS);
        return response;
    }
    

    public ServiceResponse registerUser(UserInfo userInfo) {
        
        ServiceResponse response = new ServiceResponse(ServiceResponse.ERROR);
        ServiceResponse validationResponse = validateUser(userInfo);

        if (validationResponse.getCode() != ServiceResponse.SUCCESS)
        {
            response.setDescription(validationResponse.getDescription());
            return response;
        }
        
        if (jingoRepo.findUser(userInfo.getUserName()) != null)
        {
            response.setDescription("User Already Exists");
            return response;
        }
       Jingoers user = new Jingoers();
        user.setEmailAddress(userInfo.getEmailAddress());
        user.setFirstName(userInfo.getFirstName());
        user.setLastName(userInfo.getLastName());
        user.setPhoneNumber(userInfo.getPhoneNumber());
        user.setUserName(userInfo.getUserName());
        user.setCreationDate(new Date());
        user.setPasswd(userInfo.getPasswd());
        user.setChannel(userInfo.getChannel());
        user.setUuid(userInfo.getUuid());
        user.setAuthCode(String.valueOf(new SecureRandom().nextInt()));
        user.setStatus(Statuses.NEW);
        jingoRepo.update(user); 
        
        response.setCode(ServiceResponse.SUCCESS);
        response.setDescription(ServiceResponse.REGISTRATION_SUCCESSFUL);

        return response;
    }

    public LoginResponse login(String userID, String passwd) {
       LoginResponse response = new LoginResponse(ServiceResponse.ERROR);
       
        Jingoers user = jingoRepo.findUser(userID);
        if (user == null)
        {
            response.setDescription("User Does Not Exists");
            return response;
        }
        
        
        if(!user.getPasswd().equalsIgnoreCase(passwd)){
            response.setDescription("Invalid Username/Password");
            return response;
        }
        
        if(user.getStatus()!=Statuses.ACTIVE){
            response.setDescription("User is not Active");
            return response;
        }
        
        response.setCode(ServiceResponse.SUCCESS);
        response.setDescription(ServiceResponse.REGISTRATION_SUCCESSFUL);

        return response; 
    }

    public LoginResponse confirmReg(String userID, String otp) {
        LoginResponse response = new LoginResponse(ServiceResponse.ERROR);
       
        Jingoers user = jingoRepo.findUser(userID);
        if (user == null)
        {
            response.setDescription("User Does Not Exists");
            return response;
        }
        
        if(user.getStatus()==Statuses.ACTIVE){
            response.setDescription("User is Already Active");
            return response;
        }
        
        if(!user.getAuthCode().equalsIgnoreCase(otp)){
            response.setDescription("Authorization is Invalid");
            return response;
        }
        
        user.setStatus(Statuses.ACTIVE);
        
        jingoRepo.update(user);
        response.setCode(ServiceResponse.SUCCESS);
        response.setDescription(ServiceResponse.REGISTRATION_SUCCESSFUL);

        return response; 
    }

}
