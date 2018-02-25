package com.dc.ads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


//MST - prim's algorithm
//Done
public class Graph 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the no of vertices and edges..");
		int vertices = Integer.parseInt(br.readLine());
		int noOfEdges = Integer.parseInt(br.readLine());
		
		//Look it carefully
		List<Edge>[] edges = new List[vertices];
		//initialize the edges
		for(int i=0; i<vertices; i++)
		{
			edges[i] = new ArrayList<>();
		}
		
		System.out.println("Enter the first vertex, second vertex and weight of them");
		for(int i=0; i<noOfEdges; i++)
		{
			int one = Integer.parseInt(br.readLine());
			int two = Integer.parseInt(br.readLine());
			int weight = Integer.parseInt(br.readLine());
			
			edges[one].add(new Edge(two, weight));
			edges[two].add(new Edge(one, weight));
		}
		
		//this array will contain predecessor of a vertex
		int[] pred = new int[vertices];
		long cost = primMST(edges, pred);
		
		System.out.println("The cost is..." + cost);
	}
	
	public static long primMST(List<Edge>[] edges, int[] pred)
	{
		int n = edges.length;
		Arrays.fill(pred, -1);
		
		boolean used[] = new boolean[n];
		int priorCost[] = new int[n];
		Arrays.fill(priorCost, Integer.MAX_VALUE);
		priorCost[0] = 0;
		
		PriorityQueue<Long> queue = new PriorityQueue<>();
		queue.add(0L);
		long res = 0;
		
		while( !queue.isEmpty() )
		{
			long val = queue.poll();
			int k = (int) val;
			
			//Detect cycle
			if(used[k])
				continue;
			used[k] = true;
			res += val >>> 32;
			
			for(Edge e : edges[k])
			{
				int secondVertex = e.edgeTwo;
				
				if( !used[secondVertex] && priorCost[secondVertex] > e.weight)
				{
					pred[secondVertex] = k;
					priorCost[secondVertex] = e.weight;
					queue.add( ( (long) priorCost[secondVertex] << 32) + secondVertex);
				}
			}
		}
		return res;
	}
	
	static class Edge
	{
		int edgeTwo;
		int weight;
		
		Edge(int two, int weight)
		{
			this.edgeTwo = two;
			this.weight = weight;
		}
	}
}
