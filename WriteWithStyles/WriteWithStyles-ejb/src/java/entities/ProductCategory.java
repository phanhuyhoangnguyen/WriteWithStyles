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
@Table(name = "PRODUCTCATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p"),
    @NamedQuery(name = "ProductCategory.findByProductcategoryid", query = "SELECT p FROM ProductCategory p WHERE p.productcategoryid = :productcategoryid"),
    @NamedQuery(name = "ProductCategory.findByName", query = "SELECT p FROM ProductCategory p WHERE p.name = :name")})
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTCATEGORYID")
    private Integer productcategoryid;
    @Size(max = 75)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "productcategoryid")
    private Collection<Product> productCollection;

    public ProductCategory() {
    }

    public ProductCategory(Integer productcategoryid) {
        this.productcategoryid = productcategoryid;
    }

    public Integer getProductcategoryid() {
        return productcategoryid;
    }

    public void setProductcategoryid(Integer productcategoryid) {
        this.productcategoryid = productcategoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productcategoryid != null ? productcategoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategory)) {
            return false;
        }
        ProductCategory other = (ProductCategory) object;
        if ((this.productcategoryid == null && other.productcategoryid != null) || (this.productcategoryid != null && !this.productcategoryid.equals(other.productcategoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductCategory[ productcategoryid=" + productcategoryid + " ]";
    }
    
}
