package com.deliveryboy.deliveryboyapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.deliveryboyapp.config.AppConstants;

@Service
public class KafkaService {
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		
		this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
		logger.info("produced message");
		return true;
	}

}
