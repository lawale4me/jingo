/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.jingo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed
 */
@Entity
@Table(name = "jingoers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jingoers.findAll", query = "SELECT j FROM Jingoers j"),
    @NamedQuery(name = "Jingoers.findById", query = "SELECT j FROM Jingoers j WHERE j.id = :id"),
    @NamedQuery(name = "Jingoers.findByEmailAddress", query = "SELECT j FROM Jingoers j WHERE j.emailAddress = :emailAddress"),
    @NamedQuery(name = "Jingoers.findByFirstName", query = "SELECT j FROM Jingoers j WHERE j.firstName = :firstName"),
    @NamedQuery(name = "Jingoers.findByLastName", query = "SELECT j FROM Jingoers j WHERE j.lastName = :lastName"),
    @NamedQuery(name = "Jingoers.findByPhoneNumber", query = "SELECT j FROM Jingoers j WHERE j.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Jingoers.findByUserName", query = "SELECT j FROM Jingoers j WHERE j.userName = :userName"),
    @NamedQuery(name = "Jingoers.findByPasswd", query = "SELECT j FROM Jingoers j WHERE j.passwd = :passwd"),
    @NamedQuery(name = "Jingoers.findByCreationDate", query = "SELECT j FROM Jingoers j WHERE j.creationDate = :creationDate"),
    @NamedQuery(name = "Jingoers.findByStatus", query = "SELECT j FROM Jingoers j WHERE j.status = :status")})
public class Jingoers implements Serializable {

    @OneToMany(mappedBy = "userId")
    private Collection<Jingosession> jingosessionCollection;
    @OneToMany(mappedBy = "fUserId")
    private Collection<Messages> messagesCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Messages> messagesCollection1;

    @Size(max = 45)
    @Column(name = "authCode")
    private String authCode;

    @Size(max = 45)
    @Column(name = "channel")
    private String channel;
    @Size(max = 75)
    @Column(name = "uuid")
    private String uuid;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Size(max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 255)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 255)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Size(max = 255)
    @Column(name = "userName")
    private String userName;
    @Size(max = 255)
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "status")
    private Integer status;

    public Jingoers() {
    }

    public Jingoers(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        if (!(object instanceof Jingoers)) {
            return false;
        }
        Jingoers other = (Jingoers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bytecode.jingo.model.Jingoers[ id=" + id + " ]";
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @XmlTransient
    public Collection<Jingosession> getJingosessionCollection() {
        return jingosessionCollection;
    }

    public void setJingosessionCollection(Collection<Jingosession> jingosessionCollection) {
        this.jingosessionCollection = jingosessionCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection1() {
        return messagesCollection1;
    }

    public void setMessagesCollection1(Collection<Messages> messagesCollection1) {
        this.messagesCollection1 = messagesCollection1;
    }
    
}
