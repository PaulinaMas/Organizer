/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Paulina Maslowska
 */
@Entity
@Table(name = "EVENTS")
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e WHERE e.owner.id = :id"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name AND e.owner.id = :id"),
    @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id AND e.owner.id = :ide" ),
    @NamedQuery(name = "Event.findByDate", query = "SELECT e FROM Event e WHERE e.date = :date"),
    @NamedQuery(name = "Event.findByTime", query = "SELECT e FROM Event e WHERE e.time = :time"),
    @NamedQuery(name = "Event.findByNote", query = "SELECT e FROM Event e WHERE e.note = :note"),
    @NamedQuery(name = "Event.findByPriority", query = "SELECT e FROM Event e WHERE e.priority = :priority"),
    @NamedQuery(name = "Event.deleteByName", query = "DELETE FROM Event e WHERE e.name= :name")})
/**
 * CLass for Event
 */
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "DATE")
    private String date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "NOTE")
    private String note;
    @Basic(optional = false)
    @Column(name = "PRIORITY")
    private String priority;
    @JoinColumn(name = "OWNER", referencedColumnName = "ID")
    @ManyToOne
    private Owner owner;

    public Event() {
    }

    public Event(Integer id) {
        this.id = id;
    }

    public Event(Integer id, String priority) {
        this.id = id;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.model.Event[ id=" + id + " ]";
    }
    
}
