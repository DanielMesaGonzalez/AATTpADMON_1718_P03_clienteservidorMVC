package org.AATTAA.DNIE;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.AATTAA.DNIE.UsuarioDAOInterface;
import org.AATTAA.DNIE.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UsuarioDAOInterface dao;  //Declaramos el objeto beans (Definido en el servlet-context.xml).
	private ObtenerDatos od=new ObtenerDatos();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	
	/**
	 * Respuesta del servidor GET al accceder a la URL mostrando la página principal.
	 * @param locale
	 * @param model
	 * @return vista que se devuelve al cliente
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String home(Locale locale, Model model) {
		
		return "index"; // Te envía a la página principal
	}
	
	/**
	 * 
	 * Método para comprobar si un usuario está registrado mediante su NIF y su NICK, 
	 * en caso de no estarlo  lo redirecciona al NoExiste.jsp(Posibilidad de registrarte), 
	 * y en caso contrario al Existe.jsp (Muestra los datos del usuario guardados en la BBDD).
	 * 
	 * @param request Object de peticion
	 * @param nick nick del usuario creado en el registro
	 * @param nif contraseña del usuario
	 * @param req Object de peticion
	 * @param locale parametro de Spring
	 * @param model parametro de la vista en Spring
	 * @return vista que se devuelve al cliente
	 */
	@RequestMapping(value = "/CompruebaBBDD", method = RequestMethod.POST)
	public String sesion(HttpServletRequest request, @RequestParam("nombre") String nick,@RequestParam("nif") String nif,HttpServletRequest req,Locale locale, Model model) {
		HttpSession sesion = request.getSession();
		Usuario db= new Usuario();
		
		if (dao.BuscarUsuario(nif,nick)==null) {
			return "NoExiste";
		
			}else { 
				Usuario user=dao.BuscarUsuario(nif,nick);
		       sesion.setAttribute("nusuario", user);
		       request.setAttribute("nusuario", user);

				
				return "Existe";
			}
	}
	
	
	/**
	 * Método encargado de registrar al nuevo usuario mediante la lectura de su DNIe.
	 * El método recoge sus datos y los guarda en un objeto nusuario. Comprueba que se ha introducido una tarjeta, en caso contrario lo notifica y lo redirecciona a la página principal.
	 * 
	 * @param request
	 * @param locale
	 * @param model
	 * @return vista que se devuelve al cliente
	 * @exception La excepción recogerá el error,en el caso de que no se detecte en el tarjetero el DNI y devolvera a la vista home
	 */
	@RequestMapping(value = "/Registro", method = RequestMethod.POST)
	public String registropost(HttpServletRequest request,Locale locale, Model model) {
		HttpSession sesion = request.getSession();
		try {
	    Usuario user=od.LeerNIF();
		
	    String nickname=user.getNombre().substring(0,1)+ user.getApellido1()+user.getApellido2().substring(0,1);
		   user.setNick(nickname);
	    if (dao.BuscarUsuario(user.getNif(),user.getNick())==null) {  
	    	dao.InsertaUsuario(user);
	    	model.addAttribute("nick", "Tu nickname será:"+nickname);
		    sesion.setAttribute("nusuario", user);
		    request.setAttribute("nusuario", user);	    

		    return "Existe";	
	    }
	   
	    else   model.addAttribute("yaExiste", "Ese usuario ya está registrado, puedes logearte con tus datos"); 
	    return "index";
    
	}catch(Exception e) {
		model.addAttribute("yaExiste", "No ha insertado ninguna tarjeta");
	}
		return "index";
	}
		

}
