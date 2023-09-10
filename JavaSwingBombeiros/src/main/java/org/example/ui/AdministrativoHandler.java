package org.example.ui;

import org.example.models.Administrativo;

import javax.swing.*;

public class AdministrativoHandler {
    public static Administrativo addAdministrativo() {
        String nome = JOptionPane.showInputDialog(null, "Inserir nome: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);
        String apelido = JOptionPane.showInputDialog(null, "Inserir apelido: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);
        String idadeInput = JOptionPane.showInputDialog(null, "Inserir idade: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);
        int idade = (idadeInput != null && !idadeInput.trim().isEmpty()) ? Integer.parseInt(idadeInput) : 18;
        String setor = JOptionPane.showInputDialog(null, "Inserir setor: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE);

        String salarioInput = JOptionPane.showInputDialog(null, "Inserir salario: ", "Funcionario App", JOptionPane.QUESTION_MESSAGE);
        double salario = (salarioInput != null && !salarioInput.trim().isEmpty()) ? Double.parseDouble(salarioInput) : 3500;

        JOptionPane.showMessageDialog(null, "Funcionário Administrativo inserido com sucesso.", "Funcionário App", JOptionPane.INFORMATION_MESSAGE);

        return new Administrativo(nome, apelido, idade, "Administrativo", salario, setor);
    }
}
