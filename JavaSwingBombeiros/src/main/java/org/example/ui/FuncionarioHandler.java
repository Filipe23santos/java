package org.example.ui;

import org.example.enums.Perfil;
import org.example.models.Funcionario;
import org.example.utils.StringUtils;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.example.ui.AdministrativoHandler.addAdministrativo;
import static org.example.ui.ProfessorHandler.addProfessor;

public class FuncionarioHandler {

    public static Funcionario createFuncionarioSubclass() {
        String[] funcArr = {Perfil.ADMINISTRATIVO.name(), Perfil.PROFESSOR.name(), Perfil.ALUNO.name() };
        JComboBox<String> funcComboBox = new JComboBox<>(StringUtils.capitalizeArray(funcArr));

        JOptionPane.showMessageDialog(null, funcComboBox, "Selecionar Tipo de Funcionário", JOptionPane.QUESTION_MESSAGE);

        String selectedSubclass = (String) funcComboBox.getSelectedItem();

        switch (selectedSubclass.toLowerCase()) {
            case "professor":
                return addProfessor();
            //case "Porteiro":
            //return addPorteiro();
            case "administrativo":
                return addAdministrativo();
            //case "Diretor":
            //return addDiretor();
            default:
                return null;
        }
    }

    public static void seeFunc(ArrayList<Funcionario> f) {
        if (f.isEmpty()) { //se não existem funcionários
            JOptionPane.showMessageDialog(null, "Não existe nenhum funcionário.", "Funcionario App", JOptionPane.WARNING_MESSAGE);
        } else {//se existem funcionários
            String[] choiceArr = {"Ver todos funcionários", "Ver um funcionário"};
            JComboBox<String> jcb = new JComboBox<>(choiceArr);
            JOptionPane.showMessageDialog(null, jcb, "Funcionário App", JOptionPane.QUESTION_MESSAGE);

            String selectedChoice = (String) jcb.getSelectedItem();

            if (selectedChoice != null) { //se foi selecionada uma opção
                if (selectedChoice.equalsIgnoreCase("Ver todos funcionários")) { //se selecionaram para ver todos os funcionários
                    String allEmployeesInfo = "";
                    for (Funcionario func : f) {
                        allEmployeesInfo += func.toString()+ "\n";
                    }

                    JOptionPane.showMessageDialog(null, allEmployeesInfo, "Funcionário App", JOptionPane.INFORMATION_MESSAGE);

                } else if (selectedChoice.equalsIgnoreCase("Ver um funcionário")) { //se selecionaram ver um funcionário
                    String[] namesArr = new String[f.size()];

                    for (int i = 0; i < f.size(); i++) {
                        Funcionario func = f.get(i);
                        namesArr[i] = func.nomeCompleto();
                    }

                    JComboBox<String> jcbn = new JComboBox<>(namesArr);
                    JOptionPane.showMessageDialog(null, jcbn, "Funcionario App", JOptionPane.QUESTION_MESSAGE);

                    int selectedEmployeeIndex = jcbn.getSelectedIndex();

                    if (selectedEmployeeIndex >= 0 && selectedEmployeeIndex < f.size()) {
                        Funcionario func = f.get(selectedEmployeeIndex);
                        JOptionPane.showMessageDialog(null, func.toString(), "Funcionario App", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Funcionário não encontrado!", "Funcionario App", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }

    public static void updateFunc(ArrayList<Funcionario> f) {
        if (f.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum funcionário para editar.", "Funcionário App", JOptionPane.WARNING_MESSAGE);
        } else {
            String[] choices = new String[f.size()];

            for (int i = 0; i < f.size(); i++) {
                Funcionario func = f.get(i);
                choices[i] = func.nomeCompleto();
            }

            JComboBox<String> jcb = new JComboBox<>(choices);
            JOptionPane.showMessageDialog(null, jcb, "Funcionário App", JOptionPane.QUESTION_MESSAGE);
            int selectedEmployeeIndex = jcb.getSelectedIndex();

            if (selectedEmployeeIndex >= 0 && selectedEmployeeIndex < f.size()) {
                Funcionario func = f.get(selectedEmployeeIndex);

                String nome = (String)  JOptionPane.showInputDialog(null, "Inserir nome: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE, null, null, func.getNome());
                func.setNome(nome);

                String apelido = (String) JOptionPane.showInputDialog(null, "Inserir apelido: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE, null, null, func.getApelido());
                func.setApelido(apelido);

                int idade = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Inserir idade: ", "Funcionário App", JOptionPane.QUESTION_MESSAGE, null, null, func.getIdade()));
                func.setIdade(idade);

                String[] funcArr = {"Professor", "Porteiro", "Administrador", "Diretor"};
                JComboBox<String> funcComboBox = new JComboBox<>(funcArr);
                funcComboBox.setSelectedItem(func.getFuncao());

                JOptionPane.showMessageDialog(null, funcComboBox, "Funcionário App", JOptionPane.QUESTION_MESSAGE);
                String funcao = (String) funcComboBox.getSelectedItem();
                func.setFuncao(funcao);

                double salario = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Inserir salario: ", "Funcionario App", JOptionPane.QUESTION_MESSAGE, null, null, func.getSalario()));
                func.setSalario(salario);

                JOptionPane.showMessageDialog(null, "Funcionario editado com sucesso.", "Funcionario App", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido!", "Funcionario App", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void deleteFunc(ArrayList<Funcionario> f) {
        if (f.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum funcionário para apagar.", "Funcionário App", JOptionPane.WARNING_MESSAGE);
        } else {
            String[] choices = new String[f.size()];
            for (int i = 0; i < f.size(); i++) {
                Funcionario func = f.get(i);
                choices[i] = func.nomeCompleto();
            }

            JComboBox<String> jcb = new JComboBox<>(choices);
            JOptionPane.showMessageDialog(null, jcb, "Funcionário App", JOptionPane.QUESTION_MESSAGE);
            int selectedEmployeeIndex = jcb.getSelectedIndex();

            if (selectedEmployeeIndex >= 0 && selectedEmployeeIndex < f.size()) {
                f.remove(selectedEmployeeIndex);
                JOptionPane.showMessageDialog(null, "Funcionário apagado com sucesso.", "Funcionário App", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido!", "Funcionário App", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void exportFunc(ArrayList<Funcionario> f) {
        if(!f.isEmpty()){
            ArrayList<String> linesToWrite = new ArrayList<>();

            for (Funcionario func : f) {
                linesToWrite.add(func.informacoes());
            }

            Path filePath = Paths.get("data.txt");

            try {
                Files.write(filePath, linesToWrite);
                JOptionPane.showMessageDialog(null, "Funcionários exportados com sucesso.", "Funcionário App", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao exportar os funcionários.", "Funcionário App", JOptionPane.ERROR_MESSAGE);
                //e.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Não existem funcionários para exportar.", "Funcionário App", JOptionPane.WARNING_MESSAGE);
        }
    }
}
