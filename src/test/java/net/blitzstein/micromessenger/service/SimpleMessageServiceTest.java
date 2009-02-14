package net.blitzstein.micromessenger.service;

import static org.easymock.EasyMock.replay;
import net.blitzstein.micromessenger.dao.MessageDao;
import net.blitzstein.micromessenger.domain.Message;
import net.blitzstein.micromessenger.domain.SimpleMessage;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

@ContextConfiguration(locations = { "/micromessenger-message-tests.xml" })
public class SimpleMessageServiceTest extends AbstractJUnit4SpringContextTests {

	private SimpleMessageServiceImpl messageService;
	IMocksControl mockCreator;
	MessageDao messageDao;

	Message messageMock;

	@Test
	public void postMessageTest() {
		// Message simpleMessage = new SimpleMessage();

		expect(messageMock.getText()).andReturn("Hello World").anyTimes();
		expect(messageMock.getId()).andReturn(1).anyTimes();

		expect(messageDao.save(messageMock)).andReturn(true).anyTimes();
		replay(messageDao);
		replay(messageMock);

		boolean posted = messageService.post(messageMock);
		assertTrue("Message was not posted succesfully", posted);
		assertEquals("Hello World", messageMock.getText());
		assertEquals(new Integer(1), messageMock.getId());
	}

	@Before
	public void setUp() {
		messageService = new SimpleMessageServiceImpl();
		messageDao = (MessageDao) applicationContext.getBean("messageDaoMock");
		messageService.setMessageDao(messageDao);
		
		messageMock = (Message) applicationContext.getBean("messageMock");
	}

}
