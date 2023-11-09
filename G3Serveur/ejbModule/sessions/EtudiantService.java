package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Etudiant;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class EtudiantService implements IDao<Etudiant>, IDaoLocal<Etudiant> {

	@PersistenceContext
	private EntityManager et;
	
	
	@Override
    @jakarta.annotation.security.PermitAll
	public boolean create(entities.Etudiant o) {
		et.persist(o);
		return true;
	}

	@Override
	public boolean update(Etudiant o) {
		return false;
	}

	@Override
	public boolean delete(Etudiant o) {
		et.remove(o);
		return true;
	}

	@Override
	public Etudiant findById(int id) {
		return et.find(Etudiant.class, id);
	}

	@Override 
	@PermitAll
	public List<Etudiant> findAll() {
		jakarta.persistence.Query query = et.createQuery("select e from Etudiant e");
		return query.getResultList();		
	}
	
	

}
