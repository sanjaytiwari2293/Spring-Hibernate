package com.hibernate.demo;

public class temp {


		 
	    // fucntion that returns the count of
	    // subarrays with m odd numbers   
	       static int countSubarrays(int a[],
	                              int n, int m)
	    {
	         
	        int count = 0;
	 
	        // traverse for all possible
	        // subarrays
	        for (int i = 0; i < n; i++) 
	        {
	            int odd = 0;
	            for (int j = i; j < n; j++) 
	            {
	                if (a[j] % 2 ==0)
	                    odd++;
	     
	                // if count of odd numbers
	                // in subarray is m
	                if (odd == m)
	                    count++;
	            }
	        }
	         
	        return count;
	    }
	     
	    // Driver code
	    public static void main (String[] args)
	    {
	        int a[] = { 6,3,5,8 };
	        int n = a.length;
	        int m = 0;
	         
	        System.out.println(countSubarrays(a, n, m));
	    }
	}


