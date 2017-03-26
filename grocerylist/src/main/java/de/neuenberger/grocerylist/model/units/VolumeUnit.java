package de.neuenberger.grocerylist.model.units;

public enum VolumeUnit implements Unit {
	LITER, MILLILITER;

	public String getTechPrefix() {
		return "v";
	}
}
