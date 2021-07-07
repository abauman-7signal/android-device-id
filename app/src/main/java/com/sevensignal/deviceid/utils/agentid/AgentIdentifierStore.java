package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

public interface AgentIdentifierStore {
	String read();
	void write(final String agentId) throws AgentIdentifierStoreException;
}
