package todo.controller;

import todo.service.TodoService;
import todo.entity.TodoEntity;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class TodoController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TodoService todoService;


	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home() {
		return "Hello";
	}

	// 전체 목록 조회
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public List<TodoEntity> selectTodoList() throws Exception {
		List<TodoEntity> list = todoService.selectTodoList();
		return list;
	}
	
	// todoIdx로 조회, 아이디 별 조회
	@RequestMapping(value = "/list/{todoIdx}", method=RequestMethod.GET)
	public Optional<TodoEntity> detailTodoList(@PathVariable("todoIdx") int todoIdx ) throws Exception {
		Optional<TodoEntity> list = todoService.detailTodoList(todoIdx);
		return list;
	}
	
	// 날짜별 조회
	
	// todoIdx로 수정
//	@RequestMapping(value = "/post/{todoIdx}", method=RequestMethod.PUT)
//	public String updateTodo(@PathVariable("todoIdx") int todoIdx, @RequestBody TodoEntity todoEntity, RedirectAttributes redirectAttributes) throws Exception {
//		
//		todoEntity.setTodoIdx(todoIdx);
//		todoService.updateTodo(todoEntity);
//		
//		redirectAttributes.addAttribute("idx", todoEntity.getTodoIdx());
//		return "redirect:/list/{idx}";
//	}
	
	// 중요 파일 활성화, todoImportance = 1
	@RequestMapping(value = "/post/{todoIdx}/enable", method=RequestMethod.PUT)
	public String importanceEnableTodo(@PathVariable("todoIdx") int todoIdx, @RequestBody TodoEntity todoEntity, RedirectAttributes redirectAttributes) throws Exception {
		todoService.updateTodo(todoEntity);
		
		redirectAttributes.addAttribute("todoidx", todoEntity.getTodoIdx());
		return "redirect:/list/{todoidx}";
	}
	
	// 중요 파일 비활성화, todoImportance = 0
	
	// 게시물 쓰기
	@RequestMapping(value = "/post", method=RequestMethod.POST)
	public String saveTodo(@RequestBody TodoEntity todoEntity) throws Exception {
		todoService.saveTodo(todoEntity);
		return "redirect:/list";
	}

	
	// 완료표시
}
