package Project.Model;

import java.io.Serializable;
import java.util.ArrayList;



class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3202608254778286360L;
	private  ArrayList<Option> opts ;
	//private  Option[] opts;
	private String name;
	private final int DEFAULT_SIZE= 1;
	
	protected OptionSet(String name, int optssize){
		setOpts(new  ArrayList<Option>(optssize)); 
		setName(name);
	}
	protected OptionSet(){
		setOpts(new  ArrayList<Option>(DEFAULT_SIZE)); 
		setName("no_name_given");
	}
	protected void print() {
        System.out.println("Option :"+ name);
        for(Option o: opts){
            System.out.println(o.toString());
        }
    }
	 protected void updateOpt(int i, String name, int price) {
	        try{
	            opts.set(i, new Option(name, price));
	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	            System.err.printf("Error: %s", e);
	        }
	    }
	    
    
	/**
	    * Delete the option base on the specified index location. 
	    * @param i
	    */
	    protected void deleteOpt(int i){
	        try{
	            opts.remove(i);
	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	            System.err.printf("Error: %s", e);
	        }
	    }
	    protected void setOpt(int i, String name, int price) 
	    {
	        opts.set(i, new Option(name, price));
	    }
	    
	    protected void addOpt(String name, int price)
	    {
	        opts.add(new Option(name, price));
	    }
	protected ArrayList<Option> getOpts() {
		return opts;
	}

	protected void setOpts(ArrayList<Option> opts) {
		this.opts = opts;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}
/*
private void init(){
	for(int i=0;i<opset.length;i++){
		opset[i] = new OptionSet();
		for(int j=0;j<opset[i].opt.length;j++)
			opset[i].opt[j] = new Option();
	}
}
*/
class Option implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float price;
	 protected Option() {
            
     }
        
    protected Option(String name){
        this.name = name;
    }
    protected void update(String name, int price){
    	this.name = name;
    	this.price = price;
    	
    }
    protected Option(int price){
        this.price = price;
    }
	protected Option(String name, int price) {
		this.name = name;
		this.price = price;
	}
	protected String getName() {
		return name;
	}
	public String toString(){
		return "["+name+","+price+"]";
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected float getPrice() {
		return price;
	}
	protected void setPrice(float price) {
		this.price = price;
	}
}
	