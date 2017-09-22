package service;

import java.util.Arrays;
import java.util.List;

public class TodoServiceImpl implements TodoService {

	private List<String> list = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

	@Override
	public List<String> retrieveTodos(String user) {

		return list;
	}

	@Override
	public List<String> deleteTodo(String todo) {

		for (String givenTodo : list) {
			if (givenTodo.contains(todo)) {
				list.remove(todo);
			}
		}
		return list;
	}

}
