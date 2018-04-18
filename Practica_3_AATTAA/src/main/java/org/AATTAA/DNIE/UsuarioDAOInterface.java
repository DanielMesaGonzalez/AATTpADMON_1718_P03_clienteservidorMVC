package org.AATTAA.DNIE;

import java.util.List;


public interface UsuarioDAOInterface {
	public void InsertaUsuario(Usuario usuario);
	public List<Usuario> leeUsuario();
	public Usuario BuscarUsuario(String dni);
	

}
