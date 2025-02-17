package TestForBook.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest {

    public String solution(String my_string, int s, int e) {

        String answer = "";
        String subString = my_string.substring(s, e);
        String mid_string = "";
        for (int i = my_string.length() - 1; i <= s ; i--) {
             mid_string += subString.charAt(i);

        }

        answer = my_string.substring(0, s) + mid_string + mid_string.substring(e);

        return answer;
    }


    @Test
    public void codingTest(){

        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;
        String result = "ProgrammerS123";

        String 함수적용 = solution(my_string, s, e);

        assertThat(함수적용).isEqualTo(result);

    }

    public int solution2(String[] strArr){

        List<String> strList = Arrays.stream(strArr).collect(Collectors.toList());

        int max = Integer.MIN_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < strList.size(); i++) {
            int length = strList.get(i).length();
            map.put(length, map.getOrDefault(length, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }return max;
    }


    @Test
    public void testMap() {
        String[] strArr = {"a", "bc", "d", "efg", "hi"};
        int result = 2;

        int 함수적용 = solution2(strArr);

        assertThat(함수적용).isEqualTo(result);
    }

    @Test
    public void foo(){
        int result = 2;

        assertThat(result).isEqualTo(2);
    }

}
