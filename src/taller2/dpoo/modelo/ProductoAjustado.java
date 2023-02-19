package taller2.dpoo.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAjustado implements Producto {
	
	ProductoMenu main ;
	String nombre;
	int precio;
	List<Ingrediente> m;
	List<Ingrediente> mq;
	
	//Constructores productoMenu (Herencia base 1)
	public ProductoAjustado(ProductoMenu base) {
		this.nombre = base.getNombre() ;
		this.precio = base.getPrecio() ;
		m = new ArrayList<Ingrediente>();
		mq= new ArrayList<Ingrediente>();
	}

	public String getNombre() {
		return nombre ;		
	}
	
	public int getPrecio() {
		return precio ;
	}
	
	public String generarTextoFactura() {
		String y = "P: "+this.nombre+" V: "+this.precio+"\n";
		
		int i=0;
		
		while (i<m.size()) {
			y=y+"SI: "+m.get(i).getNombre()+"\n";
			i+=1;
		}
		
		int j=0;
		
		while (j<mq.size()) {
			y=y+"NO: "+mq.get(j).getNombre()+"\n";
			i+=1;
		}
		
		return y;		
	}
	
	public void elecciones(Ingrediente main) {
		
		precio+= main.getCostoAdicional();
		m.add(main) ;
		
	}
	
	public void eleccionesq(Ingrediente main) {
		mq.add(main);
	}
}

