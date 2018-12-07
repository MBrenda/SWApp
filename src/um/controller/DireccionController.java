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
	
	@RequestMapping("/direccion/{idAd}")
	private String getAll(Model model, @ModelAttribute("resultado") String resultado, @PathVariable("idAd") int idAd){
		
		Admin admin = adminService.findById(idAd);
		model.addAttribute("admin", admin);
		
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("resultado", resultado);
		model.addAttribute("direcciones", direccionService.findAll(idAd));
		
		return "direccion";
	}
	
	//el direccion del model hace referencia al commanname del jsp y el otro a un identificador para este metodo
	@RequestMapping("/direccion/save")
	public String save(Model model, RedirectAttributes ra,
			@ModelAttribute("direccion") Direccion direccion,
			@ModelAttribute("admin") Admin admin) {
		
		direccionService.save(admin, direccion);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");
		
		
		return "redirect:/direccion/" + admin.getIdAd();
	}
}
