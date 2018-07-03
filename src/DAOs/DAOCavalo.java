package DAOs;


import Entidades.Cavalo;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOCavalo extends DAOGenerico<Cavalo> {

    public DAOCavalo() {
        super(Cavalo.class);
    }

    public int autoIdCavalo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCavalo) FROM Cavalo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cavalo> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Cavalo e WHERE e.marca LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Cavalo> listById(int id) {
        return em.createQuery("SELECT e FROM Cavalo e WHERE e.idCavalo = :id").setParameter("id", id).getResultList();
    }

    public List<Cavalo> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cavalo e ORDER BY e.marca").getResultList();
    }

    public List<Cavalo> listInOrderId() {
        return em.createQuery("SELECT e FROM Cavalo e ORDER BY e.idCavalo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cavalo> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdCavalo() + "-" + lf.get(i).getMarca());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOCavalo daoCavalo = new DAOCavalo();
        List<Cavalo> listaCavalo = daoCavalo.list();
        for (Cavalo cavalo : listaCavalo) {
            System.out.println(cavalo.getIdCavalo() + "-" + cavalo.getMarca());
        }
    }}
