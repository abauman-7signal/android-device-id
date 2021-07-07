package com.sevensignal.deviceid.exceptions;

import lombok.Getter;

public class AgentIdentifierStoreException extends Exception {
	@Getter private final String agentId;

	public AgentIdentifierStoreException(String agentId) {
		super("Could not store agent identification: '" + agentId + "'");
		this.agentId = agentId;
	}
}
