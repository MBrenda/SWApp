package um.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("resultado")
public class IndexController {

//	metodo que acepte una peticion http y nos resuelva un nombre logico y el distpacher se encarga de lo demas

//con la anotacion le digo a este metodo que va a tener una peticion http,y la peticion por defecto en este caso es /	

	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Resultado desde Sesion");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) {
		sessionStatus.setComplete(); //limpia todos los atributos de la sesion
		return "about";
	}
	
}	
