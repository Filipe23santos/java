package org.example;

import org.example.enums.Perfil;
import org.example.ui.MenuHandler;
import org.example.utils.FicheiroUtils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MenuHandler menuHandler = new MenuHandler();

        while (true) {
            String mainOption = JOptionPane.showInputDialog(null, FicheiroUtils.readProperty("mainMenu"), "Gestão de Pessoal", JOptionPane.INFORMATION_MESSAGE);

            if (mainOption == null || mainOption.equals("5")) {
                break;
            }

            Perfil role = menuHandler.getRoleFromOption(mainOption);

            if (role != null) {
                menuHandler.runMenu(role);
            }
        }
    }
}