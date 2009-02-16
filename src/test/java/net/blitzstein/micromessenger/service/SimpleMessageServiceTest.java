package net.blitzstein.micromessenger.service;

import static org.easymock.EasyMock.replay;
import net.blitzstein.micromessenger.dao.MessageDao;
import net.blitzstein.micromessenger.domain.Message;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

@ContextConfiguration(locations = { "/micromessenger-message-tests.xml" })
public class SimpleMessageServiceTest extends AbstractJUnit4SpringContextTests {

	private SimpleMessageServiceImpl messageService;
	MessageDao messageDao;

	Message messageMock;

	@Test
	public void postMessageTest() {
		expect(messageMock.getText()).andReturn("Hello World").anyTimes();
		expect(messageMock.getId()).andReturn(1).anyTimes();

		expect(messageDao.save(messageMock)).andReturn(messageMock).anyTimes();
		replay(messageDao);
		replay(messageMock);

		Message returned = messageService.post(messageMock);
		assertEquals("Hello World", returned.getText());
		assertEquals(new Integer(1), returned.getId());
	}
	
	@Test
	public void deleteMessageTest() {
		Integer callingMessageId = new Integer(1);
		expect(messageDao.delete(callingMessageId)).andReturn(true).anyTimes();
		replay(messageDao);

		boolean isDeleted = messageService.delete(callingMessageId);
		assertEquals("Message was not deleted", true, isDeleted);
	}


	@Before
	public void setUp() {
		messageService = new SimpleMessageServiceImpl();
		messageDao = (MessageDao) applicationContext.getBean("messageDaoMock");
		messageService.setMessageDao(messageDao);
		
		messageMock = (Message) applicationContext.getBean("messageMock");
	}

}
