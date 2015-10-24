package dao;

import java.util.List;

public interface GenericDAO<T> {	
	void inserir (T entidade);
	void alterar (T entidade);
	void excluir(T entidade);
	
	T buscar(Integer id);
	Integer maiorId();
	List<T> todos();

		
	}	


