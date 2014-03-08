/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.sun.org.apache.bcel.internal.generic.F2I;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import dao.DaoGenerico;
import dao.DaoHibernateGenerico;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author DANILO
 */
public class UsuarioControle {

    private DaoGenerico dao;
    private static UsuarioControle instance;

    public UsuarioControle() {
        dao = new DaoHibernateGenerico();

    }

    public static synchronized UsuarioControle getInstance() {
        if (instance == null) {
            instance = new UsuarioControle();
        }
        return instance;


    }

    public Usuario salvar(Usuario objeto) {
        try {
            return (Usuario) dao.save(objeto);


        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    public void excluir(Usuario objeto) {
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

    public Usuario carregar(Long id) {
        try {
            return (Usuario) dao.getById(id, Usuario.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Usuario.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Usuario.class, atributo, criterio);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public List<Usuario> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;
        if (tipoConsulta == 0) {
            atributo = "login";
        } 
        return listaCriterio(atributo, filtro);
    }
}
