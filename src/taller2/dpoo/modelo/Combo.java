package taller2.dpoo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto {
	
	List<String> objetos ;
	int porcentaje;
	int costo;
	String nombreCombo;
	
	public Combo(String name, int valor, int porcentaje) {
		this.costo = valor ;
		this.nombreCombo = name ;
		this.porcentaje = porcentaje;
		this.objetos= new ArrayList<String>();
	}
	
	public void agregarItemACombo(Producto itemC) {
		
		int costoneto=itemC.getPrecio();
		costo+=(100-porcentaje)*(costoneto)/100;
		this.objetos.add(itemC.getNombre());
		
	}

	public int getPrecio() {
		return costo ;
		
	}
	
	public String generarTextoFactura() {
		return ("P: "+nombreCombo+ ", V:"+ costo);
		
	}
	
	public String getNombre() {
		return nombreCombo ;
		
	}
}