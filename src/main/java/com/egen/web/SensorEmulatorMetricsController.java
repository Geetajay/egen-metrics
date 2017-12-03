package com.egen.web;

import java.sql.Timestamp;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.egen.model.InputRequest;
import com.egen.model.Metrics;
//import com.egen.model.RequestBody;
import com.egen.services.MetricsService;
import com.egen.util.TimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
public class SensorEmulatorMetricsController {
	
	@Autowired
	//@Qualifier("MetricsService")
	private MetricsService metricsService;
	
	@RequestMapping(value = "/create", method = { RequestMethod.POST })
	//@PostMapping("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(@RequestBody Metrics metric) throws Exception{
		// create metrics in MangoDB
		//Map<String, String> output = new HashMap<String, String>();
		//output.put("message", "hello world");
		//System.out.println("requestBody -- " + requestBody.value);
		//Metrics metric = createMetrics(requestBody);
		 /*HttpSession session = request.getSession();
		 System.out.println("session -- " + session.getId());
		 Integer baseWt = (Integer)session.getAttribute("base_weight");
		 System.out.println("metric.getActualWt() in controller --" + metric.getActualWt());
		 System.out.println("base weight in session --" + baseWt);
		 if(baseWt == null){
			 session.setAttribute("base_weight", Integer.valueOf(metric.getActualWt()));
			 metric.setBaseWt(metric.getActualWt());
		 }*/
		 //TODO
		//System.out.println("System.getProperty--" + System.getProperty("base.value"));
		//int base_weight = Integer.parseInt(System.getProperty("base.value"));
		//System.out.println("base weight  --" + metric.getBaseWt());
		//metric.setBaseWt(base_weight);
		metricsService.create(metric);
		//return output;
	}
	
	@RequestMapping(value = "/read", method = { RequestMethod.GET })
	public List<Metrics> read()
	{
		List<Metrics> metrics = metricsService.read();
		return metrics;
	}
	
	@RequestMapping(value = "/readByTimeRange", method = { RequestMethod.GET })
	public List<Metrics> readByTimeRange(@RequestParam(value = "startTm") Timestamp stTm,
			@RequestParam(value = "endTm") Timestamp endTm){
		List<Metrics> metrics = metricsService.readByTimeRange(stTm, endTm);
		return metrics;
	}
	
		
	/*private Metrics createMetrics(InputRequest requestBody){
		Metrics metric = new Metrics();
		metric.setActualWt(requestBody.value);
		String timeInMills = requestBody.timeStamp;
		Timestamp tmStamp = TimeUtility.ConvertMilliSecondsToFormattedDate(timeInMills);
		metric.setTimestampValue(tmStamp);
		return metric;
	}*/
}
