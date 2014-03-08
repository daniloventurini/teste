/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import dao.DaoGenerico;
import dao.DaoHibernateGenerico;
import entidades.Grupo;
import java.util.List;

/**
 *
 * @author DANILO
 */
public class GrupoControle {

    private DaoGenerico dao;
    private static GrupoControle instance;

    private GrupoControle() {
        dao = new DaoHibernateGenerico();

    }

    public static synchronized GrupoControle getInstance() {
        if (instance == null) {
            instance = new GrupoControle();
        }
        return instance;
    }

    public Grupo salvar(Grupo objeto) {

        try {
            return (Grupo) dao.save(objeto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void excluir(Grupo objeto) {
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

    public List listaTodos() {
        try {
            return dao.list(Grupo.class);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Grupo.class, atributo, criterio);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Grupo> montalista(Integer tipoconsulta, String filtro) {
        String atributo = null;
        if (tipoconsulta == 0) {
            atributo = "nome";

        }else if(tipoconsulta == 1){
        atributo="descricao";

        }
        return listaCriterio(atributo, filtro);
    }
}
