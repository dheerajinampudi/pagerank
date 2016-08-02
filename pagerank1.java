package tests;
	import java.util.*;
	public class pagerank1 {
	  
	     int edges[][] = new int[10][10];//  for number of back links matrix formation 
	     double PR[] = new double[10]; // to determine the final page rank 
	  
	public void calc(double n) //method for calculating the pagerank iterations 
	{    
	 double init; // initial calc
	 double c=0;  // Normalising for the first time
	 double temp[] = new double[10]; // temp to use the calculation 
	 int iterations=1; // iterations
	 int i,j,k=1; // Initialising 
	 init = (1/n); // 0th steep to form A Matrix in B= X * A
	 // for the 0th iteration calculation 
	 System.out.printf(" n value:"+n+"\t init value :"+init+"\n");
	 for(i=1;i<=n;i++)
	   this.PR[i]=init;// referring the current object position with "this"
	   System.out.printf("\n Initial PageRank Values , 0th Step \n");
	    for(i=1;i<=n;i++)
	   System.out.printf(" Page Rank of "+i+" is :\t"+this.PR[i]+"\n");
	   
	  // for the rest of the 16 iterations 
	   while(iterations<=16)// number of iteration
	   {
	    for(i=1;i<=n;i++)
	    {  temp[i]=this.PR[i];
	          this.PR[i]=0;
	       }
	     
	 for(j=1;j<=n;j++)
	        for(i=1;i<=n;i++)
	     if(this.edges[i][j] == 1)
	     {  k=1;c=0; 
	           while(k<=n)
	     {
	       if(this.edges[i][k] == 1 )
	                   c=c+1;
	     k=k+1;
	     } 
	             this.PR[j]=this.PR[j]+temp[i]*(1/c);    
	      } 
	   
	  System.out.printf("\n After "+iterations+"th Step \n"); 
	     for(i=1;i<=n;i++) 
	      System.out.printf(" Page Rank of "+i+" is :\t"+this.PR[i]+"\n"); 
	   
	     iterations=iterations+1;
	    } 
	}
	 public static void main(String args[])
	    {
	        int nodes,i,j,cost;
	        Scanner in = new Scanner(System.in);
	        System.out.println("Enter the Number of WebPages \n");
	        nodes = in.nextInt();
	        pagerank1 p = new pagerank1();
	        System.out.println("Enter the Adjacency Matrix with 1->PATH & 0->NO PATH Between two WebPages: \n");
	        for(i=1;i<=nodes;i++)
	          for(j=1;j<=nodes;j++)
	          {
	            p.edges[i][j]=in.nextInt();
	            if(j==i)
	              p.edges[i][j]=0;
	          }
	        p.calc(nodes);
	    
	           
	    }   
	 


}
