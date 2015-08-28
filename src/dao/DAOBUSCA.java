package dao;

import java.util.List;

public interface DAOBUSCA<T> {
	
	// este é o DAO, o nome esta DAOBUSCA porque eu não tive ideia de nome melhor 
	
	void inserir (T entidade);
	void alterar (T entidade);
	void excluir(T entidade);
	
	T buscar(Integer id);

	List<T> todos();

		
	}	


