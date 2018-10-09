package py.com.rentacar.controllers;

import java.util.List;


import py.com.rentacar.dao.ModeloDAO;
import py.com.rentacar.models.Modelo;

public class ModeloController {
	ModeloDAO dao = new ModeloDAO();

    public List<Modelo> getModelo() {
        try {
            return dao.getModelo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void createModelo(Modelo modelo) {
        try {
            dao.insert(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateModelo(Modelo modelo, String id) {
        try {
            dao.update(modelo, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteModelo(String id) {
        try {
            dao.deleteModelo(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Modelo getModeloById(String id) {
    	Modelo modelo = null;
        try {
        	modelo = dao.getModeloById(Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }

}
