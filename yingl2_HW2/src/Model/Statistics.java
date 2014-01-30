package Model;


public class Statistics implements StatisticsInterface
{
  int [] lowscores = new int [5];
  int [] highscores = new int [5];
  float [] avgscores = new float [5];
  /*This method will find lowest score and store 
   * it in an array names lowscores
   */
  public void findlow(Student [] a) {
	  if(a[0]==null)
		  return;
	  try {
	  for(int i=0; i<5; i++)
		  lowscores[i]=a[0].getScores(i);
      for(int i=0; i<a.length; i++){
    	  if(a[i]==null)
    		  break;
    	  for(int j=0;j<5;j++){
    		  
				if(a[i].getScores(j)<lowscores[j])
					  lowscores[j]=a[i].getScores(j);
			
    	  }
      }
	  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      System.out.print("Low Score\t");
      for(int i=0;i<5; i++)
    	  System.out.print(lowscores[i]+"\t");
      System.out.println();
  }
 
  public void findhigh(Student [] a){
      //This method will find highest score and store it in an array names highscores
	  if(a[0]==null)
		  return;
	  try {
	  for(int i=0; i<5; i++)
		  highscores[i]=a[0].getScores(i);
      for(int i=0; i<a.length; i++){
    	  if(a[i]==null)
    		  break;
    	  for(int j=0;j<5;j++){
    		  
				if(a[i].getScores(j)>highscores[j])
					  highscores[j]=a[i].getScores(j);
			
    	  }
      }
	  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      System.out.print("High Score\t");
      for(int i=0;i<5; i++)
    	  System.out.print(highscores[i]+"\t");
      System.out.println();
  }

  public void findavg(Student [] a){
       //This method will find avg score for each quiz and store it in an array names avgscores
	  if(a[0]==null)
		  return;
	  int i = 0;
	  try {
	  for(i=0; i<a.length; i++){
    	  if(a[i]==null){
    		  break;
    	  }
    	  for(int j=0;j<5;j++){
    		  avgscores[j]+=a[i].getScores(j);
			
    	  }
      }
	  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      System.out.print("Average Score\t");
      for(int j=0;j<5; j++)
    	  System.out.printf("%.1f\t",avgscores[j]/i);
      	 // format conversion
      System.out.println();
  }
  //add methods to print values of instance variables.
  void print(Student [] a){
	  for(int i=0; i<a.length; i++){
		  if(a[i]==null)
			  break;
		  System.out.println("No. "+i);
    	  for(int j=0;j<5;j++){
    		  System.out.println(a[i].getSID()+"\t");
    	  }
	  }
	  
  }
  
}
