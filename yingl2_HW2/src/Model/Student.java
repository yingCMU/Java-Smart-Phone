package Model;

public class Student {
	  private int SID;
	  private int scores[] = new int[5];
	  //write public get and set methods for
	  //SID and scores
	  //add methods to print values of instance variables.
	public int getScores(int index) throws Exception {
		if(index >= 5){
			System.out.println();
			throw new Exception("score index out of bound -"+index);
			//return -1;
			
		}
		return scores[index];
	}
	public void setScores(int index, int score) throws Exception {
		if(index >= 5)
			throw new Exception();
		this.scores[index] = score;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
}
