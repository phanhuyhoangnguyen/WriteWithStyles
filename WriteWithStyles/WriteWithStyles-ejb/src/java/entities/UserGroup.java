/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 101042618
 */
@Entity
@Table(name = "USERGROUP")
@XmlRootElement
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserGroupPK userGroupPK;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppUser user;
    @JoinColumn(name = "GROUPID", referencedColumnName = "GROUPID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RealmGroup group;

    public UserGroup() {
    }

    public UserGroup(UserGroupPK userGroupPK, AppUser user, RealmGroup group) {
        this.userGroupPK = userGroupPK;
        this.user = user;
        this.group = group;
    }

    public UserGroupPK getUserGroupPK() {
        return userGroupPK;
    }

    public void setUserGroupPK(UserGroupPK userGroupPK) {
        this.userGroupPK = userGroupPK;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public RealmGroup getGroup() {
        return group;
    }

    public void setGroup(RealmGroup group) {
        this.group = group;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupPK != null ? userGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroup)) {
            return false;
        }
        UserGroup other = (UserGroup) object;
        if ((this.userGroupPK == null && other.userGroupPK != null) || (this.userGroupPK != null && !this.userGroupPK.equals(other.userGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroup[ customerOrderProductPK=" + userGroupPK + " ]";
    }
    
}