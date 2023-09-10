package org.example.models;

import org.example.interfaces.Estudante;

public class Aluno extends Pessoa implements Estudante {
    // amsousa Static attribute to store the maximum allowed age for an Aluno
    private static final int MAXIMUM_ALLOWED_AGE = 25;
    private Curso curso;
    private int matricula;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            this.curso = new Curso("Curso não especificado");
        } else {
            this.curso = curso;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Aluno(String nome, String apelido, int idade, Curso curso, int matricula) {
        super(nome, apelido, idade); // Call the constructor of the superclass (Pessoa)
        setCurso(curso);
        setMatricula(matricula);
    }


    // amsousa Overloaded constructor without curso and matricula parameters
    public Aluno(String nome, String apelido, int idade) {
        super(nome, apelido, idade);
        setCurso(null);
        setMatricula(0);
    }

    @Override
    public String informacoes() {
        return "Nome: " + nomeCompleto() + " Idade: " + idade + " Curso: " + curso.getNome() + " Matrícula: " + matricula;
    }

    @Override
    public String toString() {
        return super.toString() + " Curso: " + curso.getNome() + " Matrícula: " + matricula;
    }

    @Override
    public double calcularMediaNotas() {
        // Implement your logic to calculate the average grades here
        // For example:
        // return (nota1 + nota2 + nota3) / 3;
        // For this example, I assume there are three grades: nota1, nota2, and nota3.
        // Modify it according to your actual implementation.
        return 0.0;
    }

    // amsousa Static method to get the maximum allowed age for an Aluno
    public static int getMaximumAllowedAge() {
        return MAXIMUM_ALLOWED_AGE;
    }
}
