# 문자열 덧셈 계산기

# 구현 기능

1. 문자열 입/출력
    - Input : 모든 입력을 받기
    - Output: 모든 출력을 관리

2. 문자열이 기본 구분자,커스텀 구분자,양수로 이루어져있는지 확인
    - InputValidator: 입력 받은 문자열에 대해 유효한지 검사

3. 입력한 문자열에서 구분자를 기준으로 분리한 숫자 추출해서 저장
    - Separator: 기본 구분자와 커스텀 구분자 관리

4. 추출한 숫자들의 합 계산
    - Calculator : 실제 계산과 실행 총괄

# 구조 

- IO
    - Input
    - Output

- domain
    - Calculator
    - InputValidator
    - Separator