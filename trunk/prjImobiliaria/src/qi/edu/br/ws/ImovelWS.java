package qi.edu.br.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import qi.edu.br.dao.ImovelDao;
import qi.edu.br.model.Imovel;

@WebService
public class ImovelWS {
	@WebMethod
	public Imovel find(int codigo) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			Imovel c = imovelDao.consultarWS(codigo);
			return c;
		} catch (Exception e) {
			throw e;
		}
	}
}
