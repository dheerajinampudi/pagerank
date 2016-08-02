package tests;

import java.util.*;
public class PR {
  
    public int path[][] = new int[10][10];
    public double PR[] = new double[10];
  
public void calc(double n)
{    
 double init;
 double c=0; 
 double temp[] = new double[10];
 double count[] = new double[10];
 int i,j,u=1,k=1;
 init = 1/n;
 System.out.printf(" n value:"+n+"\t init value :"+init+"\n");
 System.out.printf("\n Initial PageRank Values , 0th Step \n");
 for(i=1;i<=n;i++)
 {
   this.PR[i]=init;
   System.out.printf(" Page Rank of "+i+" is :\t"+this.PR[i]+"\n");
    }
 for(i=1;i<=n;i++)
 {
	 c=0;
	 for(j=1;j<=n;j++)
	 {
   if(this.path[i][j] == 1 )
   {        c= c+1;
   }
	 }
	 count[i] = 1 / c;
 } 
 for(i=1;i<=n;i++)
 {
   System.out.printf(" Count of "+i+" is :\t"+count[i]+"\n");
    }
   while(u<=4)
   {
    for(i=1;i<=n;i++)
    {  temp[i]=this.PR[i];
          this.PR[i]=0;
       }
     
 for(j=1;j<=n;j++)
 {
        for(i=1;i<=n;i++)
        {
     if(this.path[i][j] == 1)
     {  k=1;c=0; 
          this.PR[j]=this.PR[j]+temp[i]*count[i];    
      } 
 }
   }
  System.out.printf("\n After "+u+"th Step \n"); 
     for(i=1;i<=n;i++) 
      System.out.printf(" Page Rank of "+i+" is :\t"+this.PR[i]+"\n"); 
   
     u=u+1;
    } 
}
 public static void main(String args[])
    {
        int nodes,i,j;
        Scanner a = new Scanner(System.in);
        System.out.println("Enter the Number of WebPages \n");
        nodes = a.nextInt();// input site
        PR p = new PR();
        System.out.println("Enter the Adjacency Matrix with 1->PATH & 0->NO PATH Between two WebPages: \n");
        for(i=1;i<=nodes;i++)// declaring the nodes from n
          for(j=1;j<=nodes;j++)
          {
            p.path[i][j]=a.nextInt();
            if(j==i)// link to and from the same node
              p.path[i][j]=0;// then 0
          }
        
        p.calc(nodes);
    
           
    }   
 
}
