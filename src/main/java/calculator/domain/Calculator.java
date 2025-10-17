package calculator.domain;

import calculator.IO.Input;
import calculator.IO.Output;
import calculator.domain.Separator;
import calculator.domain.InputValidator;
import java.util.Arrays;

public class Calculator {
    public int Calculate(String input){ //계산 과정 총괄, 검증 후 덧셈 계산 결과 반환

        Separator separator = new Separator();
        InputValidator validator = new InputValidator();
        int sum = 0;

        String[] sep_list = separator.separate(input);


        validator.isRight(sep_list);

        for(String s : sep_list){
            sum += Integer.parseInt(s.trim());
        }
        return sum;

    }

    
    public void run(){ //Application에 들어갈 메소드
        Input input = new Input();
        Output output = new Output();

        output.printStart();
        String newInput = input.newInput();

        int result = Calculate(newInput);
        output.printResult(result);  // 성공한 경우에만 출력


    }
}
