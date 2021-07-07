package com.sevensignal.deviceid.utils.agentid;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

public interface AgentIdentifier {
	String getId() throws AgentIdentifierStoreException;
}
