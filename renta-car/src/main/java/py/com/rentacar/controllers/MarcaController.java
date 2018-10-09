package py.com.rentacar.controllers;

import java.util.List;


import py.com.rentacar.dao.MarcaDAO;
import py.com.rentacar.models.Marca;

public class MarcaController {
	MarcaDAO dao = new MarcaDAO();

    public List<Marca> getMarca() {
        try {
            return dao.getMarca();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void createMarca(Marca marca) {
        try {
            dao.insert(marca);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMarca(Marca marca, String id) {
        try {
            dao.update(marca, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMarca(String id) {
        try {
            dao.deleteMarca(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Marca getMarcaById(String id) {
    	Marca marca = null;
        try {
        	marca = dao.getMarcaById(Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return marca;
    }

}
