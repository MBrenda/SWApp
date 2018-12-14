package um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import um.pojo.Admin;
import um.pojo.Direccion;
import um.service.AdminService;
import um.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private DireccionService direccionService;

	/*
	 * This method the admin corresponding to the idAd is found through the service
	 * and its status is saved. A new instance of address is created to return to
	 * the view. Result brings already loaded addresses. Bring a list of addresses
	 * associated with the idAd
	 */
	@RequestMapping("/direccion/{idAd}")
	private String getAll(Model model, @ModelAttribute("resultado") String resultado, @PathVariable("idAd") int idAd) {

		Admin admin = adminService.findById(idAd);
		model.addAttribute("admin", admin);

		model.addAttribute("direccion", new Direccion());
		model.addAttribute("resultado", resultado);
		model.addAttribute("direcciones", direccionService.findAll(idAd));

		return "direccion";
	}

	// this method saves one or more addresses in the admin that was obtained in the
	// previous controller
	@RequestMapping("/direccion/save")
	public String save(Model model, RedirectAttributes ra, @ModelAttribute("direccion") Direccion direccion,
			@ModelAttribute("admin") Admin admin) {

		direccionService.save(admin, direccion);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");

		return "redirect:/direccion/" + admin.getIdAd();
	}
}
