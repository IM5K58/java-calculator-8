package calculator.domain;

import java.util.ArrayList;

public class Separator { //구분자 관련 클래스

    ArrayList<String> list = new ArrayList<>(); //구분자 저장
    public void add(String sep){ //list에 구분자 추가
        this.list.add(sep);
    }

    public ArrayList<String> getList(){ //list 가져오기
        return this.list;
    }


}
