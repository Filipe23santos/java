package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private List<String> disciplinas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplina) {
        disciplinas.add(disciplina);
    }

    public Curso(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Curso{" +  "nome=" + nome  + ", disciplinas=" + disciplinas +  "}";
    }
}