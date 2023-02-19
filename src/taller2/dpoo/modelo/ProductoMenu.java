package taller2.dpoo.modelo;

public class ProductoMenu implements Producto {
	
	String nombre;
	int precio;

	public ProductoMenu(String nombre, int precioBase ) {
		this.nombre = nombre;
		this.precio = precioBase;
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String generarTextoFactura() {
		return ("P: "+ nombre +", V: "+ precio);
		
	}
	

}
