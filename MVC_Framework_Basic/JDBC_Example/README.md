# JDBC를 활용한 CRUD 구현

## 기술 스택
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white">

<br>

## 구현 기능

### 기능 1

### 기능 2

### 기능 3

### 기능 4

<br>

## 배운 점
1. JDBC
- 자바에서 DB 프로그래밍을 할 수 있도록 도와주는 표준 인터페이스 -> <b>표준 인터페이스라 DBMS 종류 상관 없음</b>
- JDBC 인터페이스 구현체는 각 데이터베이스 벤더 사들이 제공 -> <b>JDBC 드라이버</b>라고 부름
2. DBCP(DB 커넥션 풀)
- 미리 일정량의 DB 커넥션을 생성해서 풀에 저장하고, HTTP 요청에 따라 풀에서 커넥션을 가져다 씀
- 스프링 부트 2.0부터는 디폴트 커넥션 풀이 HikariCP(히카리)
3. 커넥션 풀 사용 시 유의 사항
- 커넥션의 사용 주체는 WAS 스레드 -> 커넥션 개수는 WAS 스레드 수를 고려해야 함  
커넥션 수 ↑: 메모리 소모가 크지만 동접자가 많아도 대기 시간 줄어듦, 커넥션 수 ↓: 메모리 소모 적지만 대기 시간 늘어남
4. DataSource
- 커넥션을 획득하기 위한 표준 인터페이스
## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
