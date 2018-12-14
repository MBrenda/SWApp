package um.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.dao.AdminDao;
import um.pojo.Admin;

@Service
public class AdminService {


	@Autowired
	private AdminDao adminDao;

	//this method save an admin in db
	public void save(Admin admin) {

		admin.setFechaCreacion(new Timestamp(new Date().getTime()));

		adminDao.save(admin);
	}

	// me va a devolver el metodo del dao
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	public Admin findById(int id) {
		return adminDao.findById(id);
	}

	public void saveOrUpdate(Admin admin) {

		if (admin.getIdAd() == 0) {
			// insert
			admin.setFechaCreacion(new Timestamp(new Date().getTime()));
			adminDao.save(admin);
		} else {
			// update
			adminDao.update(admin);
		}

	}

	public void delete(int idAd) {
		Admin admin = adminDao.findById(idAd);
		adminDao.delete(admin);
	}

}
