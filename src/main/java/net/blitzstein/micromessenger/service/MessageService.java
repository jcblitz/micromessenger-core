package net.blitzstein.micromessenger.service;

import net.blitzstein.micromessenger.domain.Message;

public interface MessageService {
	public Message post(Message message);
	public boolean delete(Integer messageId);
}
