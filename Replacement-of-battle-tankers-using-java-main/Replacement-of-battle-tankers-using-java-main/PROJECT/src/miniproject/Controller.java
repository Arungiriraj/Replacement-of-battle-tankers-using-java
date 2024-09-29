package miniproject;
import java.util.Scanner;
import java.util.*;
public class Controller{
	DBConnection obj=new DBConnection();
	Repair rep=new Repair();
	Defected def=new Defected();
	static Controller ref=null;
    private int tankerID;
    private String tankerName;
    private int headCommanderID;
    private String headCommanderName;
    private int locationNo;
    private String locationName;
    private int specialistID;
    private String specialistName;
    private Controller(){
       this.tankerID=0;
       this.tankerName="";
       this.headCommanderID=0;
       this.headCommanderName="";
       this.locationNo=0;
       this.locationName="";
       this.specialistID=0;
       this.specialistName="";
    } 
    private Controller(int tankerID,String tankerName,int headCommanderID,String headCommanderName,int locationNo,String locationName,int specialistId,String specialistName){
       this.tankerID=tankerID;
       this.tankerName=tankerName;
       this.headCommanderID=headCommanderID;
       this.headCommanderName=headCommanderName;
       this.locationNo=locationNo;
       this.locationName=locationName;
       this.specialistID=specialistID;
       this.specialistName=specialistName;
    } 
    static public Controller getReference() {
			if(ref==null) {
				ref=new Controller();
				return ref;
			}
			else {
				return ref;
			}
		}
    public void setTankerId(int tankerID){
          this.tankerID=tankerID;
    }
     public void setTankerName(String tankerName){
          this.tankerName=tankerName;
    }
     public void setHeadCommanderID(int headCommanderID){
          this.headCommanderID=headCommanderID;
    }
     public void setHeadCommanderName(String headCommanderName){
          this.headCommanderName=headCommanderName;
    }
     public void setLocationNo(int locationNo){
          this.locationNo=locationNo;
    }
     public void setLocationName(String locationName){
          this.locationName=locationName;
    }
     public void setSpecialistID(int specialistID){
          this.specialistID=specialistID;
    }
     public void setSpecialistName(String specialistName){
          this.specialistName=specialistName;
    }
    public int getTankerId(){
          return tankerID;
    }
     public String getTankerName(){
          return tankerName;
    }
     public int getHeadCommanderID(){
          return headCommanderID;
    }
     public String getHeadCommanderName(){
          return headCommanderName;
    }
     public int getLocationNo(){
          return locationNo;
    }
     public String getLocationName(){
          return locationName;
    }
     public int getSpecialistID(){
          return specialistID;
    }
     public String getSpecialistName(){
          return specialistName;
    }
     boolean user(String username,String password) {
     	if(username=="admin" && password=="admin")
     		return true;
     	return true;
     }
    public void DefectedTankerDetails()
    {
         System.out.println("Tanker ID: "+tankerID+"\nTanker Name: "+tankerName+"\nLocation No: "+locationNo);
    }
    public void update(int problem){
    	if(problem==0) {
    		System.out.println("Continue Protection");
    	}
    }
    public void problemUpdate(int problemType) throws Exception {
    	if(problemType==2) {
    		obj.getConnection();
    		obj.Repairedupdate(tankerID);
    		String problem="repaired";
    		repairedTanker(problem);
    	}
    	else {
    		obj.getConnection();
    		obj.Defectedupdate(tankerID);
    		String problem="defected";
    		defectedTanker(problem);
    	}
    }
    public void repairedTanker(String problem) throws Exception {
    	obj.getConnection();
    	rep.rectifyRepair(problem,tankerID,tankerName,locationNo);
    }
    public void defectedTanker(String problem) throws Exception {
    	def.rectify(problem,tankerID,tankerName,locationNo);
    }
    public void find(String type)throws Exception {
    	int id=obj.specID_find(type);
   	    String name=obj.specName_find(type);
   	    rep.update(id,name);
    }
    public void repairUpdate(int tankerID) throws Exception {
    	obj.updateCondition(tankerID);
    }
    public void path(int locationNo)throws Exception {
    	int[][] arr=getFieldDetails();
    	int res=def.details(arr,locationNo);
    	obj.getConnection();
    	obj.updateRectified(tankerID);
    	def.update();
    }
    public int[][] getFieldDetails() {
    	int arr[][]= {{3,4,5,7,8,6},{4,7,6,12,11,3},{1,13,7,7,6,5},{2,12,9,17,4,3},{6,8,4,4,3,2},{3,5,8,10,15,45},{4,5,3,7,13,1},{8,6,10,7,16,5}};
    	return arr;
    }
}
