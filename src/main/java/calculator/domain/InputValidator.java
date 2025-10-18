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

        //그러니께, 빈 문자열을 받은게 맨 앞이나 맨 뒤에 있으면 괜찮은데, 중간에 껴있으면 그것은 문제올시다.
        //enhanced for문 말고 그냥 for로 교체 필요
        for (String s : list) {
            s = s.trim();
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


