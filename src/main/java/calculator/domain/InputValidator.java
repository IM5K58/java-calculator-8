package calculator.domain;

public class InputValidator { //검증

    public void custom_check(String customSeparator) { //커스텀 구분자 확인
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException(" 커스텀 구분자 설정이 잘못되었습니다.");
        }
    }

    public void isRight(String[] list) { //입력한 문자열이 정상적인지 확인
        only_num_check(list);
        list_check(list);
    }

    private void list_check(String[] list) { //연속된 구분자 있는지 확인
        for(int i = 0; i < list.length; i++){
            if((i >0 && i < list.length-1) && list[i].isEmpty()){
                throw new IllegalArgumentException("구분자가 연속되어 사용되었습니다.");
            }
            String s = list[i].trim();
            sep_check(s);
        }
    }

    private void only_num_check(String[] list) { //숫자만 입력되었는지 검증
        if (list.length == 1 && Integer.parseInt(list[0]) >0){
            throw new IllegalArgumentException("숫자만 입력되었습니다.");
        }
    }

    private void sep_check(String s) { //분리된 문자열이 원하는 형태로 잘 변환될 수 있는지 확인
        if (s.isEmpty()){
            return;
        }
        string_parse_int(s);
    }

    private void string_parse_int(String s) {
        try {
            Integer.parseInt(s);
            if (Integer.parseInt(s) < 0) {
                throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정의되지 않은 구분자가 사용되었습니다.");
        }
    }

    public boolean isZero(String input) {
        if (input == null || input.isEmpty()){
            return true;
        }
        return false;
    }
}


