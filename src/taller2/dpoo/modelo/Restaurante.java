package taller2.dpoo.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
	//Se definen las relaciones(atributos) entre clases herencia
	Pedido actual ;
	HashMap<Integer,Pedido> pedidos ;
	HashMap<String,ProductoMenu> menuBase ;
	HashMap<String,Combo> combos ;
	HashMap<String,Ingrediente> ingredientes ;
	
	//Atributos asociados a su clase 
	
	public Restaurante() {
		pedidos= new HashMap<Integer,Pedido>();
		menuBase   = new HashMap<String,ProductoMenu>();
		combos = new HashMap<String,Combo>();
		ingredientes = new HashMap<String,Ingrediente>();
	}
	
	//Definicion de métodos
	public void iniciarPedido(String nombrecliente, String direccionCliente) {
		
		Pedido main = new Pedido(nombrecliente, direccionCliente) ;
		
		actual = main ;
			
	}
	
	public void cerrarYGuardarPedido() {

		pedidos.put(actual.getPedido(),actual) ;
		actual.guardarFactura();
		actual = null ;
	}
	
	public Pedido getPedidoID(int id) {
		
		return pedidos.get(id);
	}
	
	public Pedido getPedidoEnCurso() {
		
		return actual;
	}
	
	public boolean hayPedidoActual() {
		
		if (actual == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public ArrayList<Producto> getMenuBase() {
		ArrayList<Producto> productos = new ArrayList<>(combos.values());	
		productos.addAll(menuBase.values());
		return productos ;
	}
	
	public HashMap<String,ProductoMenu> getMenuAjustado() {
		return menuBase ;
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		ArrayList<Ingrediente> ing = new ArrayList<>(ingredientes.values());
		return ing ;
		
	}
	
	//Funciones de procesamiento. Carga txt
	
	public void cargarInfoRestaurante() {
		
		actual = null;
		cargarMenu();
		cargarIngredientes();
		cargarCombos() ;
		
	}
	
	private void cargarIngredientes() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("data/ingredientes.txt"));
			String linea = br.readLine() ;
		
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String add = partes[0];
				int costo = Integer.parseInt(partes[1]) ;
				
				Ingrediente lec = new Ingrediente(add, costo) ;
				
				ingredientes.put(add,lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Unexpected, ingredientes") ;
		}
	}			
	
	private void cargarMenu() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"));
			String linea = br.readLine() ;
			
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String obj = partes[0];
				int costo = Integer.parseInt(partes[1]) ;
				
				ProductoMenu lec = new ProductoMenu(obj, costo) ;
				menuBase.put(obj,lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Unexpected, menu") ;
		}
	}	
		
	private void cargarCombos() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/combos.txt"));
			String linea = br.readLine() ;
		
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String nombre = partes[0];
				partes[1]=partes[1].replace("%", "");
				
				int porcentaje = Integer.parseInt(partes[1]) ;
				
				int i=2;
				Combo lec = new Combo(nombre, 0, porcentaje);
				while (i<partes.length){
					
					ProductoMenu obj=menuBase.get(partes[i]);
					
					lec.agregarItemACombo(obj);

					i+=1;
				}
				
				combos.put(nombre, lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Unexpected, combos") ;
		}
	}	
}

