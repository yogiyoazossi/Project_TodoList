package todo.controller;

import todo.service.TodoService;
import todo.entity.TodoEntity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TodoService todoService;


	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home() {
		return "Hello";
	}

	// 전체 목록 조회 (완료)
    @CrossOrigin(origins="*")
	@RequestMapping(value = "/lists", method=RequestMethod.GET)
	public List<TodoEntity> selectTodoList() throws Exception {
		List<TodoEntity> list = todoService.selectTodoList();
		return list;
	}
    
	// 게시물 쓰기 (완료)
    @CrossOrigin(origins="*")
	@RequestMapping(value = "/post", method=RequestMethod.POST)
	public void saveTodo(@RequestBody TodoEntity todoEntity) throws Exception {
		todoService.saveTodo(todoEntity);
		
	}
    
	// 게시물 삭제 
    @CrossOrigin(origins="*")
	@RequestMapping(value = "/delete/{todoIdx}", method=RequestMethod.DELETE)
	public void deleteTodo(@PathVariable("todoIdx") Integer todoIdx) throws Exception {
		todoService.deleteTodo(todoIdx);
	}
    
	// todoContent 게시물 수정
    @CrossOrigin(origins="*")
	@RequestMapping(value = "/update/{todoIdx}", method=RequestMethod.PUT)
    public TodoEntity updateTodo(@PathVariable Integer todoIdx, @RequestBody TodoEntity todoEntity) throws Exception {
    	todoEntity.setTodoIdx(todoIdx);
		return todoService.updateTodo(todoEntity);
	}
    
    // todoUpdatedDatetime로 정렬
    @CrossOrigin(origins="*")
    @RequestMapping(value = "/lists/updatedtime", method=RequestMethod.GET)
    public List<TodoEntity> selectTodoListOrderByUpdateDatetime() throws Exception {
    	List<TodoEntity> list = todoService.selectTodoListOrderByUpdateDatetime();
    	return list;
    }
    
    // todoImportant=true 만 표시
    @CrossOrigin(origins="*")
    @RequestMapping(value = "/lists/important", method=RequestMethod.GET)
    public List<TodoEntity> selectTodoListOrderByImportant() throws Exception {
    	List<TodoEntity> list = todoService.selectTodoListOrderByImportant();
    	return list;
    }
    
    
    // todoCompleted=true 만 표시
    @CrossOrigin(origins="*")
    @RequestMapping(value = "/lists/completed", method=RequestMethod.GET)
    public List<TodoEntity> selectTodoListOrderByCompleted() throws Exception {
    	List<TodoEntity> list = todoService.selectTodoListOrderByCompleted();
    	return list;
    }
}