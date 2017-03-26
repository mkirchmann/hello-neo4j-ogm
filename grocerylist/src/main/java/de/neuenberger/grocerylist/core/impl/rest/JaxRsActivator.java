package de.neuenberger.grocerylist.core.impl.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
	
//	@PostConstruct
//	public void customInit() {
//		final ResourceConfig rc = new PackagesResourceConfig(getClass().getPackage().getName());
//	    final Map<String, Object> config = new HashMap<String, Object>();
//	    config.put("com.sun.jersey.api.json.POJOMappingFeature", true);
//	    rc.setPropertiesAndFeatures(config);
//	}
//	
//	@Override
//	public Set<Class<?>> getClasses() {
//		Set<Class<?>> s = new HashSet<>();
//		s.add(AddressRestImpl.class);
//		s.add(DummyImpl.class);
//		return s;
//	}
}
