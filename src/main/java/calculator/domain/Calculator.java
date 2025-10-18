package calculator.domain;

import calculator.IO.Input;
import calculator.IO.Output;
import java.util.Arrays;

public class Calculator {
    private int sum;
    
    public Calculator() {
        this.sum = 0;
    }

    public void Calculate(String input){ //계산 과정 총괄, 검증 후 덧셈 계산 결과 반환
        Separator separator = new Separator();
        InputValidator validator = new InputValidator();
        if(validator.isZero(input)){
            return;
        }
        
        String[] sep_list = separator.separate(input); //분리
        validator.isRight(sep_list); //검증
        System.out.println(Arrays.toString(sep_list)); //분리 잘됐는지 확인용 배열 출력

        for(String s : sep_list){ //덧셈 진행
            if (s.isEmpty()) continue;
            sum += Integer.parseInt(s.trim());
        }

    }
    
    public void run(){ //Application에 들어갈 메소드
        Input input = new Input();
        Output output = new Output();

        output.printStart();
        String newInput = input.newInput();

        Calculate(newInput);
        output.printResult(sum);  // 성공한 경우에만 출력


    }
}
