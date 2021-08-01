package basics;
import java.util.*; 
class Node 
{
	int adjacent;
	int distance;
	int width;
	int curr_soil_type;
	int to_soil_type;
	double angle;
	
	Node(int adjacent,int distance,int width,int curr_soil_type,int to_soil_type,double angle)
	{
		this.adjacent= adjacent;
		this.distance=distance;
		this.width=width;
		this.curr_soil_type=curr_soil_type;
		this.to_soil_type=to_soil_type;
		this.angle=angle;
		
	}
	Node(){};
	
	int getAdjacent()
	{
		return adjacent;
	}
	int getDistance()
	{
		return distance;
	}
	int getWidth()
	{
		return width;
	}
	int getCurr()
	{
		return curr_soil_type;
	}
	int getTo()
	{
		return to_soil_type;
	}
	double getAngle()
	{
		return angle;
	}
}
/* 2==>black soil==> yes;
 * 3==> hard soil==>yes
 * 1==> clay soil==> no
 * 0==> loose soil==>no
 * 
 * 
 */
public class shortest_path {
	int max=100000000;
	int minindex (boolean[] vis,int[] dis)
	{
		int min=Integer.MAX_VALUE;
		int minindex=-1;
		for(int i=0;i<dis.length;i++)
		{
			if(vis[i]==false && dis[i]<min)
			{
				min=dis[i];
				minindex=i;
			}
		}
		return minindex;
		
	}
	void vehicle1_fucntion(int start,ArrayList<ArrayList<Node>> adj,int n)
	{
		double v1_angle=40.0;
		int v1_width=6;
		int dis[]= new int[n];
		boolean vis[]=new boolean[n];
		
		for(int i=0;i<n;i++)
		{
			vis[i]=false;
			dis[i]=max;
		}
		dis[start]=0;
		while(true)
		{
			int u=minindex(vis,dis);
			if(u==-1)
			{
				break;
			}
			vis[u]=true;
			for(int i=0;i<adj.get(u).size();i++)
			{
				int v=adj.get(u).get(i).getAdjacent();
				int cost=adj.get(u).get(i).getDistance();
				int curr_soil=adj.get(u).get(i).getCurr();
				int to_soil=adj.get(u).get(i).getTo();
				int wid=adj.get(u).get(i).getWidth();
				double ang=adj.get(u).get(i).getAngle();
				
				
				if(vis[v]==false && cost+dis[u]<dis[v] 
						&& wid>=v1_width 
						&& ang>=v1_angle 
						&& curr_soil>=2 && to_soil>=2)
				{
					dis[v]=dis[u]+cost;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
			for(int i=0;i<n;i++)
			{
				if(dis[i]!=max)
				{
				
				sb.append(i+"--->");
		
			   }
				
			}
			System.out.println(sb.toString().substring(0,sb.length()-4));
		}
			
		
		
			
			
		 public static void main(String[] args)
       {
    	   int n=5;
    	   ArrayList<ArrayList<Node>> adj= new ArrayList<ArrayList<Node>>();
    	   for(int i=0;i<n;i++)
    	   {
    		   adj.add(new ArrayList<Node>());
    	   
          }
    	   
    	   adj.get(0).add(new Node(1,1,6,2,2,44.5));
    	   adj.get(0).add(new Node(2,4,5,1,1,40.6));
    	   
    	   //adj.get(1).add(new Node(0,1,6,2,2,44.5));
    	   adj.get(1).add(new Node(4,5,7,3,3,55.8));
    	   adj.get(1).add(new Node(3,1,8,3,3,60.8));
    	   
    	   adj.get(2).add(new Node(3,4,5,1,1,30.4));
    	   adj.get(2).add(new Node(1,7,6,1,1,40.2));
    	
    	   adj.get(3).add(new Node(4,1,9,2,2,50.6));
    	   int u=0;
    	   for(int i=0;i<adj.get(u).size();i++)
    	   {
    		   int v=adj.get(u).get(i).getAdjacent();
				int cost=adj.get(u).get(i).getDistance();
				int curr_soil=adj.get(u).get(i).getCurr();
				int to_soil=adj.get(u).get(i).getTo();
				int wid=adj.get(u).get(i).getWidth();
				double ang=adj.get(u).get(i).getAngle();
				System.out.println(v +"  "+cost+ " " +ang);
    	   }
   
    	   if(u==0)
    	   {
    
    	   shortest_path obj=new shortest_path();
    	   obj.vehicle1_fucntion(0,adj,n);
    	   }
}
}