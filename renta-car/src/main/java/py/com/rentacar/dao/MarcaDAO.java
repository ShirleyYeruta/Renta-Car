package py.com.rentacar.dao;

import java.util.List;

import py.com.rentacar.models.Marca;


public class MarcaDAO extends DbUtils<Marca>  {
	public static final String TABLE_NAME = "Marca";


    public List<Marca> getMarca() {
        List<Marca> marcaList = null;
        try {
        	marcaList = this.findAll(TABLE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marcaList;
    }
    
    public Marca getMarcaById(Integer id) {
    	Marca marca = null;
        try {
        	marca = this.findById(Marca.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marca;
    }

    public void deleteMarca(Integer id) {
        try {
            this.delete(Marca.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
