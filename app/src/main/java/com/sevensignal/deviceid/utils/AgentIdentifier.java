package com.sevensignal.deviceid.utils;

import com.sevensignal.deviceid.exceptions.AgentIdentifierStoreException;

public interface AgentIdentifier {
	String getId() throws AgentIdentifierStoreException;
}
