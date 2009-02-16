package net.blitzstein.micromessenger.dao;

import net.blitzstein.micromessenger.domain.Message;

public interface MessageDao {
	public Message save(Message message);
	public boolean delete(Integer messageId);
	

}
