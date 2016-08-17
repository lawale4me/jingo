/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.jingo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed
 */
@Entity
@Table(name = "jingosession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jingosession.findAll", query = "SELECT j FROM Jingosession j"),
    @NamedQuery(name = "Jingosession.findById", query = "SELECT j FROM Jingosession j WHERE j.id = :id"),
    @NamedQuery(name = "Jingosession.findBySessionID", query = "SELECT j FROM Jingosession j WHERE j.sessionID = :sessionID"),
    @NamedQuery(name = "Jingosession.findBySessionDate", query = "SELECT j FROM Jingosession j WHERE j.sessionDate = :sessionDate"),
    @NamedQuery(name = "Jingosession.findByStatus", query = "SELECT j FROM Jingosession j WHERE j.status = :status")})
public class Jingosession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)    
    @Column(name = "id")
    private Integer id;
    @Size(max = 65)
    @Column(name = "sessionID")
    private String sessionID;
    @Column(name = "sessionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionDate;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private Jingoers userId;

    public Jingosession() {
    }

    public Jingosession(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Jingoers getUserId() {
        return userId;
    }

    public void setUserId(Jingoers userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jingosession)) {
            return false;
        }
        Jingosession other = (Jingosession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bytecode.jingo.model.Jingosession[ id=" + id + " ]";
    }
    
}
