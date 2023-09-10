package org.example.dao;

import org.example.models.Professor;

import java.util.ArrayList;

public class ProfessorDAO {
    private ArrayList<Professor> professores = new ArrayList<>();

    public void addProfessor(Professor professor) {
        professores.add(professor);
    }

    public ArrayList<Professor> getAllProfessores() {
        return new ArrayList<>(professores);
    }

    public Professor getProfessor(int index) {
        if (index >= 0 && index < professores.size()) {
            return professores.get(index);
        }
        return null;
    }

    public boolean updateProfessor(int index, Professor updatedProfessor) {
        if (index >= 0 && index < professores.size()) {
            professores.set(index, updatedProfessor);
            return true;
        }
        return false;
    }

    public boolean deleteProfessor(int index) {
        if (index >= 0 && index < professores.size()) {
            professores.remove(index);
            return true;
        }
        return false;
    }
}
