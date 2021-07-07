package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

import java.util.UUID;

public class DefaultAgentIdentifier implements AgentIdentifier {
	@Override
	public String getId() throws AgentIdentifierStoreException {
		return UUID.randomUUID().toString().trim();
	}
}
