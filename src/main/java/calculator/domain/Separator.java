package calculator.domain;

import calculator.domain.InputValidator;

public class Separator { //구분자 관련 클래스

    public String[] separate(String input){ //검증 진행 후 괜찮으면
        InputValidator validator = new InputValidator();
        String default_separator = ",|:";
        String custom_separator = "";

        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            custom_separator = input.substring(2, index);
            input = input.substring(index + 2);
            validator.custom_check(custom_separator);
            default_separator += ("|" + custom_separator);
        } //커스텀 문자열 있으면 추가, 잘못되어있다면 예외처리

        return input.split(default_separator); //분리된 문자열 리턴
    }


}
