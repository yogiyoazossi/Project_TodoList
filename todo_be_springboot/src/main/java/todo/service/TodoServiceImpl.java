
package todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.entity.TodoEntity;
import todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	
	@Override
	public List<TodoEntity> selectTodoList() throws Exception {
		return todoRepository.findAllByOrderByTodoIdxDesc();
	}	
	
	@Override
	public Optional<TodoEntity> detailTodoList(int todoIdx) throws Exception {
		Optional<TodoEntity> todoEntity = todoRepository.findById(todoIdx);
		return todoEntity;
	}
	
	@Override
	public void saveTodo(TodoEntity todoEntity) throws Exception {
		
		todoRepository.save(todoEntity);
	}
	
	@Override
	public void updateTodo(TodoEntity todoEntity) throws Exception {
		todoRepository.save(todoEntity);
	}
	
}
