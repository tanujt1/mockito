package service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TodoServiceTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Mock
	TodoService todoService;

	@Test
	public void test() {

		List<String> dummyList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance", "Learn to Dance");
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
		when(todoService.retrieveTodos("DUMMY")).thenReturn(dummyList);
		// or
		given(todoService.retrieveTodos("DUMMY")).willReturn(dummyList); // BDD

		/* ------------------------------------------------------------------------------- */
		// calling filter(String) method of TodoBusinessImpl
		List<String> filteredfList = todoBusinessImpl.filter("DUMMY");

		assertEquals(2, filteredfList.size());
		// or
		assertThat(filteredfList.size(), is(2)); // BDD

		verify(todoService).retrieveTodos("DUMMY");
		/* ------------------------------------------------------------------------------- */

		/* ------------------------------------------------------------------------------- */
		// calling another deleteTodosNotRelatedToSpring(String) method of
		// TodoBusinessImpl class
		todoBusinessImpl.deleteTodosNotRelatedToSpring("DUMMY");

		verify(todoService, times(2)).deleteTodo("Learn to Dance");
		// or
		then(todoService).should(times(2)).deleteTodo("Learn to Dance");

		verify(todoService, atLeast(1)).deleteTodo("Learn to Dance");
		// or
		then(todoService).should(atLeast(1)).deleteTodo("Learn to Dance");

		verify(todoService, never()).deleteTodo("Learn Spring MVC");
		// or
		then(todoService).should(never()).deleteTodo("Learn Spring MVC");
		
		/* ------------------------------------------------------------------------------- */
		
		// Using ArgumentCaptor
	 
		/*todoBusinessImpl.deleteTodosNotRelatedToSpring("DUMMY");
		verify(todoService, times(2)).deleteTodo(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(),is("Learn to Dance")); // if only one deletion was there
		assertThat(argumentCaptor.getAllValues().size(),is(2));*/
		

	}

}
