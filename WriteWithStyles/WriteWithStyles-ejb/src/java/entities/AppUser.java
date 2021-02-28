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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "APPUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findByUserid", query = "SELECT a FROM AppUser a WHERE a.userid = :userid"),
    @NamedQuery(name = "AppUser.findByFirstname", query = "SELECT a FROM AppUser a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "AppUser.findByLastname", query = "SELECT a FROM AppUser a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "AppUser.findByEmail", query = "SELECT a FROM AppUser a WHERE a.email = :email"),
    @NamedQuery(name = "AppUser.findByPassword", query = "SELECT a FROM AppUser a WHERE a.password = :password"),
    @NamedQuery(name = "AppUser.findByMobile", query = "SELECT a FROM AppUser a WHERE a.mobile = :mobile"),
    @NamedQuery(name = "AppUser.findByAddress", query = "SELECT a FROM AppUser a WHERE a.address = :address"),
    @NamedQuery(name = "AppUser.findBySuburb", query = "SELECT a FROM AppUser a WHERE a.suburb = :suburb"),
    @NamedQuery(name = "AppUser.findByPostcode", query = "SELECT a FROM AppUser a WHERE a.postcode = :postcode"),
    @NamedQuery(name = "AppUser.findByState", query = "SELECT a FROM AppUser a WHERE a.state = :state")})
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 64)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "SUBURB")
    private String suburb;
    @Size(max = 10)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 30)
    @Column(name = "STATE")
    private String state;
    @JoinTable(name = "USERGROUP", joinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "USERID")}, inverseJoinColumns = {
        @JoinColumn(name = "GROUPID", referencedColumnName = "GROUPID")})
    @ManyToMany
    private Collection<RealmGroup> realmGroupCollection;

    public AppUser() {
    }

    public AppUser(String firstname, String lastname, String email, String password, String mobile, String address, String suburb, String postcode, String state) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    public AppUser(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<RealmGroup> getRealmGroupCollection() {
        return realmGroupCollection;
    }

    public void setRealmGroupCollection(Collection<RealmGroup> realmGroupCollection) {
        this.realmGroupCollection = realmGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AppUser[ userid=" + userid + " ]";
    }
    
}
