package repository;

import java.util.List;

import models.Livro;

public interface ILivroRepository {
	
	public Boolean insert(Livro livro);
	
	public Boolean update(Livro product);
	
	public Integer deleteById(Integer id);
	
	public List<Livro> findAll();
	
	public Livro findById(Integer id);
	
	public Livro findByName(String name);

}
