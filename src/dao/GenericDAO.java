package dao;

import java.util.List;

public interface GenericDAO<T> {
	
	// este � o DAO, o nome esta DAOBUSCA porque eu n�o tive ideia de nome melhor 
	
	void inserir (T entidade);
	void alterar (T entidade);
	void excluir(T entidade);
	
	T buscar(Integer id);

	List<T> todos();

		
	}	


