package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

public class DefaultAgentIdentifier implements AgentIdentifier {
	@Override
	public String getId() throws AgentIdentifierStoreException {
		return "an id";
	}
}
