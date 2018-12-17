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

	// this method returns a spring form
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {

		Admin admin = new Admin();

		model.addAttribute("admin", admin);
		
		model.addAttribute("resultado", resultado);

		List<Admin> admins = adminService.findAll();
		model.addAttribute("admins", admins);

		return "admin";
	}

	// this method receive the spring form
	// this method save the data from the spring form
	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String HandleAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra) {

		adminService.saveOrUpdate(adminForm);
		ra.addFlashAttribute("resultado", "Cambios realizados con EXITO");

		return "redirect:/admin";
	}

	// this method update an admin by id
	@RequestMapping("/admin/{idAd}/update")
	private String showUpdate(Model model, @PathVariable("idAd") int id) {

		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);

		return "admin";
	}

	// this method delete an admin by id
	@RequestMapping("/admin/{idAd}/delete")
	private String delete(@PathVariable("idAd") int idAd, RedirectAttributes ra) {

		adminService.delete(idAd);
		ra.addFlashAttribute("resultado", "Cambios realizados con EXITO");

		return "redirect:/admin";
	}
}
