/**
 *
 * @author Dheeraj Inampudi
 */

package tests;
import java.util.*;


public class PageRank {
	public double temp[] = new double[10];
    public double count[] = new double[10];
    public int backlink[][] = new int[10][10]; // paths bw the nodes
    public double PR[] = new double[10]; // pagerank

    
    // trying to implement the damping factor and normalization using Naviers approach
    public static double[] backlink(double[][] A) {
        double pr[] = new double[A.length];
        pr[0] = 1; // starting at node 0
        // Get the transition probabily matrix
        double P[][] = TPM(A, 0.85);
        int cout = 0;
        while (true) {
            double aux[] = new double[pr.length];
            // Begin of the iteration
            for (int j = 0; j < P.length; j++) {
                for (int i = 0; i < P.length; i++) {
                    aux[j] += (pr[i] * P[i][j]);
                }
            }
            // End of the iteration
            if (!converges(aux, pr) && cout < 100) {
                // Print the iteration
                System.out.print("Iteration " + ++cout + ": ");
                for (int i = 0; i < pr.length; i++) {
                    System.out.print(pr[i] + " ");
                }
                System.out.println();
                pr = aux;
            } else {
                break;
            }
        }
        return pr;
    }

  
public void PR(double n)
{    //Initialisation 
 double c=0; 
 int i;
 int j;
 @SuppressWarnings("unused")
int u=1,k=1;
 double init = 1/n;
 System.out.printf(" n value:"+n+"\t init value :"+init+"\n");
 System.out.printf("\n  initial Step \n");
 
 // looping for the first iteration
 for(i=1;i<=n;i++)
 	{
   this.PR[i]=init;
   System.out.printf(" Page Rank of "+i+" is :\t"+this.PR[i]+"\n");
    }
 for(i=1;i<=n;i++)
 {
	 	for(j=1;j<=n;j++)
	 	{
	 		if(this.backlink[i][j] == 1 )
	 		{        c= c+1;
	 		}
	 	}
	 count[i] = 1 / c;
 } 
 for(i=1;i<=n;i++)
 {
   System.out.printf(" Count of "+i+" is :\t"+count[i]+"\n");
  
 }
 
 while(u<=16)//iterations for 16 times to get the first result
   {
    for(i=1;i<=n;i++)//  initialisation to 0 for using pagerank again
    {  temp[i]=this.PR[i];
          this.PR[i]=0;
       }
     // if link exist then 1
 for(j=1;j<=n;j++)
 {
        for(i=1;i<=n;i++)
        {
     if(this.backlink[i][j] == 1)
     {  k=1;c=0; 
          this.PR[j]=this.PR[j]+temp[i]*count[i];  // Iterate
      } 
 }
   }
  System.out.printf("\n After "+u+"th Step \n"); 
     for(i=1;i<=n;i++) 
      System.out.printf(" Page Rank of "+i+" is :\t"+this.PR[i]+"\n"); 
   
     u=u+1;// incrementing u
    } 
}


 private static boolean converges(double[] aux, double[] pr2) {
	// TODO Auto-generated method stub
	return false;
}

private static double[][] TPM(double[][] a, double d) {
	// TODO Auto-generated method stub
	return null;
}

public static void main(String args[])// main function
    {
        int links;
        int i;
        int j;
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        System.out.println("Enter the Number of WebPages \n");
        links = input.nextInt();
        PageRank rank = new PageRank();
        System.out.println("Enter the Matrix with spaces \nenter 1 if backlink exist & 0 for no path \n");
        for(i=1;i<=links;i++)
          for(j=1;j<=links;j++)
          {
            rank.backlink[i][j]=input.nextInt();
            if(j==i)
              rank.backlink[i][j]=0;
          }
        
        rank.PR(links);
        double matrix[][] = {{0,1,0},{1,0,1},{0,1,0}};
        PR calc = new PR();
        
        double pr[] = backlink(matrix);
        
        for (int e = 0; e < pr.length; e++) {
            System.out.println(e + ": " + pr[e]);
        }
    
           
    }   
 
}
