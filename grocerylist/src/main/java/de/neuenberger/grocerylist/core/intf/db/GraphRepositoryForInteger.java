package de.neuenberger.grocerylist.core.intf.db;



/**
 * 
 * @author Michael
 *
 * @param <S> The type.
 */
public interface GraphRepositoryForInteger<S> extends GraphRepository<S> {
	S findByInteger(int value);

}
