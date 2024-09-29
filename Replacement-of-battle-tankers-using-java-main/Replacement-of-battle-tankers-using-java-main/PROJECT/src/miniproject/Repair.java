package miniproject;
public class Repair {
	 Tanker tanker=new Tanker();
     Main ma=new Main();
     public void rectifyRepair(String problem,int tankerID,String tankerName,int locationNo) throws Exception {
    	 String type=tanker.getrepairType();
    	 ma.errorRepair(type);
    	 ma.updateRepair(tankerID);
     }
     public void update(int id,String name) {
    	 tanker.update(id,name);
     }
}
