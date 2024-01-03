package test; //Definimos a qué paquete pertenece esta clase.

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.Supermercado;

public class Test 
{
	public static void main(String[] args)
	{
		///Supermercado:
		Supermercado supermercado = new Supermercado();
		
		///Agregar productos al supermercado:
		//Test 1: agregar 5 productos a la lista de productos.
		try 
		{
			System.out.println("Test 1:");
			supermercado.agregarProducto("Harina integral", 250);
			supermercado.agregarProducto("Dulce de leche", 950);
			supermercado.agregarProducto("Leche", 280);
			supermercado.agregarProducto("Cacao en polvo", 360);
			supermercado.agregarProducto("Arroz integral", 350);
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 2: intentar agregar un producto que ya existe en la lista.
		try 
		{
			System.out.println("Test 2:");
			supermercado.agregarProducto("Leche", 280);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Agregar clientes al supermercado:
		//Test 3: agregar 4 clientes a la lista de clientes.
		try 
		{
			System.out.println("Test 3:");
			supermercado.agregarCliente("Maximiliano", 45191340, "Boedo 1234, Lomas de Zamora");
			supermercado.agregarCliente("Pablo", 33817221, "Laprida 1572, Lomas de Zamora");
			supermercado.agregarCliente("Juliana", 22871990, "Saenz 812, Lomas de Zamora");
			supermercado.agregarCliente("Lucrecia", 40117332, "Italia 50, Lomas de Zamora");
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 4: intentar agregar un cliente que ya existe en la lista.
		try 
		{
			System.out.println("Test 4:");
			supermercado.agregarCliente("Maximiliano", 45191340, "Boedo 1234, Lomas de Zamora");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Agregar carritos al supermercado:
		//Test 5: agregar 6 carritos a la lista de carritos.
		try 
		{
			System.out.println("Test 5:");
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 1), LocalTime.of(10, 0), supermercado.traerCliente(45191340)); //Cliente1
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 5), LocalTime.of(17, 15), supermercado.traerCliente(45191340)); //Cliente1
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 10), LocalTime.of(12, 55), supermercado.traerCliente(45191340)); //Cliente1
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 2), LocalTime.of(13, 40), supermercado.traerCliente(33817221)); //Cliente2
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 7), LocalTime.of(9, 15), supermercado.traerCliente(33817221)); //Cliente2
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 4), LocalTime.of(20, 30), supermercado.traerCliente(22871990)); //Cliente3
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 6: intentar agregar un carrito que ya existe.
		try 
		{
			System.out.println("Test 6:");
			supermercado.agregarCarrito(LocalDate.of(2023, 9, 4), LocalTime.of(20, 30), supermercado.traerCliente(22871990));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Mostrar supermercado:
		//Test 7: mostrar estado actual del supermercado.
		System.out.println("Test 7:");
		System.out.println(supermercado);
		
		///Modificar productos:
		//Test 8: modificar un producto de la lista.
		try 
		{
			System.out.println("Test 8:");
			supermercado.modificarProducto(1, "Harina", 200);
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 9: intentar modificar un producto de la lista.
		try 
		{
			System.out.println("Test 9:");
			supermercado.modificarProducto(10, "Mayonesa", 400);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Eliminar productos:
		//Test 10: eliminar un producto de la lista.
		try 
		{
			System.out.println("Test 10:");
			supermercado.eliminarProducto(5);
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 11: intentar eliminar un producto de la lista.
		try 
		{
			System.out.println("Test 11:");
			supermercado.eliminarProducto(10); //No existe en la lista.
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 12: intentar eliminar un producto de la lista.
		supermercado.getAdmCarrito().traerCarrito(1).agregarItem(supermercado.traerProducto(1), 5);
		try 
		{
			System.out.println("Test 12:");
			supermercado.eliminarProducto(1); //Está en el carrito 1.
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			//Eliminamos el ítem agregado anteriormente en el carrito 1.
			supermercado.getAdmCarrito().traerCarrito(1).eliminarItem(supermercado.traerProducto(1), 5);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Eliminar clientes:
		//Test 13: eliminar un cliente de la lista de clientes.
		try 
		{
			System.out.println("Test 13:");
			supermercado.eliminarCliente(4);
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 14: intentar eliminar un cliente de la lista.
		try 
		{
			System.out.println("Test 14:");
			supermercado.eliminarCliente(1); //Tiene al menos un carrito asociado.
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 15: intentar eliminar un cliente de la lista.
		try 
		{
			System.out.println("Test 15:");
			supermercado.eliminarCliente(10); //No existe el cliente.
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Eliminar carritos:
		//Test 16: eliminar un carrito de la lista.
		try 
		{
			System.out.println("Test 16:");
			supermercado.eliminarCarrito(3);
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 17: intentar eliminar un carrito de la lista.
		try 
		{
			System.out.println("Test 17:");
			supermercado.eliminarCarrito(10);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		///Mostrar supermercado:
		//Test 18: mostrar estado actual del supermercado.
		System.out.println("Test 18");
		System.out.println(supermercado);
		
		///Agregar ítems a los carritos:
		//Test 19: agregar 3 productos distintos a cada carrito.
		System.out.println("Test 19");
		//Carrito 1:
		supermercado.getAdmCarrito().traerCarrito(1).agregarItem(supermercado.traerProducto(1), 3); //3 producto1.
		supermercado.getAdmCarrito().traerCarrito(1).agregarItem(supermercado.traerProducto(1), 1); //4 producto1.
		supermercado.getAdmCarrito().traerCarrito(1).agregarItem(supermercado.traerProducto(3), 2); //2 producto3.
		supermercado.getAdmCarrito().traerCarrito(1).agregarItem(supermercado.traerProducto(4), 1); //1 producto4.
		//Carrito 2:
		supermercado.getAdmCarrito().traerCarrito(2).agregarItem(supermercado.traerProducto(1), 5); //5 producto1.
		supermercado.getAdmCarrito().traerCarrito(2).agregarItem(supermercado.traerProducto(2), 2); //2 producto2.
		supermercado.getAdmCarrito().traerCarrito(2).agregarItem(supermercado.traerProducto(4), 3); //3 producto4.
		//Carrito 4:
		supermercado.getAdmCarrito().traerCarrito(4).agregarItem(supermercado.traerProducto(1), 2); //2 producto1.
		supermercado.getAdmCarrito().traerCarrito(4).agregarItem(supermercado.traerProducto(3), 5); //5 producto3.
		supermercado.getAdmCarrito().traerCarrito(4).agregarItem(supermercado.traerProducto(4), 3); //3 producto4.
		//Carrito 5:
		supermercado.getAdmCarrito().traerCarrito(5).agregarItem(supermercado.traerProducto(4), 2); //2 producto4.
		supermercado.getAdmCarrito().traerCarrito(5).agregarItem(supermercado.traerProducto(1), 6); //6 producto1.
		supermercado.getAdmCarrito().traerCarrito(5).agregarItem(supermercado.traerProducto(3), 4); //4 producto3.
		//Carrito 6:
		supermercado.getAdmCarrito().traerCarrito(6).agregarItem(supermercado.traerProducto(1), 3); //3 producto1.
		supermercado.getAdmCarrito().traerCarrito(6).agregarItem(supermercado.traerProducto(2), 8); //8 producto2.
		supermercado.getAdmCarrito().traerCarrito(6).agregarItem(supermercado.traerProducto(3), 1); //1 producto3.
		System.out.println("Todo correcto!\n");
		
		///Mostrar carritos:
		//Test 20: mostrar estado de carritos del supermercado.
		System.out.println("Test 20");
		System.out.println(supermercado.getAdmCarrito());
		
		///Eliminar ítems:
		//Test 21: eliminar un ítem de cada carrito:
		System.out.println("Test 21:");
		//Carrito1:
		try 
		{
			System.out.println("Carrito 1:");
			supermercado.getAdmCarrito().traerCarrito(1).eliminarItem(supermercado.traerProducto(1), 2); //2 producto1.
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Carrito 2:
		try 
		{
			System.out.println("Carrito 2:");
			supermercado.getAdmCarrito().traerCarrito(2).eliminarItem(supermercado.traerProducto(1), 5); //0 producto1.
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Carrito 4:
		try 
		{
			System.out.println("Carrito 4:");
			supermercado.getAdmCarrito().traerCarrito(4).eliminarItem(supermercado.traerProducto(3), 2); //3 producto3.
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			System.out.println("Carrito 4:");
			supermercado.getAdmCarrito().traerCarrito(4).eliminarItem(supermercado.traerProducto(10), 2); //No existe producto10.
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Carrito 5:
		try 
		{
			System.out.println("Carrito 5:");
			supermercado.getAdmCarrito().traerCarrito(5).eliminarItem(supermercado.traerProducto(1), 3); //3 producto1.
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Carrito 6:
		try 
		{
			System.out.println("Carrito 6:");
			supermercado.getAdmCarrito().traerCarrito(6).eliminarItem(supermercado.traerProducto(2), 4); //4 producto2.
			System.out.println("Todo correcto!\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Todo correcto!\n");
		///Mostrar carritos:
		//Test 22: mostrar estado de carritos del supermercado.
		System.out.println("Test 22");
		System.out.println(supermercado.getAdmCarrito());
		
		///Calcular totales:
		//Test 23: calcular total por DNI del cliente.
		try 
		{
			System.out.println("Test 23:");
			System.out.println("Total cliente DNI #45191340: $" + supermercado.calcularTotal(45191340) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 24: intentar calcular total por DNI del cliente
		try 
		{
			System.out.println("Test 24:");
			System.out.println("Total cliente DNI #45191990: $" + supermercado.calcularTotal(45191990) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		//Test 25: calcular total de carritos del 2/9/2023 al 5/9/2023 (inclusive).
		System.out.println("Test 25:");
		System.out.println("Total carritos del 2/9/2023 al 5/9/2023: $" + supermercado.calcularTotal(LocalDate.of(2023, 9, 2), LocalDate.of(2023, 9, 5)) + "\n");
	
		//Test 26: calcultar total de carritos en 9/2023.
		try 
		{
			System.out.println("Test 26:");
			System.out.println("Total de carritos en 9/2023: $" + supermercado.calcularTotal(9, 2023) + "\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Test 27: intentar calcular total de carritos en 20/2023.
		try 
		{
			System.out.println("Test 27:");
			System.out.println("Total de carritos en 20/2023: $" + supermercado.calcularTotal(20, 2023) + "\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Test 28: calcular total de carritos por cliente entre fechas.
		try 
		{
			System.out.println("Test 28:");
			System.out.println("Total carritos cliente con DNI #33817221 entre 2/9/2023 y 7/9/2023: $" + supermercado.calcularTotal(LocalDate.of(2023, 9, 2), LocalDate.of(2023, 9, 7), supermercado.traerCliente(33817221)) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 29: intentar calcular total de carritos por cliente entre fechas.
		try 
		{
			System.out.println("Test 29:");
			System.out.println("Total carritos cliente con DNI #33817223 entre 2/9/2023 y 7/9/2023: $" + supermercado.calcularTotal(LocalDate.of(2023, 9, 2), LocalDate.of(2023, 9, 7), supermercado.traerCliente(33817223)) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 30: calcular total de carritos de un cliente en una fecha específica.
		try 
		{
			System.out.println("Test 30:");
			System.out.println("Total carritos cliente con DNI #33817221 el 7/9/2023: $" + supermercado.calcularTotal(LocalDate.of(2023, 9, 7), supermercado.traerCliente(33817221)) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 31: intentar calcular total de carritos de un cliente en una fecha específica.
		try 
		{
			System.out.println("Test 31:");
			System.out.println("Total carritos cliente con DNI #33817223 el 7/9/2023: $" + supermercado.calcularTotal(LocalDate.of(2023, 9, 7), supermercado.traerCliente(33817223)) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 32: calcular el total de los carritos de un cliente por DNI en un mes y año determinado.
		try 
		{
			System.out.println("Test 32:");
			System.out.println("Total cliente con DNI #45191340 en 09/2023: $" + supermercado.calcularTotal(9, 2023, 45191340) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Test 33: intentar calcular el total de los carritos de un cliente por DNI en un mes y año determinado.
		try 
		{
			System.out.println("Test 33:");
			System.out.println("Total cliente con DNI #45191440 en 09/2023: $" + supermercado.calcularTotal(9, 2023, 45191440) + "\n");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
