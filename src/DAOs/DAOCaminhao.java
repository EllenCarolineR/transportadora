package DAOs;


import Entidades.Caminhao;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOCaminhao extends DAOGenerico<Caminhao> {

    public DAOCaminhao() {
        super(Caminhao.class);
    }

    public int autoIdCaminhao() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCaminhao) FROM Caminhao e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Caminhao> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Caminhao e WHERE e.cavaloIdCavaloK LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Caminhao> listById(int id) {
        return em.createQuery("SELECT e FROM Caminhao e WHERE e.idCaminhao = :id").setParameter("id", id).getResultList();
    }

    public List<Caminhao> listInOrderNome() {
        return em.createQuery("SELECT e FROM Caminhao e ORDER BY e.cavaloIdCavaloK").getResultList();
    }

    public List<Caminhao> listInOrderId() {
        return em.createQuery("SELECT e FROM Caminhao e ORDER BY e.idCaminhao").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Caminhao> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdCaminhao() + "-" + lf.get(i).getCavaloIdCavalo());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOCaminhao daoCaminhao = new DAOCaminhao();
        List<Caminhao> listaCaminhao = daoCaminhao.list();
        for (Caminhao caminhao : listaCaminhao) {
            System.out.println(caminhao.getIdCaminhao() + "-" + caminhao.getCavaloIdCavalo());
        }
    }}
