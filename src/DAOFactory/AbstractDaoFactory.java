package DAOFactory;

import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.HistoricoDAO;
import dao.ImobiliariaDAO;
import dao.ImovelDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;

public interface AbstractDaoFactory {

	// nesta Interface deve ir todos os nossos ....DAO 
	
	ClienteDAO clienteDAO(); 
	CorretorDAO corretorDAO();
	EnderecoDAO enderecoDAO();
	HistoricoDAO historicoDAO();
	ImobiliariaDAO imobiliariaDAO(); 
	ImovelDAO imovelDAO();
	PessoaDAO pessoaDAO();
	UsuarioDAO usuarioDAO();
	
	
}
