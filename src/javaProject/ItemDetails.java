/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "itemDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemDetails.findAll", query = "SELECT i FROM ItemDetails i")
    , @NamedQuery(name = "ItemDetails.findByItemCode", query = "SELECT i FROM ItemDetails i WHERE i.itemCode = :itemCode")
    , @NamedQuery(name = "ItemDetails.findByName", query = "SELECT i FROM ItemDetails i WHERE i.name = :name")
    , @NamedQuery(name = "ItemDetails.findByPrice", query = "SELECT i FROM ItemDetails i WHERE i.price = :price")
    , @NamedQuery(name = "ItemDetails.findByQuantity", query = "SELECT i FROM ItemDetails i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "ItemDetails.findByCategory", query = "SELECT i FROM ItemDetails i WHERE i.category = :category")
    , @NamedQuery(name = "ItemDetails.findByImage", query = "SELECT i FROM ItemDetails i WHERE i.image = :image")})
public class ItemDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "itemCode")
    private Integer itemCode;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public ItemDetails() {
    }

    public ItemDetails(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public ItemDetails(Integer itemCode, String name, int price, int quantity, String category, String image) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.image = image;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        Integer oldItemCode = this.itemCode;
        this.itemCode = itemCode;
        changeSupport.firePropertyChange("itemCode", oldItemCode, itemCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        int oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        String oldCategory = this.category;
        this.category = category;
        changeSupport.firePropertyChange("category", oldCategory, category);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        String oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDetails)) {
            return false;
        }
        ItemDetails other = (ItemDetails) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaProject.ItemDetails[ itemCode=" + itemCode + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
