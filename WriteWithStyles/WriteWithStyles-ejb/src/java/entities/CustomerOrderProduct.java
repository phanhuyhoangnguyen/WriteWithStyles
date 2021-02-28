/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 101042618
 */
@Entity
@Table(name = "CUSTOMERORDERPRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrderProduct.findAll", query = "SELECT c FROM CustomerOrderProduct c"),
    @NamedQuery(name = "CustomerOrderProduct.findByOrderid", query = "SELECT c FROM CustomerOrderProduct c WHERE c.customerOrderProductPK.orderid = :orderid"),
    @NamedQuery(name = "CustomerOrderProduct.findByProductid", query = "SELECT c FROM CustomerOrderProduct c WHERE c.customerOrderProductPK.productid = :productid"),
    @NamedQuery(name = "CustomerOrderProduct.findByOrderedquantity", query = "SELECT c FROM CustomerOrderProduct c WHERE c.orderedquantity = :orderedquantity"),
    @NamedQuery(name = "CustomerOrderProduct.findByProductprice", query = "SELECT c FROM CustomerOrderProduct c WHERE c.productprice = :productprice")})
public class CustomerOrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerOrderProductPK customerOrderProductPK;
    @Column(name = "ORDEREDQUANTITY")
    private Integer orderedquantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODUCTPRICE")
    private Float productprice;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerOrder customerOrder;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public CustomerOrderProduct() {
    }

    public CustomerOrderProduct(CustomerOrderProductPK customerOrderProductPK, Integer orderedquantity, Float productprice, CustomerOrder customerOrder, Product product) {
        this.customerOrderProductPK = customerOrderProductPK;
        this.orderedquantity = orderedquantity;
        this.productprice = productprice;
        this.customerOrder = customerOrder;
        this.product = product;
    }

    public CustomerOrderProduct(CustomerOrderProductPK customerOrderProductPK) {
        this.customerOrderProductPK = customerOrderProductPK;
    }

    public CustomerOrderProduct(int orderid, int productid) {
        this.customerOrderProductPK = new CustomerOrderProductPK(orderid, productid);
    }

    public CustomerOrderProductPK getCustomerOrderProductPK() {
        return customerOrderProductPK;
    }

    public void setCustomerOrderProductPK(CustomerOrderProductPK customerOrderProductPK) {
        this.customerOrderProductPK = customerOrderProductPK;
    }

    public Integer getOrderedquantity() {
        return orderedquantity;
    }

    public void setOrderedquantity(Integer orderedquantity) {
        this.orderedquantity = orderedquantity;
    }

    public Float getProductprice() {
        return productprice;
    }

    public void setProductprice(Float productprice) {
        this.productprice = productprice;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerOrderProductPK != null ? customerOrderProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrderProduct)) {
            return false;
        }
        CustomerOrderProduct other = (CustomerOrderProduct) object;
        if ((this.customerOrderProductPK == null && other.customerOrderProductPK != null) || (this.customerOrderProductPK != null && !this.customerOrderProductPK.equals(other.customerOrderProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerOrderProduct[ customerOrderProductPK=" + customerOrderProductPK + " ]";
    }
    
}
