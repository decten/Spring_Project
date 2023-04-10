# 학점 계산기


## 기술 스택
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white">




## 구현 기능

### 기능 1

### 기능 2

### 기능 3

### 기능 4


## 배운 점

<p align="justify">
1. <a href="https://jojoldu.tistory.com/412">일급 컬렉션</a>: Collection을 Wrapping 함으로써 다른 멤버 변수가 없는 상태  

- 비즈니스에 종속적인 자료 구조: 일급 컬렉션만 있다면 모든 코드, 도메인을 알고 있지 않아도 기능을 구현할 수 있음
- 불변: <b>final은 불변이 아니라 재할당만 금지하는 것</b>으로 값 변경이 가능하다 ex)final Map 객체에 값 추가 가능, 컬렉션의 값을 변경할 수 있는 메소드가 없는 컬렉션을 만들면 불변 컬렉션이 된다
- 상태와 행위를 한 곳에서 관리
- 컬렉션에 이름을 붙일 수 있다
```java
//일급 컬렉션 예시
public class GameRanking {

    private Map<String, String> ranks;

    public GameRanking(Map<String, String> ranks) {
        this.ranks = ranks;
    }
}
```
2. 객체 지향 설계 고려사항:
    1) 도메인을 구성하는 객체
    2) 객체들간의 관계
    3) 도메인 모델링-동적인 객체를 정적인 타입(클래스)으로 추상화
   4) 협력
   5) 객체를 포괄하는 타입에 책임 할당


</p>

<br>

## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
