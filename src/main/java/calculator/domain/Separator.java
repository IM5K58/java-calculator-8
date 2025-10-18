package calculator.domain;

import calculator.domain.InputValidator;
import java.util.regex.Pattern;

public class Separator { //구분자 관련 클래스

    public String[] separate(String input){ //검증 진행 후 괜찮으면
        InputValidator validator = new InputValidator();
        String pattern = "[,:]";

        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            String custom_separator = input.substring(2, index);
            validator.custom_check(custom_separator); //검증하고, 예외상황이면 예외발생하고 종료
            input = input.substring(index + 2);
            pattern += "|" + Pattern.quote(custom_separator);

        } //커스텀 문자열 있으면 추가, 잘못되어있다면 예외처리

        return input.split(pattern,-1); //분리된 문자열 리턴
    }
}
