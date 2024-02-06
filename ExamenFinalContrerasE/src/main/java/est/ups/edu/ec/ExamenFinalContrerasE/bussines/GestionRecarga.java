
package est.ups.edu.ec.ExamenFinalContrerasE.bussines;

import java.util.List;

import est.ups.edu.ec.ExamenFinalContrerasE.model.Recarga;
import est.ups.edu.ec.ExamenFinalContrerasE.DAO.RecargaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject; 

@Stateless
public class GestionRecarga {

    @Inject
    private RecargaDAO recargaDao;

    public void guardarRecarga(Recarga recarga) {
        Recarga rec = recargaDao.read(recarga.getId());
        if (rec != null)
            recargaDao.update(recarga);
        else
            recargaDao.insert(recarga);
    }

    public void actualizarRecarga(Recarga recarga) throws Exception {
        Recarga rec = recargaDao.read(recarga.getId());
        if (rec != null)
            recargaDao.update(recarga);
        else
            throw new Exception("Cliente no existe");
    }

    public Recarga getRecargaPorId(int id) throws Exception {
        return recargaDao.getRecargaPorId(id);
    }

    public void borrarRecarga(int id) {
        recargaDao.remove(id);
    }

    public List<Recarga> getRecargas() {
        return recargaDao.getAll();
    }

    @PostConstruct
    public void init() {
        System.out.println("************* RECARGAS ELECTRONICAS  **************");
    }
}
