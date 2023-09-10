package org.example.dao;

import org.example.models.Funcionario;

import java.util.ArrayList;

public class FuncionarioDAO {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionario> getAllFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public Funcionario getFuncionario(int index) {
        if (index >= 0 && index < funcionarios.size()) {
            return funcionarios.get(index);
        }
        return null;
    }

    public boolean updateFuncionario(int index, Funcionario updatedFuncionario) {
        if (index >= 0 && index < funcionarios.size()) {
            funcionarios.set(index, updatedFuncionario);
            return true;
        }
        return false;
    }

    public boolean deleteFuncionario(int index) {
        if (index >= 0 && index < funcionarios.size()) {
            funcionarios.remove(index);
            return true;
        }
        return false;
    }
}
