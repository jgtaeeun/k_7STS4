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