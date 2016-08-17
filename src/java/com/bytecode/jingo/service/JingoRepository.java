/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.jingo.service;


import com.bytecode.jingo.model.Jingoers;
import com.bytecode.jingo.model.Jingosession;
import com.bytecode.jingo.model.Messages;
import java.util.List;


/**
 *
 * @author ahmed
 */
public interface JingoRepository 
{
    public List<Jingoers> getAllJingoers();
    public void update(Jingoers jingoers);        
    public Jingoers findUser(String userName);
    public void update(Jingosession sess);
    public Jingosession findSession(String sessionID);
    public List<Messages> getMessages(Jingoers userId);
    public void create(Jingosession sess);
    public void update(Messages m);
    
    
    
}
