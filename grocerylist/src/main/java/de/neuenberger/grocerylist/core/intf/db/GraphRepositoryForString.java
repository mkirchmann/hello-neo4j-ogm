package de.neuenberger.grocerylist.core.intf.db;



/**
 * 
 * @author Michael
 *
 * @param <S> The type.
 */
public interface GraphRepositoryForString<S> extends GraphRepository<S> {

	S findByName(String text);

	S findByName(String text, Long relatedId);

}
