package service;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> filter(String user) {
		List<String> filteredTodos = new ArrayList<>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}

}
