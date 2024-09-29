package miniproject;

public class Defected {
   Main tank=new Main();
   Tanker obj1=new Tanker();
   public void rectify(String problem,int tankerID,String tankerName,int locationNo)throws Exception {
	   tank.getShortestPath(locationNo);
   }
   public int details(int arr[][],int locationNo) {
	   int source=locationNo;
	   Path p=new Path();
	   int[] res=p.dijkstra(arr,source-1);  
	   int min=res[0];
	   for(int i=0;i<6;i++) {
		   if(res[i]<min) {
			   min=res[i];
		   }
	   }
	   return min;
   }
   public void update() {
	   System.out.println("Shortest distance has been found and the tanker has been replaced");
   }
   static class Path{
	   static final int totalVertex =6;  
	   int minimumDistance(int distance[], Boolean spSet[])  
	   {  
	   int m = Integer.MAX_VALUE, m_index = -1;  
	     for (int vx = 0; vx < totalVertex; vx++)  
	   {  
	   if (spSet[vx] == false && distance[vx] <= m)   
	   {  
	   m = distance[vx];  
	   m_index = vx;  
	   }  
	   }  
	   return m_index;  
	   }  
	   int[] printSolution(int distance[], int n)  
	   {  
	   System.out.println("The shortest Distance from source source node to all other nodes are: ");  
	   for (int j = 0; j < n; j++)  
	   System.out.println("To " + j + " the shortest distance is: " + distance[j]);  
	   return distance;
	   }  
	   int[] dijkstra(int graph[][], int s)  
	   {  
	   int distance[] = new int[totalVertex];   
	   Boolean spSet[] = new Boolean[totalVertex];  
	   for (int j = 0; j < totalVertex; j++)   
	   {  
	   distance[j] = Integer.MAX_VALUE;  
	   spSet[j] = false;  
	   }  
	   distance[s] = 0;   
	   for (int cnt = 0; cnt < totalVertex - 1; cnt++)   
	   {    
	   int ux = minimumDistance(distance, spSet);  
	   spSet[ux] = true;  
	   for (int vx = 0; vx < totalVertex; vx++)  
	   if (!spSet[vx] && graph[ux][vx] != -1 && distance[ux] != Integer.MAX_VALUE && distance[ux] + graph[ux][vx] < distance[vx])  
	   {  
	   distance[vx] = distance[ux] + graph[ux][vx];  
	   }  
	   }  
	   int[] res=printSolution(distance, totalVertex);
	   return res;
	   
      }
   }
}
