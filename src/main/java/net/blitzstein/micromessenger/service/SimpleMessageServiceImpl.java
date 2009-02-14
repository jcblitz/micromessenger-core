package net.blitzstein.micromessenger.service;

import net.blitzstein.micromessenger.dao.MessageDao;
import net.blitzstein.micromessenger.domain.Message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageServiceImpl implements MessageService {
	private MessageDao messageDao;
	Log logger = LogFactory.getLog(getClass());

	public boolean post(Message message) {
		return messageDao.save(message);
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
