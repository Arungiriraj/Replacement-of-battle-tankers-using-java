package miniproject;
import java.util.Scanner;
public class Tanker {
	 private int tankerID;
	 private String tankerName;
     private int headCommanderID;
     private String headCommanderName;
     public Tanker() {
    	 this.headCommanderID=0;
    	 this.headCommanderName=null;
    	 this.tankerID=0;
    	 this.tankerName=null;
     }
     public Tanker(int tankerID,String tankerName,int headCommanderID,String headCommanderName) {
    	 
    	 this.tankerID=tankerID;
    	 this.tankerName=tankerName;
    	 this.headCommanderID=headCommanderID;
    	 this.headCommanderName=headCommanderName;
     }
     String getrepairType() {
     	Scanner ma=new Scanner(System.in);
     	System.out.println("Structural Repairs");
     	System.out.println("Track Repairs");
     	System.out.println("Engine and Powertrain Repairs");
     	System.out.println("Weapon System Repairs");
     	System.out.println("Electronics and Communication Repairs");
     	System.out.println("Auxiliary Equipment Repairs");
     	System.out.println("Enter the type of repair occured: ");
     	String type=ma.nextLine();
     	return type;
     }
     void update(int id,String name) {
    	 System.out.println("Specialist id: "+id);
    	 System.out.println("Specialist name: "+name);
         System.out.println("The problem has been rectified by the specialist with ID "+id+" and name "+name);
     }
}
