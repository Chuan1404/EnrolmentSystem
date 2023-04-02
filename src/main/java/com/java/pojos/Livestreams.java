/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AnChuPC
 */
@Entity
@Table(name = "livestreams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livestreams.findAll", query = "SELECT l FROM Livestreams l"),
    @NamedQuery(name = "Livestreams.findById", query = "SELECT l FROM Livestreams l WHERE l.id = :id"),
    @NamedQuery(name = "Livestreams.findByTitle", query = "SELECT l FROM Livestreams l WHERE l.title = :title"),
    @NamedQuery(name = "Livestreams.findByStartDate", query = "SELECT l FROM Livestreams l WHERE l.startDate = :startDate"),
    @NamedQuery(name = "Livestreams.findByDuration", query = "SELECT l FROM Livestreams l WHERE l.duration = :duration"),
    @NamedQuery(name = "Livestreams.findByStartQuestionTime", query = "SELECT l FROM Livestreams l WHERE l.startQuestionTime = :startQuestionTime"),
    @NamedQuery(name = "Livestreams.findByQuestionDuration", query = "SELECT l FROM Livestreams l WHERE l.questionDuration = :questionDuration")})
public class Livestreams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "image")
    private String image;
    @Lob
    @Size(max = 65535)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private int duration;
    @Column(name = "start_question_time")
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date startQuestionTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "question_duration")
    private int questionDuration;

    @Transient
    private MultipartFile file;
    public Livestreams() {
    }

    public Livestreams(Integer id) {
        this.id = id;
    }

    public Livestreams(Integer id, String title, Date startDate, int duration, int questionDuration) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.duration = duration;
        this.questionDuration = questionDuration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartQuestionTime() {
        return startQuestionTime;
    }

    public void setStartQuestionTime(Date startQuestionTime) {
        this.startQuestionTime = startQuestionTime;
    }

    public int getQuestionDuration() {
        return questionDuration;
    }

    public void setQuestionDuration(int questionDuration) {
        this.questionDuration = questionDuration;
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
        if (!(object instanceof Livestreams)) {
            return false;
        }
        Livestreams other = (Livestreams) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.pojos.Livestreams[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
