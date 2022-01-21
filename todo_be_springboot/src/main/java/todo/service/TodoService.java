package todo.service;

import java.util.List;
import java.util.Optional;

import todo.entity.TodoEntity;

public interface TodoService {
	List<TodoEntity> selectTodoList() throws Exception;
	
	public Optional<TodoEntity> detailTodoList(Integer todoIdx) throws Exception;
	
	void saveTodo(TodoEntity todoEntity) throws Exception;
	
	void deleteTodo(Integer todoIdx) throws Exception;
	
//	void updateTodo(Integer todoIdx, String todoConetnt) throws Exception;
	public TodoEntity updateTodo(TodoEntity todoEntity) throws Exception;
}