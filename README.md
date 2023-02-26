# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---

## 사다리 게임

### 입력 조건
- 참여자
  - 2명 이상, 30명 이하
  - 이름 중복 불가
  - 이름에 공백이 포함될 시 공백 제거
  - 각 이름은 1자 이상, 5자 이하
  - 이름으로 all, quit 불가 (명령어로 사용되기 때문)
- 보상(실행 결과)
  - 보상의 수는 참여자 수와 동일해야 함
  - 각 보상명은 1자 이상, 5자 이하
- 사다리
  - 높이가 2 이상, 100 이하

### 실행 결과
- 참여자 이름 입력 시 해당 참여자의 결과 출력
- all 입력 시 전체 참여자의 결과 출력
- quit 입력 시 게임 종료 

---

## 기능 목록

- [x]  참여할 사람의 이름을 입력 받는다
    - [x]  쉼표(,)로 구분한다
    - [x]  최대 5글자 까지 부여할 수 있다
    - [x]  이름에 공백에 포함되면 공백을 삭제한다
    - [x]  참여하는 사람 수가 2명 미만이면 예외처리 한다
    - [x]  중복된 이름이 들어오면 예외처리 한다
- [x]  사다리 높이를 입력 받는다
    - [x]  정수가 아닌 입력이 들어오면 예외처리한다
    - [x]  사다리 높이가 2 미만이면 예외처리한다
- [x]  사다리를 생성한다
    - [x]  세로라인을 사람 수 만큼 생성한다
    - [x]  가로라인을 생성한다
        - [x]  일정한 확률(50%)로 가로라인 생성 여부를 결정한다
        - [x]  결정된 생성 여부에 따라 가로 라인을 생성한다
        - [x]  만약 가로 라인이 겹친다면 그 줄은 넘어간다
- [x]  결과를 출력한다

---

## 2단계 추가 기능 목록

- [x]  보상(실행 결과) 입력 받기
   - [x]  보상의 길이는 최소 1자, 최대 5자
   - [x]  입력받은 보상의 수가 참여자의 수와 다르면 예외 처리
- [x]  보상(실행 결과) 출력
- [x]  참여자 별 사다리 결과 저장
- [x]  사다리에 따라 참여자와 결과 매칭: 사다리 타기
- [x]  실행 결과 출력
   - [x]  참여자의 이름을 입력하면 해당 참여자의 결과 출력
   - [x]  all을 입력하면 전체 참여자 출력
   - [x]  반복해서 출력 가능 하도록 구현
   - [x]  잘못된 이름 입력 시 예외 처리
- [x]  에러 메세지 출력
- [x]  입력 값 제한 추가
   - [x]  숫자 최대 범위 제한
      - [x]  참가자 수: 30
      - [x]  사다리 높이: 100
   - [x]  참여자 이름 all 불가능하게 제한
   - [x]  참여자 이름 quit 불가능하게 제한
- [x]  quit 입력 시 사다리 게임 종료