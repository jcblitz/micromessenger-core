package net.blitzstein.micromessenger.service;

import net.blitzstein.micromessenger.domain.Message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleMessageServiceImpl implements MessageService {
	Log logger = LogFactory.getLog(getClass()); 

	public boolean post(Message message) {
		logger.debug("Posting a message");
		return false;
	}

}
