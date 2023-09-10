package org.example.models;

public class Administrativo extends Funcionario {
    private String setor;

    public Administrativo(String nome, String apelido, int idade, String funcao, double salario, String setor) {
        super(nome, apelido, idade, funcao, salario); // Call the constructor of the superclass (Funcionario)
        setSetor(setor);
    }

    // amsousa Overloaded constructor without setor parameter
    public Administrativo(String nome, String apelido, int idade) {
        super(nome, apelido, idade, "Administrativo", 3500);
        setSetor("");
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        if (setor.isBlank()) {
            this.setor = "Setor não especificado";
        } else {
            this.setor = setor;
        }
    }

    @Override
    public String informacoes() {
        return "Nome: " + nomeCompleto() + " Idade: " + idade + " Setor: " + setor;
    }

    @Override
    public String toString() {
        return super.toString() + " Setor: " + setor;
    }

    // amsousa Static method to calculate the average salary of all Administrativo employees
    private static double calculateAverageSalary(Funcionario[] funcionarios) {
        double totalSalary = 0;
        for (Funcionario funcionario : funcionarios) {
            totalSalary += funcionario.getSalario();
        }
        return totalSalary / funcionarios.length;
    }
}
