package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultAgentIdentifierTest {

	private static final String UUID_FROM_SHARED_PREF = "uuid-from-shared-pref";
	private static final String UUID_FROM_FILE = "uuid-from-file";

	private AgentIdentifier subject;

	@Mock
	private AgentIdentifierStore agentIdSharedPrefStoreMock;

	@Mock
	private AgentIdentifierStore agentIdFileStoreMock;


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		subject = new DefaultAgentIdentifier(agentIdSharedPrefStoreMock, agentIdFileStoreMock);
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

	@Test
	public void shouldPersistUuid() throws AgentIdentifierStoreException {
		String actualUuid = subject.getId();
		assertNotEmpty(actualUuid);
		verify(agentIdSharedPrefStoreMock, times(1)).write(actualUuid);
		verify(agentIdFileStoreMock, times(1)).write(actualUuid);
	}

	@Test
	public void shouldFirstTryToUseIdFromSharedPrefStore() throws AgentIdentifierStoreException {
		when(agentIdSharedPrefStoreMock.read()).thenReturn(UUID_FROM_SHARED_PREF);
		assertEquals(UUID_FROM_SHARED_PREF, subject.getId());

		when(agentIdSharedPrefStoreMock.read()).thenReturn("");
		assertNotEmpty(subject.getId());

		when(agentIdSharedPrefStoreMock.read()).thenReturn(null);
		assertNotEmpty(subject.getId());
	}

	@Test
	public void shouldNextTryToUseIdFromFileStoreAndUpdateSharedPrefStore() throws AgentIdentifierStoreException {
		when(agentIdSharedPrefStoreMock.read()).thenReturn(null);
		when(agentIdFileStoreMock.read()).thenReturn(UUID_FROM_FILE);
		assertEquals(UUID_FROM_FILE, subject.getId());
		verify(agentIdSharedPrefStoreMock, times(1)).write(UUID_FROM_FILE);

		when(agentIdFileStoreMock.read()).thenReturn("");
		assertNotEmpty(subject.getId());

		when(agentIdFileStoreMock.read()).thenReturn(null);
		assertNotEmpty(subject.getId());
	}
}