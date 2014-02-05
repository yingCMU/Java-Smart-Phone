package project2.Adapter;

import project2.exceptions.MissingModelException;
import project2.exceptions.MissingSetException;
import project2.model.Automobile;
import project2.util.FileUtil;

public class BuildAuto extends ProxyAutomobile implements
CreateAuto, UpdateAuto{

	@Override
	public void updateOptionSetName(String Modelname, String OptionSetname,
			String newName) {
		System.out.println("-------update option set name-------------");
		try {
			Automobile auto = getAuto(Modelname);
			auto.updateOptSet(OptionSetname,newName);
			
		} catch (MissingModelException e) {
			System.err.println(e.getMessage());
			return;
		} catch (MissingSetException e) {
			System.err.println(e.getMessage());
			return;
		}
		
	}

	

	@Override
	public void updateOptionPrice(String Modelname, String Optionset,
			String Optionname, float newprice) {
		System.out.println("-------update option price-------------");
		Automobile auto;
		try {
			auto = getAuto(Modelname);
			auto.updateOpt(Optionset, Optionname, newprice);
		} catch (MissingModelException e) {
			
			e.printStackTrace();
			System.exit(0);
		} catch (MissingSetException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
		
		
		
	}

	@Override
	public void BuildAuto(String filename) {
		System.out.println("-------build auto-------------");
		FileUtil fu= new FileUtil();
		Automobile auto = new Automobile();
		fu.buildAutoObject(filename, auto);
		addAuto(auto);
		
		
	}

	@Override
	public void printAuto(String Modelname) {
		System.out.println("-------print auto-------------");
		Automobile auto;
		try {
			auto = getAuto(Modelname);
			auto.print();
		} catch (MissingModelException e) {
			System.exit(0);
			e.printStackTrace();
		}
		
		
	}
}