package calculator.domain;

public class InputValidator { //검증

    public void custom_check(String customSeparator) {
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException(" 커스텀 문자 설정이 잘못되었습니다.");
        }
    }
    public void isRight(String[] list) { //입력한 문자열이 정상적인지 확인
        if (list.length == 1 && Integer.parseInt(list[0]) >0){
            throw new IllegalArgumentException("숫자만 입력되었습니다.");
        }

        //만약 빈 문자열이 맨 끝이나 맨 앞에 온게 아니라면 예외
        for(int i = 0; i < list.length; i++){
            if((i >0 && i < list.length-1) && list[i].isEmpty()){
                throw new IllegalArgumentException("구분자가 연속되어 사용되었습니다.");
            }
            String s = list[i].trim();
            sep_check(s);
        }

    }

    private static void sep_check(String s) {
        if (s.isEmpty()){
            return;
        }
        try {
            Integer.parseInt(s);
            if (Integer.parseInt(s) < 0) throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정의되지 않은 구분자가 사용되었습니다.");
        }
    }
}


