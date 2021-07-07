package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultAgentIdentifierTest {

	private AgentIdentifier subject;

	@Before
	public void setup() {
		subject = new DefaultAgentIdentifier();
	}

	private void assertNotEmpty(String uuid1) {
		assertNotNull(uuid1);
		assertNotEquals(0, uuid1.length());
	}

	@Test
	public void shouldReturnAgentIdentifier() throws AgentIdentifierStoreException {
		assertNotNull(subject.getId());
	}

	@Test
	public void shouldCreateUUID() throws AgentIdentifierStoreException {
		final String uuid1 = subject.getId();
		assertNotEmpty(uuid1);

		final String uuid2 = subject.getId();
		assertNotEmpty(uuid2);

		assertNotEquals("getting UUIDs back to back should not return same value", uuid1, uuid2);
	}

}