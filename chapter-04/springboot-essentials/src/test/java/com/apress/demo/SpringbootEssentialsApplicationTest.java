package com.apress.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Siva
 *
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringbootEssentialsApplication.class)
public class SpringbootEssentialsApplicationTest
{
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	@Test
	public void testContextLoads()
	{
		System.out.println(dataSourceConfig);
		assertNotNull(dataSourceConfig);
	}

}
