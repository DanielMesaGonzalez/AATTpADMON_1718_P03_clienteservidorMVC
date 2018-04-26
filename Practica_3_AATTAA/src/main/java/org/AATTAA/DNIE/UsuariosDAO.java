package org.AATTAA.DNIE;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosDAO implements UsuarioDAOInterface{
	
	
	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
//Método encargado de introducir los datos de un nuevo usuario en la BBDD quedando así registrado en ella.
	@Override
	public void InsertaUsuario(Usuario usuario) {
		String sql = "insert into usuarios values(?,?,?,?,?)";
		Object[ ] parametros = {usuario.getNombre(),usuario.getApellido1(),usuario.getNif(),usuario.getApellido2(),usuario.getNick()};
		this.jdbcTemplate.update(sql,parametros);
	}
	
//Método encargado de mostrar los datos de un usuario registrado en la BBDD.
	@Override
	public List<Usuario> leeUsuario() {
		String sql= "select * from usuarios";
		UsuarioMapper mapper= new UsuarioMapper();
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios= this.jdbcTemplate.query(sql, mapper);
		
		return usuarios ;
	}
	
//Método encargado de realizar la búsqueda de un usuario en la BBDD.
	@Override
	public Usuario BuscarUsuario(String nif, String nick) {    
		String sql = "select * from usuarios where DNI = ? and Nick= ?";    
		Object[] parametros = {nif,nick};   //Array de objetos
		UsuarioMapper mapper = new UsuarioMapper();
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
		if (usuarios.isEmpty()) return null;
		else return usuarios.get(0);
		
			
	}
	
	
}
