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
- 프로젝트에서는 Course 클래스 리스트 형태의 인스턴스만 가진 Courses 1급 컬렉션을 만들었다: 해당 컬렉션과 관련된 기능들은 모두 1급 컬렉션으로 위임한 것
```java
    private final List<Course> courses; //Courses 클래스 안의 변수는 오로지 이것만 가질 수 있음

```
2. 객체 지향 설계 고려사항:
    1) 도메인을 구성하는 객체
    2) 객체들간의 관계
    3) 도메인 모델링-동적인 객체를 정적인 타입(클래스)으로 추상화
   4) 협력
   5) 객체를 포괄하는 타입에 책임 할당
3. generate 단축키: alt+insert(테스트 메소드)
4. <b>assertThatCode</b>를 사용하기 위해선 gradle에 의존성 추가해야 함:
```java
       testImplementation 'org.assertj:assertj-core:3.19.0'
```
5. 테스트 코드를 먼저 통과함으로써 모듈의 로직이 잘 짜였는지 확인할 수 있음 - 모든 틀을 갖추고 함수 로직을 채우는 형태
- 함수를 작성할 때도 함수를 사용하는 곳에 먼저 작성하고 나중에 Alt+Enter로 구현한다
6. switch case에서 바로 return이 아니라 변수 한 번 거치고 return
```java
switch (this.grade){
            case "A+":
                grade = 4.5;
                break;
        }
        return grade;
```
7. <a href="https://mangkyu.tistory.com/112">스트림</a>
   - 생성, 가공, 결과
   - 생성 - 스트림은 일회성-닫히면 끝
   - 가공 - 계속 스트림으로 반환
   - 결과 - 가공된 데이터 소모-> 1번만 가능
8. 객체에 모듈을 추가해서 작업을 수행하도록 함 -> 응집성 높임: 수정이 필요할 때 그 부분만 하면 되므로(원래는 사용하는 곳마다 수정해야 함)
   - getter로 정보를 가져오지 말고, 그 정보를 가진 객체 안에서 작업을 처리한다
</p>

<br>

## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
