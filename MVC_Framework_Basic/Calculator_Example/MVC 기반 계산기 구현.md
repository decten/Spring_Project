# MVC 기반 계산기 구현

## 프로젝트 소개



## 기술 스택
<img src="https://img.shields.io/badge/이름-색깔?style=for-the-badge&logo=이름&logoColor=white">
https://simpleicons.org/

<br>

## 구현 기능

### 기능 1

### 기능 2

### 기능 3

### 기능 4

<br>

## 배운 점

1. (느낀점) 이전 프로젝트부터 Test 코드를 작성하고, Production 코드를 작성하는 순서가 이제는 익숙해졌다.
2. 함수를 void에서 리턴형으로 바꿨을 때, 미리 작성한 함수 호출한 코드에서 alt+enter로 리턴 값 받는 변수를 편하게 설정   
    -> Test 코드에서 유용했다
3. (단축키) ctrl+alt+n: 자동 정렬, alt+shit: 줄 이동
4. Parameterized Tests의 dependency: testImplementation 'org.junit.jupiter:junit-jupiter-params:5.7.2'
   - <span style='background-color: #fff5b1'>@MethodSource + Stream 함수</span> -> 각각의 테스트 함수를 하나의 테스트 함수로 통합
        ```java 
     @MethodSource(“함수명”)
     void 테스트함수( 파라미터 ){}
     /*static 아니면 Cannot invoke non-static method 에러 발생*/
     // 인자가 1개인 경우
     static Stream<리턴타입> 함수(){
       return Stream.of(원하는 값);
     }
     // 인자가 2개 이상인 경우
     static Stream 함수(){
     return Stream.of(
       arguments(원하는 값1 , 원하는 값2, … ),
       arguments(원하는 값1 , 원하는 값2, … ),
       );
     }
       
        ```
5. String 값을 비교할 때 **equals** 메소드 사용  
ex) <span style='background-color: #ffdce0'>"Y"==value</span> 아님, <span style='background-color: #dcffe4'>"Y".equals(value)</span> 맞음
6.
| Enum |
|:----:|
**C/C++에서는 그저 int지만, 자바에서는 기능을 갖춘 클래스다**

|                                                  특징                                                  |
|:----------------------------------------------------------------------------------------------------:|
|                  인터페이스 아니고, <span style='background-color: #fff5b1'>추상 클래스</span>다                   |
|                    클래스를 <span style='background-color: #ffdce0'>상속</span> 받을 수 없다                    | 
| 인터페이스를 <span style='background-color: #dcffe4'>구현</span> 할 수 있다 -> <u>함수, 추상 메소드, 생성자</u> 선언 및 구현 가능 |
##### Enum 언제 사용할까?
사용하는 인스턴스 수가 정해져 있고 처리할 수 있는 상수 값이 여러 개 존재할 때   
ex) 로또, 계산기, 가위 바위 보
##### Enum 장점
- 문자열 보다 IDE의 지원이 더 많다  
  ex) 자동 완성, 오타 검증, 텍스트 리팩토링
- 허용 가능한 값을 제한할 수 있다
- 리팩토링시 변경 범위가 최소화 된다  
-> enum만 수정하면 됨  

|                                활용                                |
|:----------------------------------------------------------------:|
|       Y("1", true) -> Y,i,true는 한 묶음<br>**if문/반복성 코드 줄임**        |
| java8 이후는 상수 별로 lamda 구현 후 함수 호출 가능 <br>(java7 이하에서는 상수별 메소드 구현) |
|                 static 메서드 작성할 때 Optional을 같이 사용                 |

7.
| Optional |
|:--------:|
NullpointerException를 해결하기 위한 메소드를 제공하는 제네릭 클래스(모든 타입의 참조 변수 담을 수 있음)  
-> 반환 결과가 null인지 if문으로 확인하는 걸 옵셔널 메소드로 간단히 처리 

|                 메소드                 | 설명                                                             |
|:-----------------------------------:|----------------------------------------------------------------|
|           of, ofNullable            | 객체 생성                                                          |
| get, orElse, orElseGet, orElseThrow | 객체 값 가져오기, 지정된 예외를 발생하는 orElaseThrow 사용 추천<br><a href="https://ksabs.tistory.com/237">반환 값 참고 |

8.
| Stream |
|:------:|
데이터 소스, 중간 연산(필터/맵), 최종 연산으로 구성된다    

- 데이터 소스: 컬렉션(리스트), 배열(String,기본형-IntStream/LongStream/DoubleStream)-of 메소드  
    ,람다(iterate, generate), empty, 스트림의 연결(concat) 
- 내부 상태를 갖는 연산: 값을 반복적으로 처리하기 위해 내부 상태 필요  
    ex) distinct, skip, limit, sorted, reduce

|                주요 메소드                 | 설명                                                                |
|:-------------------------------------:|-------------------------------------------------------------------|
|                filter                 | equals로 가져올 조건 작성, hashCode/equals로 고유 여부 판단 후 distinct로 중복 제거 가능 |      
|   takeWhile/dropWhile, limit, skip    | 스트림 슬라이싱: 특정 조건의 리스트 반환                                           |
|             map, flatMap              | 매핑(변환)                                                            |
| allMatch/noneMatch, findFirst/findAny | 검색 & 매칭                                                           |
|                reduce                 | 리듀싱 연산(반환 값-일반적으로 0 생략 가능, 변환 함수, 연산 함수)                          |
|                collect                | 리듀스/요약 연산, 그룹화, 분할                                                |
9. ::(더블 콜론)는 객체에서 특정 메소드를 호출할 때 사용 -> 메소드 래퍼런스

<br>  

## 참고 자료
https://velog.io/@ljinsk3/Concept-Enum
https://techblog.woowahan.com/2527/  
https://homoefficio.github.io/2019/10/03/Java-Optional-%EB%B0%94%EB%A5%B4%EA%B2%8C-%EC%93%B0%EA%B8%B0/
https://lee1535.tistory.com/138
https://www.daleseo.com/java8-optional-effective/ -> <span style='background-color: #fff5b1'>강추!</span>
https://ryan-han.com/post/dev/java-stream/
## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
