package miniproject;
import java.util.*;
public class Main{
	static Controller con=Controller.getReference();
    public static void main(String[] args)throws Exception{
    	Scanner am=new Scanner(System.in);
    	System.out.println("Enter the username: ");
    	String username=am.nextLine();
    	System.out.println("Enter the password: ");
    	String password=am.nextLine();
    	boolean user=con.user(username,password);
    	if(true) {
    	int problem;
    	System.out.println("Enter 1 if there is any error else 0");
    	problem=am.nextInt();
        if(problem==0){
           con.update(problem);
        }
        else{
           System.out.println("Enter the further Details about the tanker:");
           System.out.println("Enter the tanker No: ");
           int tankerID=am.nextInt();
           con.setTankerId(tankerID);
           am.nextLine();
           System.out.println("Enter the tanker Name: ");
           String tankerName=am.nextLine();
           con.setTankerName(tankerName);
           System.out.println("Enter the Location No: ");
           int locationNo=am.nextInt();
           con.setLocationNo(locationNo);
           System.out.println("Type of problem Occurred: ");
           System.out.println("Enter 1 if the tanker is defected \nEnter 2 if repaired \nEnter 3 if no problem: ");
           int problemType=am.nextInt();
           if(problemType==1 || problemType==2) {
                  con.DefectedTankerDetails();
                  if(problemType==1) {
                     System.out.println("This is an defected tanker");
                  }
                  else {
                	 System.out.println("This is an repaired tanker");
                	 
                  }
           }
           else {
        	   System.out.println("There is no problem in the tanker");
           }
          con.problemUpdate(problemType);
          
        }
  }   
    }
    public void errorRepair(String type)throws Exception{
    	con.find(type);
   	    
    }
    public void updateRepair(int tankerID)throws Exception{
    	 con.repairUpdate(tankerID);
    }
    public void getShortestPath(int locationNo)throws Exception{
   	     con.path(locationNo);
    }
}  