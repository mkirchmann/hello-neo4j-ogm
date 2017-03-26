package de.neuenberger.grocerylist.model.units;

import com.fasterxml.jackson.databind.util.Converter;

public class UnitToStringConverter { // implements Converter<Unit, String> {

	public String convert(final Unit arg0) {
		return arg0.getTechPrefix() + "." + arg0.toString();
	}

}
