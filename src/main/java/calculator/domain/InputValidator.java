package calculator.domain;

import calculator.domain.Separator;
public class InputValidator { //검증

    public void custom_check(String customSeparator){
        if(customSeparator.length() != 1){
            throw new IllegalArgumentException(" 커스텀 문자 설정이 잘못되었습니다.");
        }
    }

    public boolean isRight(String input){ //입력한 문자열이 정상적인지 확인
        Separator separator = new Separator();

        //문자열 전체를 체크할 것인가?
        return false;
    }
}
