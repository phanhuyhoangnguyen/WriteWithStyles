/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 101042618
 */
@Embeddable
public class UserGroupPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUPID")
    private int groupid;

    public UserGroupPK() {
    }

    public UserGroupPK(int userid, int groupid) {
        this.userid = userid;
        this.groupid = groupid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) groupid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroupPK)) {
            return false;
        }
        UserGroupPK other = (UserGroupPK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.groupid != other.groupid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroupPK[ userid=" + userid + ", groupid=" + groupid + " ]";
    }
    
}
