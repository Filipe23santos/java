package org.example.models;

public abstract class Pessoa {
    protected String nome, apelido;
    protected int idade;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank() || nome.isEmpty()) {
            this.nome = "Novo";
        } else {
            this.nome = nome;
        }
    }

    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        if (apelido.isBlank()) {
            this.apelido = "Funcionário";
        } else {
            this.apelido = apelido;
        }
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = Math.max(idade, 18);

/*        if (idade < 18) {
            this.idade = 18;
        } else {
            this.idade = idade;
        }*/
    }

    public Pessoa(String nome, String apelido, int idade) {
        setNome(nome);
        setApelido(apelido);
        setIdade(idade);
    }

    //amsousa
    public String nomeCompleto() {
        return this.nome + " " + this.apelido;
    }

    //amsousa
    public abstract String informacoes();

    //amsousa
    @Override
    public String toString() {
        return "Nome: " + nomeCompleto() + " Idade: " + idade;
    }
}
