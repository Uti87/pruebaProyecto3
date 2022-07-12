package com.example.demo.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/notes")
@CrossOrigin
public class NoteController {
    private final NoteService ns; // Creo atributo "service"

    // pasar el NoteService en el contructor y dejar que Spring gestione la
    // iniección de dependencia
    @Autowired
    public NoteController(NoteService noteService) {
        this.ns = noteService;
    }

    @GetMapping
    public List<Note> readNotes() {
        return ns.getNotes();
    }

    @PostMapping
    public int createNote(@RequestBody Note n) {
        // Grabar una nueva nota -> Logica de negocio
        return ns.newNote(n); // añado nota y devuelvo el ID
    }


    



    @DeleteMapping(value="{id}")
    public String deleteNote(@PathVariable(value = "id") int id) {
        if (ns.deleteNote(id)){
            return "Note deleted succesfully";
        }
        return "Error: the note cannot be deleted";
    }

     


/* 
    
    public ResponseEntity<Note> createNote2(@RequestBody Note n) {
        Note newNote = n;

        // retornamos un ResposeEntity que contiene la "location" del nuevo recurso
        // creado
        // y el json del mismo (body)
        return ResponseEntity
                .created(URI.create(String.format("/note/%s", newNote.getid())))
                .body(newNote);
    }
    */
}
