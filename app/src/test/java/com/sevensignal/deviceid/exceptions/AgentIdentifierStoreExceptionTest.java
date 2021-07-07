package com.sevensignal.deviceid.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgentIdentifierStoreExceptionTest {

	@Test
	public void shouldInstantiateAndInitialize() {
		AgentIdentifierStoreException subject = new AgentIdentifierStoreException("agent-id-for-unit-test");
		assertNotNull(subject);
		assertEquals("agent-id-for-unit-test", subject.getAgentId());
	}

}