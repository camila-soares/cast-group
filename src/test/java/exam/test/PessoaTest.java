package exam.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.hibernate.mapping.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import exam.controller.BasicAuthController;
import exam.controller.PessoaController;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaTest {
	
	@Autowired
	private MockMvc mockmvc;
	
    private TestRestTemplate template = new TestRestTemplate();
	
    
    
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
    	mockmvc.perform(get("http://localhost:8080//api/v1//basicauth/").contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    }
    
	@Test
    public void hello() throws Exception {
		mockmvc.perform(get("/pessoa")
                .accept(MediaType.APPLICATION_JSON));
		assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
    }
	
}
