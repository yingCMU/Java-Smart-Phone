package Project.Model;

import java.io.Serializable;
import java.util.ArrayList;



class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3202608254778286360L;
	private  Option[] opts ;
	
	//private  Option[] opts;
	private String name;
	private int nextBucket=0;
	private final int DEFAULT_SIZE= 1;
	private void init(){
		for(int i=0;i<opts.length;i++)
		opts[i] = new Option();
	}
	protected OptionSet(String name, int optssize){
		opts = new Option[optssize];
		init();
		setName(name);
	}
	protected OptionSet(){
		/*opts = new Option[DEFAULT_SIZE]; 
		init();
		setName("no_name_given");*/
	}
	protected void print() {
        System.out.println("Option :"+ name);
        for(Option o: opts){
            System.out.println(o.toString());
        }
    }
	 protected void updateOpt(int i, String name, int price) {
	        try{
	            opts[i] = new Option(name, price);
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
	        	optsRemove(i);
	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	            System.err.printf("Error: %s", e);
	        }
	    }
	    private void optsRemove(int index){
	    	Option[] n = new Option[opts.length - 1];
	        System.arraycopy(opts, index+1, n, index, opts.length - index-1);
	        System.out.println("%%%%% removed ");
	        opts=n;
	        for(Option a:opts)	
	        	System.out.println(a.toString());
		        
	    }
	    protected void setOpt(int i, String name, int price) 
	    {
	        opts[i]= new Option(name, price);
	    }
	    
	    protected void putOpt(String name, int price)
	    {
	    	Option[] n = new Option[opts.length + 1];
	    	System.arraycopy(opts, 0, n, 0, opts.length );
	    	n[opts.length]=(new Option(name, price));
	    }
	    protected void addOpt(String name, int price)
	    {	System.out.println("--before addOpt next bucket is "+nextBucket);
	    System.out.println("opts.length->"+opts.length);
	    	if(nextBucket>=opts.length){
	    	Option[] n = new Option[opts.length +1];
	    	System.arraycopy(opts, 0, n, 0, opts.length );
	    	n[opts.length]=(new Option(name, price));
	    	opts=n;
	    	}
	    	else{
	    		opts[nextBucket++]=new Option(name, price);
	    	}
	    }
	protected Option[] getOpts() {
		return opts;
	}

	protected void setOpts(Option[] opts) {
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
	