/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jackc
 */
@Entity
@Table(name = "homepage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Homepage.findAll", query = "SELECT h FROM Homepage h"),
    @NamedQuery(name = "Homepage.findById", query = "SELECT h FROM Homepage h WHERE h.id = :id"),
    @NamedQuery(name = "Homepage.findByVideo", query = "SELECT h FROM Homepage h WHERE h.video = :video")})
public class Homepage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "video")
    private String video;
    @JoinColumn(name = "banner_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Banners bannerId;

    public Homepage() {
    }

    public Homepage(Integer id) {
        this.id = id;
    }

    public Homepage(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Banners getBannerId() {
        return bannerId;
    }

    public void setBannerId(Banners bannerId) {
        this.bannerId = bannerId;
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
        if (!(object instanceof Homepage)) {
            return false;
        }
        Homepage other = (Homepage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.pojos.Homepage[ id=" + id + " ]";
    }
    
}