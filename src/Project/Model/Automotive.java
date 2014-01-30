package Project.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Automotive implements Serializable{ //This class will represent the Model.
	private static final long serialVersionUID = -5105910834572049363L;
	private String name;
	private  int basePrice;
	private final int DEFAUL_BASE_PRICE =  18445;
	private ArrayList<OptionSet> opset ;
	public Automotive(int OptionSetsize, String name)	{
	opset = new ArrayList<OptionSet>(OptionSetsize); 
	setName(name);
	basePrice = DEFAUL_BASE_PRICE;
	}
	public Automotive(String name,int baseprice, int OptionSetsize){
		opset = new ArrayList<OptionSet>(OptionSetsize); 
		setName(name);
		basePrice = baseprice;
	}
	
	
	public Automotive() {
		opset = new ArrayList<OptionSet>();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

	 public void deleteOptSet(int i){
	        try{
	            opset.remove(i);
	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	            System.err.printf("Error: %s", e);
	        }
	    }
	/*
	 * Find
		i. Find OptionSet with name
		ii. Find Option with name (in context of OptionSet)
	 */
	public OptionSet findSet(String name){
		for(int i=0; i < opset.size();i++){
            if(opset.get(i).getName().equalsIgnoreCase(name)){
            	return opset.get(i);
            }
		}
        return  null;
	}
	public int findSetIndex(String name){
		for(int i=0; i < opset.size();i++){
            if(opset.get(i).getName().equalsIgnoreCase(name)){
            	return i;
            }
		}
        return  -1;
	}
	public Option findOpt(String setname,String optname){
		OptionSet set = findSet(setname);
		if(set == null){
			System.err.println("no set "+setname +" found");
			return null;
		}
		ArrayList<Option> ops = set.getOpts();
		for(int i=0; i < ops.size();i++){
            if(ops.get(i).getName().equalsIgnoreCase(optname)){
            	return ops.get(i);
            }
		}
        return  null;
		
	}
	private int findOptIndex(String setname,String optname){
		OptionSet set = findSet(setname);
		if(set == null){
			System.err.println("no set "+setname +" found");
			return -1;
		}
		ArrayList<Option> ops = set.getOpts();
		for(int i=0; i < ops.size();i++){
            if(ops.get(i).getName().equalsIgnoreCase(optname)){
            	return i;
            }
		}
        return  -1;
		
	}
	public void deleteOpt(String setname,String optname){
		OptionSet set = findSet(setname);
		if(set == null){
			System.err.println("no set "+setname +" found");
			return ;
		}
		ArrayList<Option> ops = set.getOpts();
		for(int i=0; i < ops.size();i++){
            if(ops.get(i).getName().equalsIgnoreCase(optname)){
            	ops.remove(i);
            	System.out.println(setname+"-"+optname+" removed");
            	return ;
            }
		}
       System.out.println("remove failed");
	}
	/*
	 * Setteri. SetName
		ii. Set Base Price
		iii. Set values of OptionSet
		iv. Set values of Option (in context of OptionSet)
	 */
	/*
	 * Delete
		i. Delete an Option
		ii. Delete an OptionSet
		*/
	/*
 	Update (Find and Set)
		i. Update values of OptionSet
		ii. Update values of Options
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int price) {
		this.basePrice = price;
	}
	public OptionSet getOpSet (int index){
		if(index >=opset.size() || index <0)
			return null;
		return opset.get(index);
		
	}
	 public void addOptionSet(String name, int numOfOptions){
	        opset.add(new OptionSet(name, numOfOptions));
	    }
	 public void addOpt(String setName, String name, int price){
	        findSet(setName).addOpt(name, price);
	    }
	 public void updateOpt(String setName, String optname, int price){
	        OptionSet myset = findSet(setName);
	        Option myopt = findOpt(setName,optname);//.addOpt(name, price);
	        if(myopt == null){
	        	System.err.println("cannot find option "+optname);
	        	return;
	        }
	        myopt.update(optname, price);
	        System.out.println(optname+" updated->"+price);
	 }
	 public void updateOptSet(String setName){
	        int i = findSetIndex(setName);
	        if(i<0){
	        		System.out.println("can not find set-"+setName);
	        		return;
	        }
	       
	        System.out.println(name+" updated!");
	 }
	 public void print(){
		 
		 System.out.println("model :"+name+"\tbasePrice :"+basePrice);
		 for(OptionSet os:opset){
			 System.out.println("----------");
			 os.print();
		 }
	 }
	public void updateOpt(String setName, String optname, String price) {
		// TODO Auto-generated method stub
		try{
		int p= Integer.parseInt(price);
		updateOpt(setName,optname,p);
		}
		catch( NumberFormatException e){
			System.err.println("Error: invalid value of price, should be a number ");
		}
	}
	
	
}