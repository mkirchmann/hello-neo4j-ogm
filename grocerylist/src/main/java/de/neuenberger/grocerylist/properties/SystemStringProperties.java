package de.neuenberger.grocerylist.properties;

public enum SystemStringProperties implements Property<String> {

	NEO4J_USERNAME("neo4j.username", "neo4j"), NEO4J_PASSWORD("neo4j.password", "groc1234"), NEO4J_SERVER(
			"neo4j.server", "http://localhost:7474/db/data");

	private final String key;

	private final String defaultValue;

	SystemStringProperties(final String key, final String defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
	}

	@Override
	public String getValue() {
		String result = System.getProperty(key, defaultValue);
		return result;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

}
