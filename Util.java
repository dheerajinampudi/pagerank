package tests;
 import java.util.*;
/**
 *
 * @author Dheeraj Inampudi
 */
public class Util {

    /**
     * Create the transition probability matrix 
     * Assumptions: A is a square matrix, alpha is between 0 and 1
     * @param A adjacency matrix of the graph
     * @param alpha probability of the teleport operation
     * @return
     */
    public double[][] TPM(double[][] A, double alpha) {
        double aux[] = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                // TODO: make a better comparison
                if (A[i][j] > 0) {
                    aux[i]++;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (aux[i] > 0) {
                    A[i][j] = ((A[i][j] / aux[i]) * (1 - alpha)) + (alpha / A.length);
                } else {
                    A[i][j] = 1 / A.length;
                }
            }
        }
        return A;
    }

    /***
     * PageRank algorithm based on the book "An Introduction to
     * Information Retrieval" of Christopher D. Manning et. al.
     * Assumptions: A is a square matrix
     * @param A adjacency matrix of the graph
     * @return vector of pagerank
     */
    public double[] backlink(double[][] A) {
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

    /**
     * Naive algorithm to check whether the iteration converges
     * @param xt1
     * @param xt2
     * @return 
     */
    private boolean converges(double xt1[], double xt2[]) {
        double error = 0.000001;
        for (int i = 0; i < xt1.length; i++)
            if (Math.abs(xt1[i] - xt2[i]) > error)
                return false;
        return true;
    }
    
    // This method is in another class
    public static void main(String[] args) {
    	int j;
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter the Number of WebPages \n");
    	// double nodes[][] =  in.nextDouble();
        double matrix[][] = {{0,1,0},{1,0,1},{0,1,0}};
        Util util = new Util();
        
        double pr[] = util.backlink(matrix);
        
        for (int i = 0; i < pr.length; i++) {
            System.out.println(i + ": " + pr[i]);
        }
    }

	
}