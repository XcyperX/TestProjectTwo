package com.spring.TestProject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean some;

    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    private Form form;

    public Question() {
    }

    public Question(Long id) {
        this.id = id;
    }
}
