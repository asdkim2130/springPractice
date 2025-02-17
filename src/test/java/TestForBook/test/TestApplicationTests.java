package TestForBook.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

	public String[] solution(String[] todo_list, boolean[] finished) {

		HashMap<String, Boolean> todoList = new HashMap<>();
		for (int i = 0; i < todo_list.length; i++) {
			todoList.put(todo_list[i], finished[i]);
		}

		ArrayList<String> todoList_true = new ArrayList<>();
		for (Map.Entry<String, Boolean> entry : todoList.entrySet()) {
			if(entry.getValue().equals(true)){
				todoList_true.add(entry.getKey());
			}
		}

		String[] answer = {};
		answer = todoList_true.toArray(new String[0]);

		return answer;
	}

	@Test
	public void 테스트() {
		String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
		boolean[] finished = {true, false, true, false};

		String[] 함수적용 = solution(todo_list, finished);
		String[] 결과값 = {"practiceguitar", "studygraph"};

		assertThat(함수적용).isEqualTo(결과값);

	}
}
