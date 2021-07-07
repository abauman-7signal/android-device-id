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

	@Test
	public void shouldReturnAgentIdentifier() throws AgentIdentifierStoreException {
		assertNotNull(subject.getId());
	}

}