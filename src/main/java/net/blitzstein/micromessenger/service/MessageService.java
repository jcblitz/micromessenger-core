package net.blitzstein.micromessenger.service;

import net.blitzstein.micromessenger.domain.Message;

public interface MessageService {
	public boolean post(Message message);
}
