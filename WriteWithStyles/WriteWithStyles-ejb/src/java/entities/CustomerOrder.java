/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 101042618
 */
@Entity
@Table(name = "CUSTOMERORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
    @NamedQuery(name = "CustomerOrder.findByOrderid", query = "SELECT c FROM CustomerOrder c WHERE c.orderid = :orderid"),
    @NamedQuery(name = "CustomerOrder.findByFirstname", query = "SELECT c FROM CustomerOrder c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "CustomerOrder.findByLastname", query = "SELECT c FROM CustomerOrder c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "CustomerOrder.findByEmail", query = "SELECT c FROM CustomerOrder c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerOrder.findByMobile", query = "SELECT c FROM CustomerOrder c WHERE c.mobile = :mobile"),
    @NamedQuery(name = "CustomerOrder.findByDeliveryaddress", query = "SELECT c FROM CustomerOrder c WHERE c.deliveryaddress = :deliveryaddress"),
    @NamedQuery(name = "CustomerOrder.findBySuburb", query = "SELECT c FROM CustomerOrder c WHERE c.suburb = :suburb"),
    @NamedQuery(name = "CustomerOrder.findByPostcode", query = "SELECT c FROM CustomerOrder c WHERE c.postcode = :postcode"),
    @NamedQuery(name = "CustomerOrder.findByState", query = "SELECT c FROM CustomerOrder c WHERE c.state = :state"),
    @NamedQuery(name = "CustomerOrder.findByCreditcardno", query = "SELECT c FROM CustomerOrder c WHERE c.creditcardno = :creditcardno"),
    @NamedQuery(name = "CustomerOrder.findByUserid", query = "SELECT c FROM CustomerOrder c WHERE c.userid = :userid")})
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
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
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 50)
    @Column(name = "DELIVERYADDRESS")
    private String deliveryaddress;
    @Size(max = 50)
    @Column(name = "SUBURB")
    private String suburb;
    @Size(max = 10)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 30)
    @Column(name = "STATE")
    private String state;
    @Size(max = 64)
    @Column(name = "CREDITCARDNO")
    private String creditcardno;
    @Column(name = "USERID")
    private Integer userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerOrder")
    private Collection<CustomerOrderProduct> customerOrderProductCollection;

    public CustomerOrder() {
    }

    public CustomerOrder(String firstname, String lastname, String email, String mobile, String deliveryaddress, String suburb, String postcode, String state, String creditcardno, Integer userid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.deliveryaddress = deliveryaddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
        this.creditcardno = creditcardno;
        this.userid = userid;
    }

    public CustomerOrder(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
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

    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String creditcardno) {
        this.creditcardno = creditcardno;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<CustomerOrderProduct> getCustomerOrderProductCollection() {
        return customerOrderProductCollection;
    }

    public void setCustomerOrderProductCollection(Collection<CustomerOrderProduct> customerOrderProductCollection) {
        this.customerOrderProductCollection = customerOrderProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerOrder[ orderid=" + orderid + " ]";
    }
    
}
