package com.example.demo.notes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//definirlo como componente de tipo @Service
@Service
public class NoteService {

    private final NoteRepository noterepo;

    @Autowired
    public NoteService(NoteRepository nr) {
        this.noterepo = nr;
    }

    public List<Note> getNotes(){
        return this.noterepo.findAll();
    }


    public int newNote(Note n) {
        n = this.noterepo.saveAndFlush(n);
        return n.getid();
    }

    public boolean deleteNote(int id) {
        boolean res = false;
        try {
            this.noterepo.deleteById(id);
            res = true;
        } catch (Exception e){
            
        }
        return res;

    }
}
