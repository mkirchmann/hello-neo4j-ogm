package de.neuenberger.grocerylist.core.intf.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationContext {
	private SessionFactory sessionFactory;
	private Session openSession;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public ApplicationContext() {

	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			String basePackage = "de.neuenberger.grocerylist.model";
			sessionFactory = new SessionFactory(basePackage);
		}
		return sessionFactory;
	}

	public Session getSession() {
		if (openSession == null) {
			openSession = getSessionFactory().openSession();
		}
		return openSession;
	}
	
	public <S, G extends GraphRepositoryForString<S>> GraphRepositoryForString<S> getGraphRepository(Class<S> clazz) {
		return new GraphRepositoryForStringImpl<S>(this, clazz);
	}

	public <S, G extends GraphRepositoryForString<S>> GraphRepositoryForString<S> getGraphRepository(Class<S> clazz,
			String relatedEntity) {
		return new GraphRepositoryRelatedImpl<S>(this, clazz, relatedEntity);
	}

	public static class GraphRepositoryRelatedImpl<S> extends GraphRepositoryForStringImpl<S> {

		private String relatedClazz;

		public GraphRepositoryRelatedImpl(ApplicationContext context, Class<S> clazz, String relatedClazz) {
			super(context, clazz);
			this.relatedClazz = relatedClazz;
		}

		@Override
		public S findByName(String name, Long r) {
			String query = "MATCH (n:`" + clazz.getSimpleName() + "` {name:\"" + escape(name) + "\"})--(r) where id(r)="
					+ r + " return n";
			Map<String, String> parameters = new HashMap<>();
			return queryWithSingleResult(query, parameters);
		}

		public static String escape(String r) {
			return r.replaceAll("\\\\", "\\\\\\\\").replaceAll("\\\"", "\\\\\\\"");
		}
	}

	public static class GraphRepositoryForStringImpl<S> extends GraphRepositoryImpl<S>
			implements GraphRepositoryForString<S> {

		public GraphRepositoryForStringImpl(ApplicationContext context, Class<S> clazz) {
			super(context, clazz);
		}

		@Override
		public S findByName(String name) {
			Filter filter = new Filter();
			filter.setPropertyName("name");
			filter.setPropertyValue(name);
			Collection<S> loadAll = context.getSession().loadAll(clazz, filter);
			S result;
			logger.info("findByName('" + name + "') resulted in " + loadAll.size() + " results.");
			if (loadAll.isEmpty()) {
				result = null;
			} else {
				result = loadAll.iterator().next();
			}
			return result;
		}

		@Override
		public S findByName(String name, Long r) {
			throw new IllegalStateException("Not supported for this entity (" + clazz.getSimpleName() + ").");
		}
	}

	public static class GraphRepositoryImpl<S> implements GraphRepository<S> {
		protected final ApplicationContext context;
		protected final Class<S> clazz;
		protected final Logger logger = LoggerFactory.getLogger(getClass());

		public GraphRepositoryImpl(ApplicationContext context, Class<S> clazz) {
			this.context = context;
			this.clazz = clazz;
		}

		@Override
		public Iterable<S> findAll(Iterable<Long> nodeIds) {
			List<Long> listNodeIds;
			if (nodeIds instanceof List) {
				listNodeIds = (List<Long>) nodeIds;
			} else {
				listNodeIds = new LinkedList<>();
				for (Long l : nodeIds) {
					listNodeIds.add(l);
				}
			}
			return context.getSession().loadAll(clazz,listNodeIds);
		}

		@Override
		public Iterable<S> findAll() {
			return context.getSession().loadAll(clazz);
		}

		@Override
		public Iterable<S> findAll(int depth) {
			return context.getSession().loadAll(clazz, depth);
		}

		@Override
		public void delete(S arg0) {
			Session session = context.getSession();
			Transaction transaction = session.beginTransaction();
			context.getSession().delete(arg0);
			transaction.commit();
			transaction.close();
		}

		@Override
		public S save(S arg0) {
			Session session = context.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(arg0);
			transaction.commit();
			transaction.close();
			return arg0;
		}

		@Override
		public List<S> saveAll(List<S> items) {
			Session session = context.getSession();
			Transaction transaction = session.beginTransaction();
			for (S item : items) {
				session.save(item);
			}
			transaction.commit();
			transaction.close();
			return items;
		}



		public S queryWithSingleResult(String query, Map<String, ?> parameters) {
			Iterable<S> loadAllX = context.getSession().query(clazz, query, parameters);
			Iterator<S> loadAll = loadAllX.iterator();
			S result;

			// logger.info("findByName('" + name + "', " + r + ") resulted in "
			// + loadAll.size() + " results.");
			if (!loadAll.hasNext()) {
				result = null;
			} else {
				result = loadAll.next();
			}
			return result;
		}

		public List<S> queryWithResult(String query, Map<String, ?> parameters) {
			Iterable<S> loadAllX = context.getSession().query(clazz, query, parameters);
			List<S> list = new ArrayList<>();
			loadAllX.forEach(x -> list.add(x));
			logger.debug("Found " + list.size() + " from database.");
			return list;
		}

		@Override
		public S byGraphId(long id) {
			return context.getSession().load(clazz, id);
		}

		@Override
		public S byGraphId(Long id, int depth) {
			return context.getSession().load(clazz, id, depth);
		}

	}

	public static class GraphRepositoryForIntegerImpl<S> extends GraphRepositoryImpl<S>
			implements GraphRepositoryForInteger<S> {

		private String attributeName;

		public GraphRepositoryForIntegerImpl(ApplicationContext context, Class<S> clazz, String attributeName) {
			super(context, clazz);
			this.attributeName = attributeName;
		}

		@Override
		public S findByInteger(int value) {
			String query = "MATCH (n:`" + clazz.getSimpleName() + "` {" + attributeName + ":" + value + "}) return n";
			return queryWithSingleResult(query, new HashMap<>());
		}

	}

	public <S> GraphRepositoryForInteger<S> getGraphRepositoryForInt(Class<S> clazz, String attributeName) {
		return new GraphRepositoryForIntegerImpl<>(this, clazz, attributeName);
	}

	public <S> GraphRepositoryForString<S> getGraphRepositoryForString(Class<S> clazz) {
		return new GraphRepositoryForStringImpl<>(this, clazz);
	}

}
