package org.example.ui;

import org.example.dao.FuncionarioDAO;
import org.example.dao.ProfessorDAO;
import org.example.enums.Perfil;
import org.example.models.Funcionario;
import org.example.utils.FicheiroUtils;

import javax.swing.*;
import java.util.ArrayList;
import static org.example.enums.Perfil.ADMINISTRADOR;
import static org.example.enums.Perfil.PROFESSOR;

import static org.example.ui.FuncionarioHandler.*;

public class MenuHandler {
    private ArrayList<Funcionario> f = new ArrayList<>();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * <p>Método de escolha do perfil a utilizar</p>
     * @param option a escolha do perfil a utilizar
     * @return Devolve o perfil a utilizar
     */
    public Perfil getRoleFromOption(String option) {
        switch (option) {
            case "1":
                return Perfil.ADMINISTRADOR;
            case "2":
                return Perfil.ADMINISTRATIVO;
            case "3":
                return Perfil.PROFESSOR;
            case "4":
                return Perfil.ALUNO;
            default:
                JOptionPane.showMessageDialog(null, FicheiroUtils.readProperty("opcInv"));
                return null;
        }
    }

    /**
     * <p>Método para apresentar o menú consoante o perfil</p>
     * @param role perfil de utilizador
     */
    public void runMenu(Perfil role) {
        while (true) {
            String menuOptions = getMenuOptions(role);
            String menuChoice = JOptionPane.showInputDialog(null, menuOptions, "Menu", JOptionPane.INFORMATION_MESSAGE);

            if (menuChoice == null || (role == Perfil.ADMINISTRADOR && menuChoice.equals("3"))) {
                break;
            }
            if (menuChoice == null || (role == Perfil.ADMINISTRATIVO && menuChoice.equals("5"))) {
                break;
            }
            if (menuChoice == null || (role == Perfil.PROFESSOR && menuChoice.equals("1"))) {
                break;
            }
            if (menuChoice == null || (role == Perfil.ALUNO && menuChoice.equals("1"))) {
                break;
            }

            handleMenuChoice(role, menuChoice);
        }
    }

    /**
     * <p>Define as opções específicas para cada menú</p>
     * @param role perfil a utilizar
     * @return devolve o menú com as opções do utilizador
     */
    private String getMenuOptions(Perfil role) {
        String menu = "Menu de " + role + ":\n";
        int optionCount = 1;

        for (String option : getOptionsForRole(role)) {
            menu += optionCount + ". " + option + "\n";
            optionCount++;
        }

        menu += optionCount + ". " + getBackOption(role) + "\n";
        menu += "Opção:";

        return menu;
    }

    /**
     * <p>Menú para interagir com as opções do perfil a utilizar</p>
     * @param role perfil a utilizar
     * @param choice opções do menú
     */
    private void handleMenuChoice(Perfil role, String choice) {
        int choiceNumber = Integer.parseInt(choice);
        String[] options = getOptionsForRole(role);

        if (choiceNumber >= 1 && choiceNumber <= options.length) {

            switch (role) {
                case ADMINISTRADOR:
                    handleAdminChoice(Integer.toString(choiceNumber));
                    break;
                case ADMINISTRATIVO:
                    handleAdministrativeChoice(Integer.toString(choiceNumber));
                    break;
                case PROFESSOR:
                    handleAdminChoice(Integer.toString(choiceNumber));
                    break;
                case ALUNO:
                    handleAdminChoice(Integer.toString(choiceNumber));
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, FicheiroUtils.readProperty("opcInv"));
        }
    }

    /**
     * <p>Método para obter as opções para um dado perfil</p>
     * @param role perfil a utilizar
     * @return devolve as opções de um dado perfil
     */
    private String[] getOptionsForRole(Perfil role) {
        switch (role) {
            case ADMINISTRADOR:
                return FicheiroUtils.readProperties(new String[]{ "importFunc", "exportFunc" });
            case ADMINISTRATIVO:
                return FicheiroUtils.readProperties(new String[]{ "addFunc", "seeFunc", "updateFunc", "deleteFunc" });
            default:
                return new String[0];
        }
    }

    /**
     * <p>Método para definir as opções para voltar para menú anterior, ou para sair da aplicação</p>
     * @param role perfil a utilizar
     * @return devolve as opções para voltar para menú anterior, ou para sair da aplicação
     */
    private String getBackOption(Perfil role) {
        return role != null ? FicheiroUtils.readProperty("goBack") : FicheiroUtils.readProperty("exit");
    }

    /**
     * <p>Menú para interagir com as opções do menú do perfil <b>Administrador</b></p>
     * @param choice opções do perfil <b>Administrador</b>
     */
    private void handleAdminChoice(String choice) {
        switch (choice) {
            case "1":
            case "2":
                exportFunc(f);
                break;
            case "3":
                // Handle "Voltar"
                break;
            default:
                JOptionPane.showMessageDialog(null, FicheiroUtils.readProperty("opcInv"));
        }
    }

    /**
     * <p>Menú para interagir com as opções do menú do perfil <b>Administrativo</b></p>
     * @param choice opções do perfil <b>Administrativo</b>
     */
    private void handleAdministrativeChoice(String choice) {
        switch (choice) {
            case "1":
                Funcionario newFuncionario = createFuncionarioSubclass();
                if (newFuncionario != null) {
                    funcionarioDAO.addFuncionario(newFuncionario);
                    JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso.", "Funcionário App", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "2":
                seeFunc(funcionarioDAO.getAllFuncionarios());
                break;
            case "3":
                updateFunc(funcionarioDAO.getAllFuncionarios());
                break;
            case "4":
                deleteFunc(funcionarioDAO.getAllFuncionarios());
                break;
            case "5":
                // Handle "Voltar"
                break;
            default:
                JOptionPane.showMessageDialog(null, FicheiroUtils.readProperty("opcInv"));
        }
    }
    
    
}
