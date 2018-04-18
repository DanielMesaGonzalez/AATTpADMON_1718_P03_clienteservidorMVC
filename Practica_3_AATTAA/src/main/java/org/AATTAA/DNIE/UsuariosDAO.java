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

	@Override
	public void InsertaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		String sql = "insert into usuarios values(?,?,?,?,?)";
		Object[ ] parametros = {usuario.getNombre(),usuario.getApellido1(),usuario.getNif(),usuario.getApellido2()};
		this.jdbcTemplate.update(sql,parametros);
	}

	@Override
	public List<Usuario> leeUsuario() {
		String sql= "select * from usuarios";
		UsuarioMapper mapper= new UsuarioMapper();
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios= this.jdbcTemplate.query(sql, mapper);
		
		return usuarios ;
	}

	@Override
	public Usuario BuscarUsuario(String nif) {
		String sql = "select * from usuarios where DNI = ?";
		Object[] parametros = {nif};   //Array de objetos
		UsuarioMapper mapper = new UsuarioMapper();
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
		if (usuarios.isEmpty()) return null;
		else return usuarios.get(0);
		
			
	}
	
	
}
