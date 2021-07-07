package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

import java.util.UUID;

public class DefaultAgentIdentifier implements AgentIdentifier {

	private final AgentIdentifierStore agentIdSharedPrefStore;
	private final AgentIdentifierStore agentIdFileStore;

	public DefaultAgentIdentifier(final AgentIdentifierStore agentIdSharedPrefStore, final AgentIdentifierStore agentIdentifierFileStore) {
		this.agentIdSharedPrefStore = agentIdSharedPrefStore;
		this.agentIdFileStore = agentIdentifierFileStore;
	}

	private boolean isNotEmpty(final String id) {
		return (id != null && !id.isEmpty());
	}

	@Override
	public String getId() throws AgentIdentifierStoreException {
		String agentId = agentIdSharedPrefStore.read();
		if (isNotEmpty(agentId)) {
			return agentId;
		}
		agentId = UUID.randomUUID().toString().trim();
		agentIdSharedPrefStore.write(agentId);
		agentIdFileStore.write(agentId);
		return agentId;
	}
}
