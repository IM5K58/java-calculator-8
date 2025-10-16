package calculator.domain;

import calculator.IO.Input;
import calculator.IO.Output;
import calculator.domain.Separator;
import calculator.domain.InputValidator;

public class Calculator {
    public int Calculate(String input){ //계산 과정 총괄, 검증 후 덧셈 계산 결과 반환

        Separator separator = new Separator();
        InputValidator validator = new InputValidator();

        if(!validator.isRight(input)){
            throw new IllegalArgumentException("잘못된 문자열입니다.");
        }

        int sum = 0;

        separator.add(",");
        separator.add(":");

        // 계산과정 기술

        return sum;

    }

    
    public void run(){ //Application에 들어갈 메소드
        Input input = new Input();
        Output output = new Output();

        output.printStart();
        String newInput = input.newInput();

        try {
            int result = Calculate(newInput);
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            // 계산 도중 발생한 예외 처리
            System.exit(1);
        }

    }
}
