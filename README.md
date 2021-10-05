# 숫자 야구 게임

## 게임 설명

* 1~9 서로다른수로 이루어진 3자리 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를
  얻고, 그 힌트를 이용해서 먼저 상대방의 수를 맞추면 승리한다.
    * [예]상대방의 수가 425일때, 123을 제시한 경우:1스트라이크, 456을 제시한 경우:1스트라이크1볼,
      789를 제시한 경우:낫싱
* 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.


## 기능 목록

1. 입/출력
    1. 메시지 출력
        * 숫자 입력 요청
        * 게임 결과
        * 게임 진행 여부
        * 에러 메시지
    2. 사용자 입력
        * 숫자
        * 게임 진행 여부
2. core
    1. 3자리 랜덤한 숫자 생성
    2. 스트라이크, 볼, 낫싱 판별 및 개수 확인


## 프로그램 실행 결과

```
숫자를입력해주세요:123
1스트라이크 1볼
숫자를입력해주세요:145
1볼
숫자를입력해주세요:671
2볼
숫자를입력해주세요:216
1스트라이크
숫자를입력해주세요:713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 끝
게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.
1
숫자를입력해주세요:123
1볼
…
```

## 디렉터리 구조

```
└─src
├─main
│  └─java
│      ├─baseball
│      │  │  Application.java               // Game App(게임 시작)
│      │  │  GamePlayer.java                // Game player
│      │  │  GamePrinter.java               // Game 입출력
│      │  │  GameStarter.java               // Game starter
│      │  │
│      │  ├─common
│      │  │  ├─constants
│      │  │  │      GameResult.java         // 게임 결과
│      │  │  │      NoticeMessage.java      // 사용자 Notice 메시지
│      │  │  │
│      │  │  └─exception
│      │  │      │  ExceptionChecker.java   // Exception checker
│      │  │      │  GameException.java      // Game 전역 Exception
│      │  │      │
│      │  │      └─code
│      │  │              GameErrorCode.java // Game Error code
│      │  │
│      │  └─domain
│      │          AttackNumbers.java        // 공격 숫자
│      │          GameNumbers.java          // 컴퓨터 생성 숫자
│      │          GameResults.java          // 게임 결과
│      │          Number.java               // 숫자
│      │
│      └─nextstep
│          └─utils
│                  Console.java             // Console util
│                  Randoms.java             // Random util
│
└─test
└─java
├─baseball
│  │  ApplicationTest.java
│  │
│  └─domain
│          AttackNumbersTest.java
│          GameNumbersTest.java
│          GameResultsTest.java
│          NumberTest.java
│
└─nextstep
└─test
NSTest.java 
```