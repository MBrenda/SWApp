package um.dao;

import java.util.List;

import um.pojo.Admin;
import um.pojo.Direccion;

public interface DireccionDao {

	public void save(Direccion direccion);
	public List<Direccion> findAll(Admin admin);
}
