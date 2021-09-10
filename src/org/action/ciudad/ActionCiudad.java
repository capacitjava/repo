package org.action.ciudad;

import java.util.ArrayList;
import java.util.List;

import org.dao.generic.DaoGeneric;
import org.modelo.ciudad.Ciudad;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionCiudad extends ActionSupport implements ModelDriven<Ciudad>{
	
	private Ciudad ciudad = new Ciudad();
	private DaoGeneric dao = new DaoGeneric();
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();//get y set
	private List<String> nombresCiudades = new ArrayList<String>(); //get y set
	
	public String execute() {
		return SUCCESS;
	}
	public String catalogo() {
		setCiudades(dao.listCiudad());
		for (Ciudad x : ciudades) {
			nombresCiudades.add(x.getNombre());
		}
		return SUCCESS;
	}
	@Override
	public Ciudad getModel() {
		// TODO Auto-generated method stub
		return ciudad;
	}
	//GETTERS AND SETTERS OF CIUDADES AND NOMBRESCIUDADES
	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	public List<String> getNombresCiudades() {
		return nombresCiudades;
	}
	public void setNombresCiudades(List<String> nombresCiudades) {
		this.nombresCiudades = nombresCiudades;
	}
	
	
	
	

}
