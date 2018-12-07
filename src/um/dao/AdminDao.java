package um.dao;

import java.util.List;

import um.pojo.Admin;

public interface AdminDao {

	public void save(Admin admin);

	// creo un metodo que me devuelve una lista de admins
	public List<Admin> findAll();

	// consultas personalizadsa
	public Admin findById(int id);

	public List<Admin> findByNombre(String nombre);

	public void update(Admin admin);

	public void delete(Admin admin);

}
