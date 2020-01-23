package exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PessoaEndPointTest.class)
@TestPropertySource(locations="classpath:application-test.properties")
@SpringBootApplication
public class PessoaEndPointTest {
	
	@Test
	public void contextLoads() {
		
	}

}
