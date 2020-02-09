package test.com.example.demo.integration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import main.ClinicalSystemApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClinicalSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")

	public abstract class AbstractTest {

	}
	
	

