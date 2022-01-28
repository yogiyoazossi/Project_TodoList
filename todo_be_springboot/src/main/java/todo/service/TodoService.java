package todo.service;

import java.util.List;
import java.util.Optional;

import todo.entity.TodoEntity;

public interface TodoService {
	List<TodoEntity> selectTodoList() throws Exception;
	
	public Optional<TodoEntity> detailTodoList(Integer todoIdx) throws Exception;
	
	void saveTodo(TodoEntity todoEntity) throws Exception;
	
	void deleteTodo(Integer todoIdx) throws Exception;

	public TodoEntity updateTodo(TodoEntity todoEntity) throws Exception;
		
	public List<TodoEntity> selectTodoListOrderByUpdateDatetime() throws Exception;
	
	public List<TodoEntity> selectTodoListOrderByImportant() throws Exception;
	
	public List<TodoEntity> selectTodoListOrderByCompleted() throws Exception;
}