package org.example.models;

public class Professor extends Funcionario {
    private String disciplina;

    public Professor(String nome, String apelido, int idade, String funcao, double salario, String disciplina) {
        super(nome, apelido, idade, funcao, salario); // Call the constructor of the superclass (Funcionario)
        setDisciplina(disciplina);
    }

    // amsousa Overloaded constructor without disciplina parameter
    public Professor(String nome, String apelido, int idade) {
        super(nome, apelido, idade, "Professor", 5000);
        setDisciplina("");
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina.isBlank()) {
            this.disciplina = "Disciplina não especificada";
        } else {
            this.disciplina = disciplina;
        }
    }

    @Override
    public String informacoes() {
        return "Nome: " + nomeCompleto() + " Idade: " + idade + " Disciplina: " + disciplina;
    }

    @Override
    public String toString() {
        return super.toString() + " Disciplina: " + disciplina;
    }
}
