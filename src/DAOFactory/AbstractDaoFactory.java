package DAOFactory;

import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.ImobiliariaDAO;
import dao.ImovelDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;

public interface AbstractDaoFactory {	
	ClienteDAO clienteDAO(); 
	CorretorDAO corretorDAO();
	EnderecoDAO enderecoDAO();
	ImobiliariaDAO imobiliariaDAO(); 
	ImovelDAO imovelDAO();
	PessoaDAO pessoaDAO();
	UsuarioDAO usuarioDAO();
	VendaDAO vendaDAO();
	
	
}
