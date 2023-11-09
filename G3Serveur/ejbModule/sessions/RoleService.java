package sessions;

import java.util.List;

import dao.IDao;
import entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RoleService implements IDao<Role> {
	@PersistenceContext
	private EntityManager et;
	
	@jakarta.annotation.security.PermitAll
	public boolean create(entities.Role o) {
		et.persist(o);
		return false;
	}

	@Override
	public boolean update(Role o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
