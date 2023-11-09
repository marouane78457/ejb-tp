package sessions;

import java.util.List;

import dao.IDao;
import entities.Filiere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FliereService implements IDao<Filiere>{
	
	@PersistenceContext
	private EntityManager fl;

	@Override
    @jakarta.annotation.security.PermitAll
	public boolean create(Filiere o) {
		fl.persist(o);
		return false;
	}

	@Override
	public boolean update(Filiere o) {
		fl.merge(o);
		return false;
	}

	@Override
	public boolean delete(Filiere o) {
		fl.remove(o);
		return false;
	}

	@Override
	public Filiere findById(int id) {
		return fl.find(Filiere.class, id);
	}

	@Override
	public List<Filiere> findAll() {
		jakarta.persistence.Query query = fl.createQuery("select f from Filiere f");
		return query.getResultList();
	}

}
