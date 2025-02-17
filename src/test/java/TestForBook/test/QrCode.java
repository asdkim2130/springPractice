package TestForBook.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class QrCode {

    public String solution(int q, int r, String code) {
        String answer = "";

        if(r == 0){
            return code;
        }


        if(code.length() % q == 0 || code.length() % q < r) {
            for (int i = 0; i < code.length() / q; i++) {
                String s = Character.toString(code.charAt(1 + q * i));
                answer += s;
            }
        }
        if(code.length() % q > r){
            for (int i = 0; i < code.length() / q + 1; i++) {
                String s = Character.toString(code.charAt(1 + q * i));
                answer += s;
            }
        }

        return answer;




    }

    @Test
    public void qrCode(){
        int q = 3;
        int r = 1;

        String code = "qjnwezgrpirldywt";
        String result = "jerry";

        String 함수적용 = solution(q, r, code);

        assertThat(함수적용).isEqualTo(result);
    }



}
