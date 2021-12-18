package edu.uptc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.uptc.model.Cliente;
import edu.uptc.model.Direccion;
import edu.uptc.model.EformaPago;
import edu.uptc.model.Sucursal;

public class DAO {
	private String  maquina     = "localhost";
	private String  usuario     = "root";
	private String  clave       = "123456";
	private String  db       = "empleado";
	private int puerto          = 3306;

	public void reservar(int id_cliente, int idSucursal, String fecha, String hora, EformaPago eformaPago) throws ClassNotFoundException, SQLException {
		Statement stmt= null;
		String query = "insert into reserva (id_cliente, id_sucursal, idMesa, fecha, HORA, FORMA_PAGO) "
				+ "values('"+id_cliente+"','"+idSucursal+"','"+fecha+"','"+hora + "','"+ eformaPago.toString() +");";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://"+this.maquina+":"+this.puerto+"/"+db,this.usuario,this.clave);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
			System.out.println("");
		}catch(SQLException sqlex){throw sqlex;}
	}

	public Cliente buscarCliente(int id_cliente) throws ClassNotFoundException, SQLException {
		Statement stmt= null;
		/*select * from CLIENTE c, DIRECCION d 
		WHERE 
	    c.id_direccion = d.id_direccion And
	    id_cliente= 123;*/

		String query = "select * from CLIENTE c, DIRECCION d where c.id_direccion = d.id_direccion And id_cliente="+id_cliente+";";

		Cliente cliente = null;	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://"+this.maquina+":"+this.puerto+"/"+db,this.usuario,this.clave);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), new Direccion(rs.getInt("calle"), rs.getInt("carrera")));
			}
			con.close();
			System.out.println("");
		}catch(SQLException sqlex){throw sqlex;}
		return cliente;
	}

	public ArrayList<Sucursal> verSucursales() throws ClassNotFoundException, SQLException {
		ArrayList<Sucursal> sucursalList = new ArrayList<Sucursal>();

		Statement stmt= null;
		String query = "select * from SUCURSAL s, DIRECCION d"
				+ "	where s.id_direccion = d.id_direccion;";
		
		//String query = "select * from empleado;";
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://"+this.maquina+":"+this.puerto+"/"+db,this.usuario,this.clave);
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			//System.out.println(rs.getInt("emp_id"));
			sucursalList.add(new Sucursal(rs.getInt("id_sucursal"), rs.getString("nombre"), new Direccion(rs.getInt("calle"), rs.getInt("carrera"))));
		}
		con.close();
		return sucursalList;
	}
}