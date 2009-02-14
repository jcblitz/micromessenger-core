package net.blitzstein.micromessenger.dao;

import net.blitzstein.micromessenger.domain.Message;

public interface MessageDao {
	public boolean save(Message message);

}
