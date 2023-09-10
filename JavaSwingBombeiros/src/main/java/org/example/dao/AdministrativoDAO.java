package org.example.dao;

import org.example.models.Administrativo;
import org.example.models.Professor;

import java.util.ArrayList;

public class AdministrativoDAO {
    private ArrayList<Administrativo> administrativos = new ArrayList<>();

    public void addAdministrativo(Administrativo administrativo) {
        administrativos.add(administrativo);
    }

    public ArrayList<Administrativo> getAllAdministrativos() {
        return administrativos;
    }

    /*
    public Administrativo getAdministrativoById(int id) {
        for (Administrativo administrativo : administrativos) {
            if (administrativo.getId() == id) {
                return administrativo;
            }
        }
        return null;
    }
*/
    public Administrativo getAdministrativo(int index) {
        if (index >= 0 && index < administrativos.size()) {
            return administrativos.get(index);
        }
        return null;
    }
    public void updateAdministrativo(Administrativo administrativo) {
        int index = administrativos.indexOf(administrativo);
        if (index != -1) {
            administrativos.set(index, administrativo);
        }
    }

    public void deleteAdministrativo(Administrativo administrativo) {
        administrativos.remove(administrativo);
    }
}
