# JDBC(Java Database Connectivity)
- 자바 언어와 데이터베이스를 연결해주는 통로.
- 자바를 이용한 데이터베이스 접속과 SQL 문장의 실행, 그리고 실행 결과로 얻어진 데이터의 핸들링을 제공하는 방법과 절차에 관한 규약
- 자바 프로그램내에서 SQL문을 실행하기 위한 자바 API
- SQL과 프로그래밍 언어의 통합 접근 중 한 형태
- JAVA는 표준인터페이스인 JDBC API를 제공

### JDBC를 이용한 프로그래밍 방법
1. import
```
import java.sql.*; //DriveManager, Connection, StateMent 등의 인터페이스가 들어 있다.
```
2. 드라이버를 로드 한다.
```
Class.forName("com.mysql.jdbc.Driver");
```
3. Connection 객체를 생성한다.
- 데이터베이스에 접속하는 부분이다.  
- 데이터베이스에 접속됐을 때 Connection 객체를 얻어낼 수 있다. 
DriverManager를 이용해서 Connection 인스턴스를 얻는다.
```
String url = "jdbc:mysql://localhost/dbName";
String id = "";
String password = "";
Connection con = DriverManager.getConnection(url, id, password);
```
4. Statement 객체 생성 및 질의 수행
- Connection을 통해서 Statement를 얻는다.  
- Statement는 쿼리문을 생성하고 실행할 수 있도록 도와주는 객체이다.
```
Statement stmt = con.createStatement();
```
5. SQL문에 결과물이 있다면 ResultSet 객체를 생성한다.
- Statment를 이용해 ResultSet을 얻는다.
```
ResultSet rs = stmt.executeQuery("select no from user"); // SELECT
               stmt.executeUpdate("query"); //INSERT, UPDATE, DELETE일 경우
while(rs.next())
 system.out.println(rs.getInt("no"));
```
6. 모든 객체를 닫는다.
```
rs.close();
stmt.close();
```
