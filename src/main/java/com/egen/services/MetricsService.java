package com.egen.services;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.egen.dao.MetricsDao;
import com.egen.model.Metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.HttpHostConnectException;

import groovyx.net.http.HTTPBuilder;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.HttpHostConnectException;

import groovyx.net.http.HTTPBuilder;

@Service
public class MetricsService {
	
	@Autowired
	private MetricsDao metricsDAO;
	
	//@Autowired
	//private AlertsRulesEngine alertsRulesEngine;	
	
	
	public void create(Metrics metric) throws Exception{
		metricsDAO.create(metric);
		invokeAlertsRulesEngine(metric);
	}

	public List<Metrics> read(){
		return metricsDAO.read();
	}
	
	public List<Metrics> readByTimeRange(Timestamp stTm, Timestamp endTm){
		return metricsDAO.readByTimeRange(stTm, endTm);
	}	
	
	private void invokeAlertsRulesEngine(Metrics metric) throws Exception{
		String url = "http://localhost:8090/fireRules";
		HTTPBuilder http = new HTTPBuilder(url);
		
		Map<String, Object> map = new HashMap<>();
		String json = "{\"timestampValue\": \"" + String.valueOf(metric.getTimestampValue().getTime()) + "\", \"actualWt\": \"" + metric.getActualWt() + "\", \"baseWt\":\"" + metric.getBaseWt() + "\"}";
		map.put("body", json);
		System.out.println("Posting data " + json + " to api at " + url);
		
		Map<String, String> headers = new HashMap<>();
		headers.put("content-type", "application/json");
		map.put("headers", headers);
		
		try {
			http.post(map);
		} catch(HttpHostConnectException | NoHttpResponseException e) {
			System.out.println("API [" + url + "] not reachable. Error - " + e.getMessage());
		}
	}
}
