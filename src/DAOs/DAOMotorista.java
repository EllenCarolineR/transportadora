package DAOs;


import Entidades.Motorista;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOMotorista extends DAOGenerico<Motorista> {

    public DAOMotorista() {
        super(Motorista.class);
    }

    public int autoIdMotorista() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idMotorista) FROM Motorista e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Motorista> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Motorista e WHERE e.nomeMotorista LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Motorista> listById(int id) {
        return em.createQuery("SELECT e FROM Motorista e WHERE e.idMotorista = :id").setParameter("id", id).getResultList();
    }

    public List<Motorista> listInOrderNome() {
        return em.createQuery("SELECT e FROM Motorista e ORDER BY e.nomeMotorista").getResultList();
    }

    public List<Motorista> listInOrderId() {
        return em.createQuery("SELECT e FROM Motorista e ORDER BY e.idMotorista").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Motorista> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdMotorista() + "-" + lf.get(i).getNomeMotorista());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOMotorista daoMotorista = new DAOMotorista();
        List<Motorista> listaMotorista = daoMotorista.list();
        for (Motorista motorista : listaMotorista) {
            System.out.println(motorista.getIdMotorista() + "-" + motorista.getNomeMotorista());
        }
    }}
