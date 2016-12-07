package com.whoayoo.util.email;

import com.amazonaws.services.simpleemail.model.Destination;

public class EmailUtil {
	public void send(String from, String to, String title, String body) {
		Destination destination = new Destination().withToAddresses(to);
	}
}
