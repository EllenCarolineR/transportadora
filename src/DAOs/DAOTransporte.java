package DAOs;


import Entidades.Transporte;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOTransporte extends DAOGenerico<Transporte> {

    public DAOTransporte() {
        super(Transporte.class);
    }

    public int autoIdTransporte() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTransporte) FROM Transporte e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Transporte> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Transporte e WHERE e.origemDestino LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Transporte> listById(int id) {
        return em.createQuery("SELECT e FROM Transporte e WHERE e.idCaminhao = :id").setParameter("id", id).getResultList();
    }

    public List<Transporte> listInOrderNome() {
        return em.createQuery("SELECT e FROM Transporte e ORDER BY e.origemDestino").getResultList();
    }

    public List<Transporte> listInOrderId() {
        return em.createQuery("SELECT e FROM Transporte e ORDER BY e.idCaminhao").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Transporte> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCaminhaoIdCaminhao()+ "-" + lf.get(i).getOrigemDestino());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOTransporte daoTransporte = new DAOTransporte();
        List<Transporte> listaTransporte = daoTransporte.list();
        for (Transporte transporte : listaTransporte) {
            System.out.println(transporte.getCaminhaoIdCaminhao()+ "-" + transporte.getOrigemDestino());
        }
    }}
