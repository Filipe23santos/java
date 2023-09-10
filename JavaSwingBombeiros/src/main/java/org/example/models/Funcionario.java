package org.example.models;

import org.example.interfaces.Trabalhador;

public class Funcionario extends Pessoa implements Trabalhador {
    // amsousa Static method to generate a unique ID for each Professor
    private int funcionarioId;
    private static int nextId = 1;
    // amsousa Static attribute to keep track of the total number of Funcionarios created
    private static int totalFuncionarios = 0;
    protected String funcao;
    protected double salario;

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        if (funcao.isBlank()) {
            this.funcao = "Sem função atribuída";
        } else {
            this.funcao = funcao;
        }
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if (salario < 760) {
            this.salario = 760;
        } else {
            this.salario = salario;
        }
    }

    public Funcionario(String nome, String apelido, int idade, String funcao, double salario) {
        super(nome, apelido, idade); // Call the constructor of the superclass (Pessoa)
        setFuncao(funcao);
        setSalario(salario);
        this.funcionarioId = nextId++;
        totalFuncionarios++; // Increment the total number of Funcionarios
    }

    // amsousa Overloaded constructor without funcao and salario parameters
    public Funcionario(String nome, String apelido, int idade) {
        super(nome, apelido, idade);
        setFuncao("");
        setSalario(0);
        this.funcionarioId = nextId++;
        totalFuncionarios++; // Increment the total number of Funcionarios
    }

    public void calcAumentoSalario(double perc) {
        this.salario = this.salario * perc + this.salario;
    }

    //amsousa
    @Override
    public String informacoes() {
        return "Nome: " + nomeCompleto() + " Idade: " + idade + " Função: " + funcao + " Salário: " + salario;

    }

    //amsousa
    @Override
    public String toString() {
        return super.toString() + " Função: " + funcao + " Salário: " + salario;
    }

    @Override
    public double calcularSalarioAnual() {
        return salario * 12;
    }

    // amsousa Static method to get the total number of Funcionarios created
    public static int getTotalFuncionarios() {
        return totalFuncionarios;
    }
}
