package est.ups.edu.ec.ExamenFinalContrerasE.DAO;

import java.util.ArrayList;
import java.util.List;


import est.ups.edu.ec.ExamenFinalContrerasE.model.Recarga;
import est.ups.edu.ec.ExamenFinalContrerasE.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {

	@PersistenceContext
	 private EntityManager em;
	
    public void insert(Recarga recarga){
        em.persist(recarga);
    }

    public void update(Recarga recarga){
        em.merge(recarga);
    }

    public void remove(int id){
        Recarga recarga = em.find(Recarga.class, id);
        em.remove(recarga);
    }

    public Recarga read(int id){
        Recarga recarga = em.find(Recarga.class, id);
        return recarga;
    }

    public List<Recarga> getAll(){
        String jpql = "SELECT c FROM Cliente c";
        Query q = em.createQuery(jpql, Recarga.class);
        return q.getResultList();
    }

    public Recarga getRecargaPorId(int id){
        String jpql = "SELECT c FROM Cliente c WHERE c.id = :id";
        Query q = em.createQuery(jpql, Recarga.class);
        q.setParameter("id", id);
        List<Recarga> recargas = q.getResultList();
        if(recargas.size() > 0)
            return recargas.get(0);
        return null;
    }
    
        private List<Recarga> recargas;

        public RecargaDAO() {
            recargas = new ArrayList<>();
        }

        public void agregarRecarga(Recarga recarga) {
            recargas.add(recarga);
        }

        public List<Recarga> obtenerRecargas() {
            return recargas;
        }
    }

	
	

