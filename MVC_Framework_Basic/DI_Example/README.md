# DI 프레임워크

## 기술 스택
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white">


## 구현 기능


### 기능 1

### 기능 2

### 기능 3

### 기능 4


## 배운 점
**IOC와 DI는 클래스 간 결합을 느슨히 하기 위함 -> 지속가능하고 확장성 있는 개발**
1. DI(Dependency Injection): 의존성 주입  
- 한 객체가 다른 객체를 사용할 때 의존성이 있다고 함
- 상위 레벨은 하위 모듈에 의존하지 않는다, 둘 다 인터페이스에 의존
- 의존 대상 B가 변하면, 의존 하고 있는 A도 변한다   
    -> 중간에 인터페이스를 두고, A와 인터페이스의 결합을 느슨하게 하는 방법이 있음
- 런타임 시 의존 관계를 맺는 대상을 외부에서 결정하고 주입함
- 스프링 프레임워크는 DI 기능을 지원해주는 프레임워크  
<br>
<b>DI 장점</b>
- 의존성 주입을 인터페이스 기반으로 설계하면 코드가 유연해짐 -> 느슨한 결합도
- 변경에 유연해짐 -> 결합도가 낮은 객체끼리는 부품을 쉽게 갈아 끼울 수 있음
2. IOC(Inversion of Control): 제어권 역전
- 원래 개발자가 해왔던 일을 컨테이너라는 객체 관리 프로그램이 알아서 해준다
- 프로그램 흐름을 직접 제어하는 것이 아니라 외부에서 관리
- 응집도를 높이고 결합도를 낮춤
3. 리플렉션
- 클래스 정보를 클래스 로더를 통해 읽어와서 JVM 메모리에 저장하는 것
- 힙 영역에 로드 돼 있는 클래스 타입의 객체 통해서 필드/메소드/생성자를 접근 제어자와 상관 없이 사용할 수 있도록 지원하는 API
- 어노테이션을 프레임워크의 기능으로 사용할 수 있음  
<br>
<b>단점</b>
- 런타임에 클래스를 분석해서, 일반 메서드보다 속도가 느림
- 타입 체크가 컴파일 타임에 불가능함
- 객체의 추상화가 깨짐
4. 탑-다운 방식: 선 선언 후 구현 -> 있을 것이라 가정해서 먼저 선언 후 나중에 구현 함 
5. 가변 인자 & 제네릭 타입의 사용
    ```java
        Class<? extends Annotation>... annotations
    ```
- 가변 인자: 매개변수를 동적으로 받을 수 있는 방법, 내부적으로 배열로 처리 됨
- <? extends Annotation>: Annotation 클래스 또는 그 하위 타입만 허용
## 라이센스
리플렉션: https://www.baeldung.com/reflections-library, https://hudi.blog/java-reflection, https://velog.io/@suyeon-jin/%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98-%EC%8A%A4%ED%94%84%EB%A7%81%EC%9D%98-DI%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B1%B8%EA%B9%8C  
MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
