//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int count = 0;

        // Create a HashMap to store all elements of mat1
        Map<Integer, Integer> elements = new HashMap<>();
        
        // Traverse mat1 and store counts of all elements.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elements.put(mat1[i][j], elements.getOrDefault(mat1[i][j], 0) + 1);
            }
        }
        
        // Traverse mat2[][] and find pairs with sum x.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int complement = x - mat2[i][j];
                if (elements.containsKey(complement)) {
                    count += elements.get(complement);
                }
            }
        }
        
        return count;
    }
}
