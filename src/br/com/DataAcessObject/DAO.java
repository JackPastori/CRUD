package br.com.DataAcessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import Farmacia.Usuario;
import br.com.farmacia.connector.ConfigSQL;

public class DAO {

	//CRUD FARMACIA
	//create
	public void save(Usuario usuario) {

		String sql = "INSERT INTO usuarios(nome, email, senha, dataDeCadastro) VALUES(?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement user = null;

		try {
			conn = ConfigSQL.createConnectiontomysql();
			user = conn.prepareStatement(sql);
			//create 
			user.setString(1, usuario.getNome());
			user.setString(2, usuario.getEmail());
			user.setString(3, usuario.getSenha());
			user.setString(4, usuario.getDataDeCadastro());

			//execucao
			user.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				if (user!=null) {
					user.close();	
				}

				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	//read
	public List<Usuario> getFarmacias(){
		String sql = "SELECT * FROM usuarios";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement user = null;
		ResultSet result = null;

		try {

			conn = ConfigSQL.createConnectiontomysql();
			user = conn.prepareStatement(sql);
			result = user.executeQuery();	

			while (result.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuario.setEmail(result.getString("email"));
				usuario.setSenha(result.getString("senha"));
				usuario.setDataDeCadastro(result.getString("dataDeCadastro"));

				usuarios.add(usuario);}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(result!=null) {
					result.close();
				}

				if(user!=null) {
					user.close();
				}

				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return usuarios;
	}
	
	//update
	public void alterar(Usuario usuario) throws Exception{

		String sql = "update usuarios set nome = ?, email = ?, senha = ? where id = ?";
		 Connection conn = ConfigSQL.createConnectiontomysql();
		try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setInt(4, usuario.getId());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//delete
	public void excluir(Usuario usuario) throws Exception{
		String sql = "delete from usuarios where id = ?";
		Connection conn = ConfigSQL.createConnectiontomysql();
		try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
			preparedStatement.setInt(1, usuario.getId());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}