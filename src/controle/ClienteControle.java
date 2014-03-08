/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.sun.org.apache.bcel.internal.generic.F2I;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import dao.DaoGenerico;
import dao.DaoHibernateGenerico;
import entidades.Cliente;
import java.util.List;

/**
 *
 * @author DANILO
 */
public class ClienteControle {

    private DaoGenerico dao;
    private static ClienteControle instance;

    public ClienteControle() {
        dao = new DaoHibernateGenerico();

    }

    public static synchronized ClienteControle getInstance() {
        if (instance == null) {
            instance = new ClienteControle();
        }
        return instance;


    }

    public Cliente salvar(Cliente objeto) {
        try {
            return (Cliente) dao.save(objeto);


        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    public void excluir(Cliente objeto) {
        try {
            dao.delete(objeto);
        } catch (Exception e) {
            if (e.getMessage().contains("org.hibernate.exception.ConstrainViolationException")) {
                throw new RuntimeException(e);

            } else {
                throw new RuntimeException(e);
            }
        }

    }

    public Cliente carregar(Long id) {
        try {
            return (Cliente) dao.getById(id, Cliente.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Cliente.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Cliente.class, atributo, criterio);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public List<Cliente> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;
        if (tipoConsulta == 0) {
            atributo = "nome";
        } else if (tipoConsulta == 1) {
            atributo = "cpf";
        }else if (tipoConsulta == 2) {
            atributo = "rg";
        }
        return listaCriterio(atributo, filtro);
    }
}
