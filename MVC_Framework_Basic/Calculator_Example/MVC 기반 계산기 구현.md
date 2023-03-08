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
        // 인자가 1개인 경우
        Stream<리턴타입> 함수(){
          return Stream.of(원하는 값);
        }
        // 인자가 2개 이상인 경우
        Stream 함수(){
        return Stream.of(
          arguments(원하는 값1 , 원하는 값2, … ),
          arguments(원하는 값1 , 원하는 값2, … ),
          );
        }
       
           ```

<br>

## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
