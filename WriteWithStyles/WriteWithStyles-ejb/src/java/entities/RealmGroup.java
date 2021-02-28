/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 101042618
 */
@Entity
@Table(name = "REALMGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RealmGroup.findAll", query = "SELECT r FROM RealmGroup r"),
    @NamedQuery(name = "RealmGroup.findByGroupid", query = "SELECT r FROM RealmGroup r WHERE r.groupid = :groupid"),
    @NamedQuery(name = "RealmGroup.findByGroupname", query = "SELECT r FROM RealmGroup r WHERE r.groupname = :groupname")})
public class RealmGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GROUPID")
    private Integer groupid;
    @Size(max = 75)
    @Column(name = "GROUPNAME")
    private String groupname;
    @ManyToMany(mappedBy = "realmGroupCollection")
    private Collection<AppUser> appUserCollection;

    public RealmGroup() {
    }

    public RealmGroup(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @XmlTransient
    public Collection<AppUser> getAppUserCollection() {
        return appUserCollection;
    }

    public void setAppUserCollection(Collection<AppUser> appUserCollection) {
        this.appUserCollection = appUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RealmGroup)) {
            return false;
        }
        RealmGroup other = (RealmGroup) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RealmGroup[ groupid=" + groupid + " ]";
    }
    
}
