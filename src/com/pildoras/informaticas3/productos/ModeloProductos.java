package com.pildoras.informaticas3.productos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ModeloProductos {

	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos){
		
		this.origenDatos=origenDatos;
		
	}
	
	public List<Productos>getProductos()throws Exception{
		
		List<Productos> productos= new ArrayList<>();
		
		Connection miConexion=null;
		
		Statement miStatement=null;
		
		ResultSet miResultSet=null;
		
		try{
		
		miConexion=origenDatos.getConnection();
		
		String instruccionSql="SELECT * FROM PRODUCTOS";
		
		miStatement=miConexion.createStatement();
		
		miResultSet= miStatement.executeQuery(instruccionSql);
		
		while(miResultSet.next()){
			
			String c_art=miResultSet.getString("CODIGOARTICULO");
			
			String seccion=miResultSet.getString("SECCION");
			
			String n_art=miResultSet.getString("NOMBREARTICULO");
			
			Double precio=miResultSet.getDouble("PRECIO");
			
			Date fecha= miResultSet.getDate("FECHA");
		
			String importado=miResultSet.getString("IMPORTADO");
			
			String p_orig=miResultSet.getString("PAISDEORIGEN");
			
			Productos tempProd=new Productos(c_art, seccion, n_art, precio, fecha, importado, p_orig);
			
			productos.add(tempProd);
		
		}
		
		}finally{
			
			miStatement.close();
			
			miConexion.close();
			
		}
		
		return productos;
		
	}

	public void agregarElNuevoProducto(Productos nuevoProducto)  throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		
		PreparedStatement miStatement= null;
		
		try{
			
			miConexion=origenDatos.getConnection();
			
			String sql="INSERT INTO PRODUCTOS(CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, FECHA, IMPORTADO, PAISDEORIGEN) VALUES(?,?,?,?,?,?,?)";
			
			miStatement=miConexion.prepareStatement(sql);
			
			miStatement.setString(1, nuevoProducto.getcArt());
			
			miStatement.setString(2, nuevoProducto.getSeccion());
			
			miStatement.setString(3, nuevoProducto.getnArt());
			
			miStatement.setDouble(4, nuevoProducto.getPrecio());
			
			java.util.Date utilDate= nuevoProducto.getFecha();
			
			java.sql.Date fechaconvertida= new java.sql.Date(utilDate.getTime());
			
			miStatement.setDate(5, fechaconvertida);
			
			miStatement.setString(6, nuevoProducto.getImportado());
			
			miStatement.setString(7, nuevoProducto.getpOrig());
			
			miStatement.execute();
				
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			try {
				miStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}//cierre método agregarElNuevoProducto

	public Productos getProducto(String codigoArticulo) {
		// TODO Auto-generated method stub
		
		Productos elProducto=null;
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		ResultSet miResultSet=null;
		
		String CArticulo=codigoArticulo;
		
		try{
			
			miConexion=origenDatos.getConnection();
			
			String sql= "SELECT * FROM PRODUCTOS WHERE CODIGOARTICULO=?";
			
			miStatement=miConexion.prepareStatement(sql);
			
			miStatement.setString(1, CArticulo);
			
			miResultSet=miStatement.executeQuery();
			
			if(miResultSet.next()){
				
				String c_art=miResultSet.getString("CODIGOARTICULO");
				
				String seccion=miResultSet.getString("SECCION");
				
				String n_art=miResultSet.getString("NOMBREARTICULO");
				
				Double precio=miResultSet.getDouble("PRECIO");
				
				Date fecha=miResultSet.getDate("FECHA");
				
				String importado=miResultSet.getString("IMPORTADO");
				
				String p_orig=miResultSet.getString("PAISDEORIGEN");
				
				elProducto=new Productos(c_art, seccion, n_art, precio, fecha, importado, p_orig);
				
			}else{
				
				throw new Exception("No hemos encontrado el producto con código árticulo=" + CArticulo);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			try {
				miStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return elProducto;
	
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception {
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		try{
		
		miConexion=origenDatos.getConnection();
		
		String sql="UPDATE PRODUCTOS SET SECCION=?, NOMBREARTICULO=?, PRECIO=?, FECHA=?, IMPORTADO=?, PAISDEORIGEN=? WHERE CODIGOARTICULO=? ";
		
		miStatement=miConexion.prepareStatement(sql);
		
		miStatement.setString(1, productoActualizado.getSeccion());
		
		miStatement.setString(2, productoActualizado.getnArt());
		
		miStatement.setDouble(3, productoActualizado.getPrecio());
		
		java.util.Date utilDate= productoActualizado.getFecha();
		
		java.sql.Date fechaconvertida= new java.sql.Date(utilDate.getTime());
		
		miStatement.setDate(4, fechaconvertida);
		
		miStatement.setString(5, productoActualizado.getImportado());
		
		miStatement.setString(6, productoActualizado.getpOrig());
		
		miStatement.setString(7, productoActualizado.getcArt());
		
		miStatement.execute();
		
		}finally{
			
			miStatement.close();
			
			miConexion.close();
			
		}
			
	}

	public void eliminarProducto(String codArticulo) throws Exception {
		// TODO Auto-generated method stub
			
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		try{
		
		miConexion=origenDatos.getConnection();
		
		String sql= "DELETE FROM PRODUCTOS WHERE CODIGOARTICULO=?";
		
		miStatement=miConexion.prepareStatement(sql);
		
		miStatement.setString(1, codArticulo);
		
		miStatement.execute();
			
		}finally{
			
			miStatement.close();
			
			miConexion.close();
			
		}
			
	}
	
}
