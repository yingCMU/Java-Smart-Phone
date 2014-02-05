package project2.Adapter;
import java.util.LinkedHashMap;

import project2.exceptions.MissingModelException;
import project2.model.*;
public abstract class ProxyAutomobile {
	private static LinkedHashMap<String,Automobile> models = new LinkedHashMap<String,Automobile>();

	public Automobile getAuto(String name) throws MissingModelException {
		if(name==null || !models.containsKey(name))
			throw new MissingModelException("no model existing for "+name);
		else
			return models.get(name);
	}

	public void addAuto(Automobile a1) {
		models.put(a1.getModel(), a1);
	}

	public static LinkedHashMap<String,Automobile> getModels() {
		return models;
	}

	public static void setModels(LinkedHashMap<String,Automobile> models) {
		ProxyAutomobile.models = models;
	}
}



