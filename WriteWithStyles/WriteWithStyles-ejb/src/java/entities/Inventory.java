/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 101042618
 */
@Entity
@Table(name = "INVENTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByInventoryid", query = "SELECT i FROM Inventory i WHERE i.inventoryid = :inventoryid"),
    @NamedQuery(name = "Inventory.findByStockquantity", query = "SELECT i FROM Inventory i WHERE i.stockquantity = :stockquantity"),
    @NamedQuery(name = "Inventory.findByDateadded", query = "SELECT i FROM Inventory i WHERE i.dateadded = :dateadded")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INVENTORYID")
    private Integer inventoryid;
    @Column(name = "STOCKQUANTITY")
    private Integer stockquantity;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
    @OneToOne
    private Product productid;

    public Inventory() {
    }

    public Inventory(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Integer getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Integer getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(Integer stockquantity) {
        this.stockquantity = stockquantity;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryid != null ? inventoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryid == null && other.inventoryid != null) || (this.inventoryid != null && !this.inventoryid.equals(other.inventoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Inventory[ inventoryid=" + inventoryid + " ]";
    }
    
}
