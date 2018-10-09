package py.com.rentacar.dao;

import java.util.List;

import py.com.rentacar.models.Cliente;
import py.com.rentacar.models.Modelo;

public class ModeloDAO extends DbUtils<Modelo>  {
	
	 public static final String TABLE_NAME = "Modelo";


	    public List<Modelo> getModelo() {
	        List<Modelo> modeloList = null;
	        try {
	        	modeloList = this.findAll(TABLE_NAME);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return modeloList;
	    }
	    
	    public Modelo getModeloById(Integer id) {
	    	Modelo modelo = null;
	        try {
	        	modelo = this.findById(Modelo.class, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return modelo;
	    }

	    public void deleteModelo(Integer id) {
	        try {
	            this.delete(Modelo.class, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
