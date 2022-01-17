package todo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import todo.entity.TodoEntity;

public interface TodoRepository extends CrudRepository<TodoEntity, Integer> {
	List<TodoEntity> findAllByOrderByTodoIdxDesc();	
	
	
}
