package tests;



for(i=1;i<=nodes;i++)
    for(j=1;j<=nodes;j++)
    {
      p.path[i][j]=input.nextInt();
      if(j==i)
        p.path[i][j]=0;
    }





import java.util.Scanner;

public class MatMult
{
    public static void main(String args[])
    {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no:of websites");
        n = input.nextInt();
        int init = (1/n);
        int i;
        int a [] = new int [n];
        int b [][] = new int[n][n];
        int c [][]= new int[1][n];
        
        for (int j = 0; j < n; j++)
            {
                this.a[j] = init;
                
            }
            System.out.printf("\n Initial PageRank Values , 0th Step \n");
    	    for(i=1;i<=n;i++)
    	    {
    	   System.out.printf(" Page Rank of "+i+" is :\t"+this.a[i]+"\n");
    	    }
        
        System.out.println("Enter the elements of 2nd martix row wise \n");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                b[i][j] = input.nextInt();
            }
        }
        System.out.println("Multiplying the matrices...");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("The product is:");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}