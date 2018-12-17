package um.dao;

import java.util.List;

import um.pojo.Admin;

public interface AdminDao {

	public void save(Admin admin);

	public List<Admin> findAll();

	public Admin findById(int id);

	public List<Admin> findByNombre(String nombre);

	public void update(Admin admin);

	public void delete(Admin admin);

}


//It is a design pattern used to create a persistence layer