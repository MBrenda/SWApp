package um.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.dao.AdminDao;
import um.dao.DireccionDao;
import um.pojo.Admin;
import um.pojo.Direccion;

@Service
public class DireccionService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private DireccionDao direccionDao;

	// Set the administrator and save the address
	public void save(Admin admin, Direccion direccion) {
		direccion.setAdmin(admin);
		direccionDao.save(direccion);

	}

	public List<Direccion> findAll(int idAd) {
		Admin admin = adminDao.findById(idAd);
		return direccionDao.findAll(admin);
	}

}
