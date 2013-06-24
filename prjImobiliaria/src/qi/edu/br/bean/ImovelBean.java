package qi.edu.br.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import qi.edu.br.dao.ClienteDao;
import qi.edu.br.dao.FuncionarioDao;
import qi.edu.br.dao.ImovelDao;
import qi.edu.br.dao.TipoImovelDao;
import qi.edu.br.model.Cliente;
import qi.edu.br.model.Funcionario;
import qi.edu.br.model.Imovel;
import qi.edu.br.model.TipoImovel;

@Stateless
@Local
public class ImovelBean {

	public void update(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			imovelDao.atualizar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			imovelDao.deletar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void save(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			imovelDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Imovel find(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			Imovel c = imovelDao.consultar(obj);
			return c;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<SelectItem> getListaCliente() throws Exception { //
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> resultado = (List<Cliente>) clienteDao.findAll();

        for (Cliente cliente : resultado) {
            SelectItem item = new SelectItem(cliente.getId(), cliente.getNome());
            lista.add(item);
        }
        return lista;
    }
	
	public List<SelectItem> getListaFuncionario() throws Exception { 
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
        FuncionarioDao funcDao = new FuncionarioDao();
        List<Funcionario> resultado = (List<Funcionario>) funcDao.findAll();

        for (Funcionario funcionario : resultado) {
            SelectItem item = new SelectItem(funcionario.getId(), funcionario.getNome());
            lista.add(item);
        }
        return lista;
    }
	
	public List<SelectItem> getListaTipoImovel() throws Exception { 
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
        TipoImovelDao tipoImovelDao = new TipoImovelDao();
        List<TipoImovel> resultado = (List<TipoImovel>) tipoImovelDao.findAll();

        for (TipoImovel tipoImovel : resultado) {
            SelectItem item = new SelectItem(tipoImovel.getId(), tipoImovel.getDescricao());
            lista.add(item);
        }
        return lista;
    }
}
