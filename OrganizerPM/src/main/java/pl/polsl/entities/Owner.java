/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Paulina Maslowska
 */
@Entity
@Table(name = "OWNERS")
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
    @NamedQuery(name = "Owner.findById", query = "SELECT o FROM Owner o WHERE o.id = :id"),
    @NamedQuery(name = "Owner.findByName", query = "SELECT o FROM Owner o WHERE o.name = :name")})
/**
 * class for Owner of the events
 */
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "owner")
    private Collection<Event> eventCollection;

    public Owner() {
    }

    public Owner(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
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
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.model.Owner[ id=" + id + " ]";
    }
    
}
