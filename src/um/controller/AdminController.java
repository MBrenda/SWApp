package um.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import um.pojo.Admin;
import um.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	// quiero que este controlador se comunica con la vista que retorna para eso uso
	// la interfaz Model en spring
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {

		// la primer clave admin el que indiqe en commandName en admin.jsp y el otro
		// valor admin que estoy pasando es una nueva instancia vacia de mi pojo admin
		Admin admin = new Admin();

		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);

		List<Admin> admins = adminService.findAll();
		model.addAttribute("admins", admins);

		return "admin";
	}

	// va a obedecer a admin/save siempre y cuando sea una petision POST
	// vamos a redirigir un administrador para no meter basura a la bd
	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String HandleAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra) {

		adminService.saveOrUpdate(adminForm);
		// resultado es un parametro en el modelo que va a ser mostrado en el
		// controlador /admin
		ra.addFlashAttribute("resultado", "Cambios realizados con EXITO");
		// en vez de retorna una vista logica voy a retornar una DIRECCION
		return "redirect:/admin";
	}

	@RequestMapping("/admin/{idAd}/update")
	// para leer el idAd que es un parametro dinamico se usa la sgte anotacion
	private String showUpdate(Model model, @PathVariable("idAd") int id) {

		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);
		
		return "admin";
	}

	@RequestMapping("/admin/{idAd}/delete")
	private String delete(@PathVariable("idAd") int idAd, RedirectAttributes ra) {
		
		adminService.delete(idAd);
		ra.addFlashAttribute("resultado", "Cambios realizados con EXITO");
		
		return "redirect:/admin";
	}
}
