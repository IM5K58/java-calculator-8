package calculator.domain;

import java.util.regex.Pattern;

public class Separator { //구분자 관련 클래스

    //pattern도 커스텀 구분자 추가하는거를 하나로 묶어서 클래스를 만들 수 있지 않을까?
    private String pattern = "[,:]";

    public String[] separate(String input){ //문자열을 구분자를 기준으로 분리
        InputValidator validator = new InputValidator();
        return split(input, validator);
    }

    private String[] split(String input, InputValidator validator) {
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            String custom_separator = input.substring(2, index);
            validator.custom_check(custom_separator); //검증하고, 예외상황이면 예외발생하고 종료
            input = input.substring(index + 2);
            pattern += "|" + Pattern.quote(custom_separator);
        }
        return input.split(pattern,-1);
    }
}
