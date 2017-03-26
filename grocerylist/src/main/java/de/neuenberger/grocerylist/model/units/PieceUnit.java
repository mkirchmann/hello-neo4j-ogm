package de.neuenberger.grocerylist.model.units;

public enum PieceUnit implements Unit {
	PIECE, PALETTE;

	public String getTechPrefix() {
		return "pc";
	}
}
