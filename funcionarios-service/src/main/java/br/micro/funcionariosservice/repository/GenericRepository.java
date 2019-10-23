package br.micro.funcionariosservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface GenericRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
	
	default List<T> genericFindAll(){
		
		List<T> target = new ArrayList<>();
		findAll().forEach(target::add);
		
		return target;
	}
	
	default T genericfindById(ID id) {
		return findById(id).orElse(null);
	}
}
