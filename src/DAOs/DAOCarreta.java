package DAOs;


import Entidades.Carreta;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOCarreta extends DAOGenerico<Carreta> {

    public DAOCarreta() {
        super(Carreta.class);
    }

    public int autoIdCarreta() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCarreta) FROM Carreta e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
    
    public String autoIdCarretaString() {
        String a = (String) em.createQuery("SELECT MAX(e.idCarreta) FROM Carreta e ").getSingleResult();
        int x = Integer.valueOf(a) + 1;
        String b = String.valueOf(x);
        if (a != null) {
            return b;
        } else {
            return "1";
        }
    }

    public List<Carreta> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Carreta e WHERE e.capacidadeMax LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Carreta> listById(int id) {
        return em.createQuery("SELECT e FROM Carreta e WHERE e.idCarreta = :id").setParameter("id", id).getResultList();
    }

    public List<Carreta> listInOrderNome() {
        return em.createQuery("SELECT e FROM Carreta e ORDER BY e.capacidadeMax").getResultList();
    }

    public List<Carreta> listInOrderId() {
        return em.createQuery("SELECT e FROM Carreta e ORDER BY e.idCarreta").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Carreta> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdCarreta() + "-" + lf.get(i).getCapacidadeMax());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOCarreta daoCarreta = new DAOCarreta();
        List<Carreta> listaCarreta = daoCarreta.list();
        for (Carreta carreta : listaCarreta) {
            System.out.println(carreta.getIdCarreta() + "-" + carreta.getCapacidadeMax());
        }
    }}
