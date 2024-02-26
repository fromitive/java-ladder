# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구사항 해석

1. 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - 사람의 이름은 중복이 되어선 안된다.
    - 이름은 최소 1글자 최대 5글자 까지 부여되어야 한다.
    - 알파뱃 대 소문자로 이루어 진다.

2. 사람 이름은 쉼표(,)를 기준으로 구분한다.
    - 쉼표로 시작하거나 쉼표로 끝내면 예외 발생
    - 쉼표로 나뉘는데, 알파벳 대소문자가 아닌 경우 예외 발생
    - 사람은 최대 10명까지 받을 수 있다.

3. 사다리 높이를 입력할 수 있다.
    - 사다리 높이는 5 이상 10 이하의 정수로 입력해야 한다.
    - 사다리의 폭은 사람들의 수이다.

4. 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    - 사다리의 가로(`-`)는 `최대 이름 길이`로 고정한다.
    - 사람의 이름은 사다리의 세로(`|`) 에 맞춰 정렬한다.
    - 사람의 이름이 `최대 이름 길이`보다 작을경우 다음과 같은 규칙으로 공백을 추가한다.

          ```
          `a`     -> `   a `
          `aa`    -> `  aa `
          `aaa`   -> ` aaa `
          `aaaa`  -> `aaaa `
          `aaaaa` -> `aaaaa`
          ``` 

5. 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
    - `-----` 정보를 `다리`로 정의한다.
    - 다리 1개는 존재하거나 존재하지 않는 정보를 가지고 있다.

6. 사용자 입력 중 예외가 발생할 경우, 예외 발생 원인을 출력한 뒤, 처음부터 다시 입력받는다.

7. 사다리 결과를 출력해야 한다.
    - 사다리 결과는 최소 2개 최대 10개를 받을 수 있다.
    - 사다리 결과는 공백이 포함될 수 없다.

8. 사다리 게임 결과를 생성해야 한다.
    - 사다리 결과와 참여자 이름의 개수는 동일해야 한다.
    - 참여자 이름으로 사다리 결과를 반환해야 한다.

9. 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

10. 사다리 결과를 입력받아야 한다.
    - 사다리 결과는 콤마로 구분한다.
    - 사다리 결과에 앞 또는 뒤에 콤마가 있을 경우 예외를 발생시킨다.

## 기능 목록

- [x] 사람 이름 입력 기능
    - [x] 사람 이름 길이 검증 기능
    - [x] 사람 이름 문자 검증 가능
- [x] 사람 생성 기능
    - [x] 사람 이름 중복 검증 기능
    - [x] ","로 구분된 사람 이름 입력 기능
    - [x] 사람 이름 개수 검증 기능
- [x] 사다리 높이 입력 기능
    - [x] 사다리 높이 검증 기능
- [x] 사다리 생성 기능
    - [x] 사다리 높이 지정 기능
    - [x] 사다리 전체 폭 지정 기능
    - [x] 세로 라인 생성 기능
    - [x] 가로 라인 생성 기능
- [x] 사람 이름, 사다리 출력 기능
    - [x] 사람 이름 출력 기능
    - [x] 사다리 출력 기능
- [x] 입력 예외 처리 기능
- [x] 사다리 결과 생성 기능
    - [x] 결과 반환 기능
    - [x] 결과 길이 검증 기능
    - [x] 결과 문자 검증 기능
- [x] 사다리 결과들 저장 기능
    - [x] 사다리 결과 개수 검증 기능
    - [x] 사다리 결과들 반환 기능
- [x] 사다리 결과들 생성 기능
    - [x] 사다리 결과 입력값 검증 기능
    - [x] 사다리 결과 콤마 구분 기능
- [x] 참여자 위치 변경 기능
    - [x] 위치별 참여자 추출 기능
- [x] 사다리 게임 계산 기능

- [ ] 사다리 게임 결과 생성 기능
    - [ ] 사다리 결과와 이름 개수 일치 여부 검증
    - [ ] 참여자 이름으로 사다리 결과 조회 기능



