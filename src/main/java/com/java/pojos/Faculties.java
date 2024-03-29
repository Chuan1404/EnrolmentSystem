/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AnChuPC
 */
@Entity
@Table(name = "faculties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculties.findAll", query = "SELECT f FROM Faculties f"),
    @NamedQuery(name = "Faculties.findById", query = "SELECT f FROM Faculties f WHERE f.id = :id"),
    @NamedQuery(name = "Faculties.findByName", query = "SELECT f FROM Faculties f WHERE f.name = :name")})
public class Faculties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "faculty")
    private Set<Majors> majorsSet;
    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "video")
    private String video;
    @NotNull
    @Size(min = 1,max = 100)
    @Column(name = "url")
    private String url;

    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "name")
    @NotNull
    private String name;
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Articles articleId;

    public Faculties() {
    }

    public Faculties(Integer id) {
        this.id = id;
    }

    public Faculties(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Articles getArticleId() {
        return articleId;
    }

    public void setArticleId(Articles articleId) {
        this.articleId = articleId;
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
        if (!(object instanceof Faculties)) {
            return false;
        }
        Faculties other = (Faculties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.pojos.Faculties[ id=" + id + " ]";
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Set<Majors> getMajorsSet() {
        return majorsSet;
    }

    public void setMajorsSet(Set<Majors> majorsSet) {
        this.majorsSet = majorsSet;
    }

}
