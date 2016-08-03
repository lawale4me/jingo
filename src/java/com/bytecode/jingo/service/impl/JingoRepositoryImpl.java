/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.jingo.service.impl;


import com.bytecode.jingo.model.Jingoers;
import com.bytecode.jingo.service.JingoRepository;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ahmed
 */
@Dependent
public class JingoRepositoryImpl implements JingoRepository
{

    @PersistenceContext(unitName = "JingoPU")
    EntityManager manager;

    @Override
    public List<Jingoers> getAllJingoers() {
         return manager.createNamedQuery("Jingoers.findAll", Jingoers.class).                
            getResultList();        
    }

    @Override
    public void update(Jingoers jingoers) {
        manager.merge(jingoers);
    }

    @Override
    public Jingoers findUser(String userName) {
        List<Jingoers> jingoers = manager.createNamedQuery("Jingoers.findByUserName", Jingoers.class).
                setParameter("userName", userName).
                setMaxResults(1).getResultList();
        return jingoers.isEmpty()? null : jingoers.get(0);
    }
    

}
