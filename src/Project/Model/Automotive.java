package Project.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Automotive implements Serializable{ //This class will represent the Model.
	private static final long serialVersionUID = -5105910834572049363L;
	private String name;
	private  int basePrice;
	private final int DEFAUL_BASE_PRICE =  18445;
	private OptionSet[] opset ;
	
	public void init(){
		for(int i=0;i<opset.length;i++)
			opset[i] = new OptionSet();
			//for(int i=0;i<opt.length;i++)
			//opt[i] = new Option();
	}
	public Automotive(int OptionSetsize, String name)	{
	opset = new OptionSet[OptionSetsize]; 
	init();
	setName(name);
	basePrice = DEFAUL_BASE_PRICE;
	}
	public Automotive(String name,int baseprice, int OptionSetsize){
		opset = new OptionSet[OptionSetsize]; 
		init();
		setName(name);
		basePrice = baseprice;
	}
	
	
	public Automotive() {
		//opset = new OptionSet[1];
		//init();*/
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

	 public void deleteOptSet(int i){
	        try{
	        	opsetRemove(i);
	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	            System.err.printf("Error: %s", e);
	        }
	    }
	 private void opsetRemove(int index){
		 OptionSet[] n = new OptionSet[opset.length - 1];
	        System.arraycopy(opset, index+1, n, index, opset.length - index-1);
	        opset=n;
	 }
	/*
	 * Find
		i. Find OptionSet with name
		ii. Find Option with name (in context of OptionSet)
	 */
	public OptionSet findSet(String name){
		if(opset.length==0)
			return null;
		for(int i=0; i < opset.length;i++){
            if(opset[i].getName().equalsIgnoreCase(name)){
            	return opset[i];
            }
		}
        return  null;
	}
	public int findSetIndex(String name){
		for(int i=0; i < opset.length;i++){
            if(opset[i].getName().equalsIgnoreCase(name)){
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
		Option[] ops = set.getOpts();
		for(int i=0; i < ops.length;i++){
            if(ops[i].getName().equalsIgnoreCase(optname)){
            	return ops[i];
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
		Option[] ops = set.getOpts();
		for(int i=0; i < ops.length;i++){
            if(ops[i].getName().equalsIgnoreCase(optname)){
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
		
		Option[] ops = set.getOpts();
		for(int i=0; i < ops.length;i++){
            if(ops[i].getName().equalsIgnoreCase(optname)){
            	Option[] n = new Option[ops.length - 1];
            	System.arraycopy(ops, 0, n, 0, ops.length -1);
    	       System.arraycopy(ops, i+1, n, i, ops.length - i-1);
            	//System.arraycopy(ops ,i+1,ops,i,ops .length-1-i);
            	
            	set.setOpts(n);
            	System.out.println(setname+"-"+optname+" removed;\nsize:"+set.getOpts().length);
            	
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
		if(index >=opset.length || index <0)
			return null;
		return opset[index];
		
	}
	
	 public void addOptionSet(String name, int numOfOptions)
	    {   
		 	if(opset==null){
		 		opset= new OptionSet[ 1];
		 		opset[0]=new OptionSet(name, numOfOptions);
		 		return;
		 	}
	    	OptionSet[] n = new OptionSet[opset.length + 1];
	    	System.arraycopy(opset, 0, n, 0, opset.length );
	    	n[opset.length]=(new OptionSet(name, numOfOptions));
	    	opset = n;
	    }
	 public void addOpt(String setName, String name, int price){
	       OptionSet set = findSet(setName);
	       if(set==null){
	    	   System.err.println("set not found->"+setName);
	    	   System.exit(1);
	       }
	       //System.err.println("set ->"+set);
	       System.out.println("-: before add ,size now is "+set.getOpts().length);
	        set.addOpt(name, price);
	        System.out.println("add success size now is "+set.getOpts().length);
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