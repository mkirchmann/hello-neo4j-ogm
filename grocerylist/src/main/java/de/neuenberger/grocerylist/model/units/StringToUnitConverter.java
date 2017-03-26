package de.neuenberger.grocerylist.model.units;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.util.Converter;

public class StringToUnitConverter { //implements Converter<String, Unit> {

	Map<String, Unit> map;
	{
		map = new HashMap<String, Unit>();
		putAll(PieceUnit.class);
		putAll(WeightUnit.class);
		putAll(VolumeUnit.class);

	}

	public Unit convert(final String arg0) {
		final Unit unit = map.get(arg0);
		if (unit == null) {
			throw new IllegalArgumentException("not parsable unit: " + arg0);
		}
		return unit;
	}

	private <T extends Enum<T> & Unit> void putAll(final Class<T> clazz) {

		final T[] enumConstants2 = clazz.getEnumConstants();
		for (final T t : enumConstants2) {
			final String result = t.getTechPrefix() + "." + t.toString();
			map.put(result, t);
		}
	}

}
