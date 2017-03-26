package de.neuenberger.grocerylist.model.units;

public enum WeightUnit implements Unit {
	GRAMM, KILOGRAMM;

	public String getTechPrefix() {
		return "w";
	}
}
