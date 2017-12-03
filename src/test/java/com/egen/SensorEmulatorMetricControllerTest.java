package com.egen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.egen.dao.MetricsDao;
import com.egen.services.MetricsService;
import com.egen.web.SensorEmulatorMetricsController;


@RunWith(SpringJUnit4ClassRunner.class)
public class SensorEmulatorMetricControllerTest {

	//
	protected static MockServletContext servletContext = new MockServletContext();
	@Mock
	private MetricsService metricsService;
	@InjectMocks
	SensorEmulatorMetricsController metricController;
	@Mock
	private MetricsDao metricsDAO;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testSessionInterceptor() {
	}
}
