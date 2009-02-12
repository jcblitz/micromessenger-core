package net.blitzstein.micromessenger.domain;

public class SimpleMessage implements Message {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
