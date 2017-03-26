package de.neuenberger.grocerylist.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="Shopped")
public class Shopped {
	@GraphId
	private Long id;

	Shopper shopper;
}
