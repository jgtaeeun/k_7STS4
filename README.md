post방식 https://nocount.tistory.com/117


==================================================================

@Builder 모든 필드들이 포함된 생성자를 만든다. 기본생성자가 없다.
@NoArgsConstructor        기본생성자
@AllArgsConstructor         모든필드들이 포함된 생성자

ch05.src/test/java/edu/pnu/BoardRepositoryTest.java : import org.junit.jupiter.api.Order;
ch05/src/main/java/edu/pnu/DateInit.java : application.properties에 spring.h2.console.path: /h2-console  
					http://localhost:8080/h2-console
					H2 DB Embedded Mode
ch05/src/main/java/edu/pnu/TestController.java : post 할 때 입력데이터는 json형태





==================================================================
6장 필기
수정@RequestMapping(value="/getBoardList", method= {RequestMethod.GET, RequestMethod.POST})

hello    -함수명이랑 url이 HelloController 기존에 있던 함수와 이름이 동일해서 에러난 듯 하다

	@GetMapping("/helloty")
	public String helloty(Model model) {
		model.addAttribute("helloty", "Hello_타임리프");
		return "hello";
	}

타임리프로 게시판 프로그램 개발하기-목록출력-writer 양방향 매핑=>create로 하고 다시 update로 고치기
==================================================================
1)create a new database
https://velog.io/@dailylifecoding/H2-h2-install-and-create-database

주의할 점은 Database path 에 처음에는 ./ 으로 시작하는데, 해당 부분을 ~/ 으로 수정 하고 나서 뒤에 Database 이름을 지정해준다.
그 아래로 Username, Password 는 알아서 작성한다.
다 작성 후 create를 누르면 아래 초록색 글귀와 함께 성공적으로 DataBase 생성됐음을 알려준다.
~/.h2/test
==================================================================

jpa:자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스
    db는 양방향관계인 반면, 자바객체는 상속관계(단방향)이다.

서블릿(Servlet)이란?
서블릿은 클라이언트의 요청을 처리하도록 특정 규약에 맞춰 Java 코드로 작성하는 클래스 파일이다.
아파치 톰캣(Apache Tomcat)은 이러한 서블릿들이 웹 애플리케이션으로 실행할 수 있도록 해주는 서블릿 컨테이너(Servlet Container) 중 하나이다.
출처: https://ittrue.tistory.com/234 [IT is True:티스토리]

Model(모델)
Spring MVC 기반의 웹 애플리케이션이 클라이언트의 요청을 전달받으면 요청 사항을 처리하기 위한 작업을 한다.
처리한 작업의 결과 데이터를 클라이언트에게 응답을 돌려주어야 하는데, 이때 클라이언트에게 응답으로 돌려주는 작업의 처리 결과 데이터를 Model이라 한다.
 
클라이언트의 요청 사항을 구체적으로 처리하는 영역을 서비스 계층(Service layer)라고 하며,
요청 사항을 처리하기 위해 Java 코드로 구현한 것을 비즈니스 로직(Business Logic)이라 한다.
 
View(뷰)
View는 Model을 이용하여 웹 브라우저와 같은 애플리케이션의 화면에 보이는 리소스(Resource)를 제공하는 역할을 한다.
 
Spring MVC에는 다양한 View 기술이 포함되어 있다.

HTML 페이지 출력
PDF, Excel 등의 문서 형태로 출력
XML, JSON 등 특정 형식의 포맷으로 변환

 
Controller(컨트롤러)
컨트롤러는 클라이언트 측의 요청을 직접적으로 전달받는 엔드포인트(Endpoint)로써 Model과 View의 중간에서 상호작용을 해주는 역할을 한다.
 
클라이언트 측의 요청을 전달받아 비즈니스 로직을 거친 후, Model 데이터가 만들어지면, 이 Model 데이터를 View로 전달하는 역할을 한다.
출처: https://ittrue.tistory.com/234 [IT is True:티스토리]
==================================================================

프로젝트-run as-maven install-target폴더 내 jar파일
chapter01
src/test/java

Chapter01ApplicationTests.java
	@Test
	void contextLoads() {
	}
	@Test
	void contextLoads1() {
		System.out.println("Chapter01ApplicationTests1");
	}

Chapter0102ApplicationTests.java
	@Test
	void contextLoads2() {
		System.out.println("Chapter01ApplicationTests0102_2");
	}
	@Test
	void contextLoads3() {
		System.out.println("Chapter01ApplicationTests3");
	}
	
chapter01project 오른쪽마우스-run as- maven install하면 Chapter01ApplicationTests.java만 뜬다.
src/test/java 디렉토리 아래의 모든 테스트 코드를 찾아서 실행하기 위해 아래의 과정이 필요하다.


테스트 이름 규칙: Test.java 또는 TestCase.java로 끝나는 클래스

테스트 어노테이션:  어노테이션(@Test, @Before, @After 등)

포함/제외 설정: pom.xml 파일에서 특정 테스트 클래스를 포함하거나 제외하는 설정이 되어 있을 수 있습니다. 
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
        
             <configuration>
                	<includes>
                  	  <include>Chapter0102ApplicationTests.java</include>
                  	  <include>Chapter0102ApplicationTests.java</include>
                    <!-- Include patterns for additional test classes -->
                	</includes>
           	</configuration>
        </plugin>
    </plugins>
</build>


위의 과정을 거치고 난 뒤에 chapter01project 오른쪽마우스-run as- maven install하면 
Chapter0102ApplicationTests.java 결과 먼저 뜨고
Chapter0102ApplicationTests.java가 나중에 뜬다.