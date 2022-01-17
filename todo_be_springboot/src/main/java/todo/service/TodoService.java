package todo.service;

import java.util.List;
import java.util.Optional;

import todo.entity.TodoEntity;

public interface TodoService {
	List<TodoEntity> selectTodoList() throws Exception;
	
	public Optional<TodoEntity> detailTodoList(int todoIdx) throws Exception;
	
	void saveTodo(TodoEntity todoEntity) throws Exception;
	
	void updateTodo(TodoEntity TodoEntity) throws Exception;		
}