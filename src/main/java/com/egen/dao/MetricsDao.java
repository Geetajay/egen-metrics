package com.egen.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.egen.dao.AbstractDao;
import com.egen.model.Metrics;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.stereotype.Repository;

@Repository
public class MetricsDao extends AbstractDao{
	
	public void create(Metrics metric){
		Datastore datastore = createDatastore();	
		Key<Metrics> savedMetrics = datastore.save(metric);   
	    System.out.println("metrics id--" + savedMetrics.getId());
	}
	
	public List<Metrics> read(){
		Datastore datastore = createDatastore();
		Query<Metrics> query = datastore.createQuery(Metrics.class);
		List<Metrics> metricsList = query.asList();
	    return metricsList;
	}
	
	public List<Metrics> readByTimeRange(Timestamp stTm, Timestamp endTm){
		Datastore dataStore = createDatastore();
		System.out.println("start ime --" + stTm.getTime());
		System.out.println("end time -- " + endTm.getTime());
		Query<Metrics> query = datastore.createQuery(Metrics.class);
		query.field("timestampValue").greaterThanOrEq(stTm);
		query.field("timestampValue").lessThan(endTm);
	    List<Metrics> metrics = query.asList();
	    formatTimestamp(metrics);
	    return metrics;
	}
	
	private void formatTimestamp(List<Metrics> metrics){
		for(Metrics metric : metrics){
			System.out.println("metrics timestamp -- " + metric.getTimestampValue());
		}
	}
}
