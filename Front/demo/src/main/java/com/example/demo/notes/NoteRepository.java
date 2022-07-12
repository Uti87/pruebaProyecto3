package com.example.demo.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository < Note, Integer > {
    Note findByTitle(String title); /* A más a más*/
}



