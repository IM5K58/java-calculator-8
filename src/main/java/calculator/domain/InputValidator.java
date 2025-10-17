package calculator.domain;

import calculator.domain.Separator;
public class InputValidator { //검증

    public void custom_check(String customSeparator){
        if(customSeparator.length() != 1){
            throw new IllegalArgumentException(" 커스텀 문자 설정이 잘못되었습니다.");
        }
    }

    public void isRight(String[] list){ //입력한 문자열이 정상적인지 확인

        for(String s : list){
            s = s.trim();
            try{
                Integer.parseInt(s);
                if(Integer.parseInt(s) < 0) throw new IllegalArgumentException("잘못된 문자열이 입력되었습니다.");

            }catch(NumberFormatException e){
                throw new IllegalArgumentException("입력되지 않은 구분자입니다.");
            }
        }
    }
}
