package service;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);

	public List<String> deleteTodo(String todo);


}