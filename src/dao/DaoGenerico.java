package dao;

import entidades.Compra;
import entidades.ContasPagar;
import entidades.ContasReceber;
import entidades.Venda;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface DaoGenerico {

    public Object save(Object objeto);

    public void delete(Object objeto);

    public List list(Class clazz);

    public List listCriterio(Class clazz, String atributo, String criterio);

    public Object getById(Serializable id, Class clazz);

    public List<ContasPagar> listCriterioObjetoPagar(Class<ContasPagar> aClass, String filtro);

    public List<ContasReceber> listCriterioObjetoReceber(Class<ContasReceber> aClass, String filtro);

    public List listCriterioVenda(Class<Venda> aClass, Date data1, Date data2, String cliente);

    public List listCriterioCompra(Class<Compra> aClass, Date data1, Date data2, String cliente);
}
