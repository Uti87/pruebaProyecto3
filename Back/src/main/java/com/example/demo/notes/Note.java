package com.example.demo.notes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")  //si no lo pongo -> JPA accederá a la tabla de default = "note"
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    private String title;
    private String message;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //SPRING QUIERE UN CONSTRUCTOR VACÍO (de default!!)
    public Note(){
    }

    public Note(String title, String message, String category) {
        this.title = title;
        this.message = message;
        this.category = category;
    }
    
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String gettitle() {
        return title;
    }
    public void settitle(String title) {
        this.title = title;
    }
    public String getmessage() {
        return message;
    }
    public void setmessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "Note [id=" + id + ", message=" + message + ", title=" + title + ", category=" + category +"]";
    }

}
