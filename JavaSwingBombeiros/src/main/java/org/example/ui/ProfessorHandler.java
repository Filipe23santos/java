package org.example.ui;

import org.example.models.Professor;

import javax.swing.*;


public class ProfessorHandler {
    public static Professor addProfessor() {
        String nome = JOptionPane.showInputDialog(null, "Inserir nome: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);
        String apelido = JOptionPane.showInputDialog(null, "Inserir apelido: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);
        String idadeInput = JOptionPane.showInputDialog(null, "Inserir idade: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);
        int idade = (idadeInput != null && !idadeInput.trim().isEmpty()) ? Integer.parseInt(idadeInput) : 18;
        String disciplina = JOptionPane.showInputDialog(null, "Inserir disciplina: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);

        String salarioInput = JOptionPane.showInputDialog(null, "Inserir salario: ", "Funcionario App", JOptionPane.QUESTION_MESSAGE);
        double salario = (salarioInput != null && !salarioInput.trim().isEmpty()) ? Double.parseDouble(salarioInput) : 5000;

        JOptionPane.showMessageDialog(null, "Professor inserido com sucesso.", "Funcionário App", JOptionPane.INFORMATION_MESSAGE);

        return new Professor(nome, apelido, idade, "Professor", salario, disciplina);
    }
}
