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
import javax.persistence.Lob;
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
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByMsgId", query = "SELECT m FROM Messages m WHERE m.msgId = :msgId"),
    @NamedQuery(name = "Messages.findByUserId", query = "SELECT m FROM Messages m WHERE m.userId = :userId"),
    @NamedQuery(name = "Messages.findByFUserId", query = "SELECT m FROM Messages m WHERE m.fUserId = :fuserId"),
    @NamedQuery(name = "Messages.findByMsgDate", query = "SELECT m FROM Messages m WHERE m.msgDate = :msgDate"),
    @NamedQuery(name = "Messages.findByReadStatus", query = "SELECT m FROM Messages m WHERE m.readStatus = :readStatus")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "msgId")
    private Integer msgId;
    @Lob
    @Size(max = 65535)
    @Column(name = "message")
    private String message;
    @Column(name = "msgDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date msgDate;
    @Column(name = "readStatus")
    private Integer readStatus;
    @JoinColumn(name = "fUserId", referencedColumnName = "id")
    @ManyToOne
    private Jingoers fUserId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private Jingoers userId;

    public Messages() {
    }

    public Messages(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public Jingoers getFUserId() {
        return fUserId;
    }

    public void setFUserId(Jingoers fUserId) {
        this.fUserId = fUserId;
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
        hash += (msgId != null ? msgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.msgId == null && other.msgId != null) || (this.msgId != null && !this.msgId.equals(other.msgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bytecode.jingo.model.Messages[ msgId=" + msgId + " ]";
    }
    
}
