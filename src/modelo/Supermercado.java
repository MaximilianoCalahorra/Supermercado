package modelo; //Definimos a qué paquete pertenece esta clase.

import java.time.LocalDate;
import java.time.LocalTime;

//Clase Supermercado:
public class Supermercado 
{
	//Atributos:
	AdmProducto admProducto;
	AdmCliente admCliente;
	AdmCarrito admCarrito;
	
	//Constructor:
	public Supermercado() 
	{
		this.admProducto = new AdmProducto();
		this.admCliente = new AdmCliente();
		this.admCarrito = new AdmCarrito();
	}

	//Getters:
	public AdmProducto getAdmProducto() 
	{
		return admProducto;
	}
	public AdmCliente getAdmCliente() 
	{
		return admCliente;
	}
	public AdmCarrito getAdmCarrito() 
	{
		return admCarrito;
	}

	//Setters:
	public void setAdmProducto(AdmProducto admProducto)
	{
		this.admProducto = admProducto;
	}
	public void setAdmCliente(AdmCliente admCliente) 
	{
		this.admCliente = admCliente;
	}
	public void setAdmCarrito(AdmCarrito admCarrito) 
	{
		this.admCarrito = admCarrito;
	}
	
	//To String:
	public String toString() 
	{
		return "Supermercado:\n"
				+ admProducto.toString()
				+ admCliente.toString() 
				+ admCarrito.toString();
	}
	
	///Productos:
	//Traer:
	public Producto traerProducto(int idProducto) 
	{
		return admProducto.traerProducto(idProducto);
	}

	//Agregar:
	public boolean agregarProducto(String nombre, float precio) throws Exception
	{
		return admProducto.agregarProducto(nombre, precio);
	}
	
	//Modificar:
	public boolean modificarProducto(int idProductoModificar, String nombre, float precio) throws Exception
	{
		return admProducto.modificarProducto(idProductoModificar, nombre, precio);
	}
	
	//Eliminar:
	public boolean eliminarProducto(int idProductoEliminar) throws Exception
	{
		Producto productoEnGondola = admProducto.traerProducto(idProductoEliminar);
		Carrito carritoConEseProducto = admCarrito.traerCarritoConProducto(idProductoEliminar); 
		if (productoEnGondola == null || carritoConEseProducto != null) 
		{
			throw new Exception("Error! El producto con ID #" + idProductoEliminar + " no se puede eliminar porque no existe en la lista de productos o esta en algun carrito.");	
		}
		return admProducto.lstProducto.remove(productoEnGondola);
	}
	
	///Clientes:
	//Traer:
	public Cliente traerCliente(long dni) 
	{
		return admCliente.traerCliente(dni);
	}
	
	//Agregar:
	public boolean agregarCliente(String nombre, long dni, String direccion) throws Exception
	{
		return admCliente.agregarCliente(nombre, dni, direccion);
	}
	
	//Eliminar:
	public boolean eliminarCliente(int idClienteEliminar) throws Exception
	{
		Cliente clienteEliminar = admCliente.traerCliente(idClienteEliminar);
		Carrito carritoConEseCliente = admCarrito.traerCarritoDeCliente(idClienteEliminar);
		if (clienteEliminar == null || carritoConEseCliente != null) 
		{
			throw new Exception("Error! El cliente con ID #" + idClienteEliminar + " no se puede eliminar de la lista de clientes porque no existe en ella o tiene algun carrito asociado.");
		}
		return admCliente.lstCliente.remove(clienteEliminar);
	}
	
	///Carritos:
	//Traer:
	public Carrito traerCarrito(int idCarrito) 
	{
		return admCarrito.traerCarrito(idCarrito);
	}
	
	//Agregar:
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception
	{
		return admCarrito.agregarCarrito(fecha, hora, cliente);
	}
	
	//Eliminar:
	public boolean eliminarCarrito(int idCarrito) throws Exception
	{
		return admCarrito.eliminarCarrito(idCarrito);
	}
	
	///Calcular total:
	//Total Cliente por DNI:
	public float calcularTotal(long dniCliente) throws Exception
	{
		if (admCliente.traerCliente(dniCliente) == null) 
		{
			throw new Exception("Error! El cliente con DNI #" + dniCliente + " no existe en la lista de clientes.");
		}
		float total = 0;
		Carrito carritoAuxiliar = null;
		for (int i = 0; i < admCarrito.getLstCarrito().size(); i++) 
		{
			carritoAuxiliar = admCarrito.getLstCarrito().get(i);
			if (carritoAuxiliar.getCliente().getDni() == dniCliente) 
			{
				total += carritoAuxiliar.calcularTotal();
			}
		}
		return total;
	}
	
	//Total Cliente:
	public float calcularTotal(Cliente cliente) throws Exception
	{
		if (cliente == null) //Si el cliente que llega es null.
		{
			throw new Exception("Error! El cliente no existe en la lista de clientes.");
		}
		return calcularTotal(cliente.getDni());
	}
	
	//Total fecha a fecha:
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) 
	{
		return admCarrito.calcularTotal(fechaInicio, fechaFin);
	}
	
	//Total fecha específica:
	public float calcularTotal(LocalDate fecha) 
	{
		return admCarrito.calcularTotal(fecha);
	}
	
	//Total por mes y año en específico:
	public float calcularTotal(int mes, int anio) throws Exception
	{
		return admCarrito.calcularTotal(mes, anio);
	}
	
	//Total por cliente de fecha a fecha:
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception 
	{
		if (cliente == null) //Si el cliente que llega es null.
		{
			throw new Exception("Error! El cliente no existe en la lista de clientes.");
		}
		if (admCliente.traerCliente(cliente.getIdCliente()) == null) 
		{
			throw new Exception("Error! El cliente con DNI #" + cliente.getDni() + " no existe en la lista de clientes");
		}
		Carrito carritoAuxiliar = null;
		float total = 0;
		for (int i = 0; i < admCarrito.getLstCarrito().size(); i++) 
		{
			carritoAuxiliar = admCarrito.getLstCarrito().get(i);
			if (carritoAuxiliar.getCliente().equals(cliente) &&
				!(carritoAuxiliar.getFecha().isBefore(fechaInicio)) &&
				!(carritoAuxiliar.getFecha().isAfter(fechaFin))) 
			{
				total += carritoAuxiliar.calcularTotal();
			}
		}
		return total;
	}
	
	//Total por cliente en fecha específica:
	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception
	{
		if (cliente == null) //Si el cliente que llega es null.
		{
			throw new Exception("Error! El cliente no existe en la lista de clientes.");
		}
		if (admCliente.traerCliente(cliente.getIdCliente()) == null) 
		{
			throw new Exception("Error! El cliente con DNI #" + cliente.getDni() + " no existe en la lista de clientes.");
		}
		float total = 0;
		Carrito carritoAuxiliar = null;
		for (int i = 0; i < admCarrito.getLstCarrito().size(); i++) 
		{
			carritoAuxiliar = admCarrito.getLstCarrito().get(i);
			if (carritoAuxiliar.getFecha().equals(fecha) && carritoAuxiliar.getCliente().equals(cliente)) 
			{
				total += carritoAuxiliar.calcularTotal();
			}
		}
		return total;
	}
	
	//Por mes, año y cliente en específico:
	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception
	{
		if (mes < 1 || mes > 12) 
		{
			throw new Exception("Error! El mes es invalido.");
		}
		LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
		int ultimoDia = Funciones.traerCantDiasDeUnMes(anio, mes);
		LocalDate fechaFin = LocalDate.of(anio, mes, ultimoDia);
		return calcularTotal(fechaInicio, fechaFin, cliente);
	}
		
	//Por mes, año y DNI de cliente en específico:
	public float calcularTotal(int mes, int anio, long dniCliente) throws Exception
	{
		return calcularTotal(mes, anio, admCliente.traerCliente(dniCliente));
	}
}
