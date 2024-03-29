# JDBC를 활용한 CRUD 구현

## 기술 스택
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white">

<br>

## 구현 기능

### 기능
히카리 DBCP로 h2 데이터베이스에 정보를 저장하고 조회할 수 있다

## 배운 점
**ctrl+alt+c로 원래 값을 변수로 만들 수 있음**
1. JDBC
- 자바에서 DB 프로그래밍을 할 수 있도록 도와주는 표준 인터페이스 -> <b>표준 인터페이스라 DBMS 종류 상관 없음</b>
- JDBC 인터페이스 구현체는 각 데이터베이스 벤더 사들이 제공 -> <b>JDBC 드라이버</b>라고 부름
- <a href="https://kyun2.tistory.com/23">연결 순서</a>  
  (1) Class.forName() 을 이용해서 드라이버 로드  
  (2) DriverManager.getConnection() 으로 연결 얻기   
  (3) Connection 인스턴스를 이용해서 Statement 객체 생성  
  (4) Statement 객체의 결과를 ResultSet 이나 int에 받기  
2. DBCP(DB 커넥션 풀)
- 미리 일정량의 DB 커넥션을 생성해서 풀에 저장하고, HTTP 요청에 따라 풀에서 커넥션을 가져다 씀
- 스프링 부트 2.0부터는 디폴트 커넥션 풀이 HikariCP(히카리)
3. 커넥션 풀 사용 시 유의 사항
- 커넥션의 사용 주체는 WAS 스레드 -> 커넥션 개수는 WAS 스레드 수를 고려해야 함  
커넥션 수 ↑: 메모리 소모가 크지만 동접자가 많아도 대기 시간 줄어듦, 커넥션 수 ↓: 메모리 소모 적지만 대기 시간 늘어남  
<a href="https://techblog.woowahan.com/2663/">풀 사이즈 계산:</a> Tn × ( Cm - 1 ) + ( Tn / 2 ) 
4. DataSource
- 커넥션을 획득하기 위한 표준 인터페이스
5. ResourceDatabasePopulator : 스크립트 로더
    ```java
    populator.addScript(new ClassPathResource("db_schema.sql"));
    ```
   이런 식으로 DB 초기 설정하는 스크립트를 설정할 수 있다
6. TDD-@BeforeEach setUP 메서드: 테스트 코드 수행 전 수행할 동작
7. HikariCP: Database와의 커넥션 풀 관리
   **setDriverClassName**: JDBC 드라이버의 클래스 이름 설정,  데이터베이스의 종류에 따라 다른 JDBC 드라이버를 사용해야 함    
     <b>setJdbcUrl</b>:  jdbc:subprotocol:subname   
     &nbsp; ex) jdbc:mysql://localhost:3306/testdb?user=root&password=secret
8. DB 연결 해제  
    <b>Connection은 물론이고, PreparedStatement도 해제해야 함</b>
    ```java
            if(pstmt != null){
                pstmt.close();
            }
            if(con!=null){
                con.close();
            }
    ```
9. ResultSet: executeQuery 실행 후 반환 객체(결과값)
10. SQL exception 처리
    ```java
    (SQLException e){
            throw new IllegalStateException(e);
        }
    ```
## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)
