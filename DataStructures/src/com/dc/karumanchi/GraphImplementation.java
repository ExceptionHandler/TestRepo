package com.dc.karumanchi;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphImplementation 
{
	private long dist[];
	private long prev[];
	private LinkedList<Edge> edgesList = new LinkedList<>();
	
	
	
	public static void main(String[] args) 
	{
		
	}
}

class Edge
{
	private int u;
	private int v;
	private int weight;
	
	Edge(int u, int v, int weight)
	{
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
}

class DirectedWeightGraph
{
	private int V;
	private int E;
	private ArrayList<Edge> adj[];
	
	public DirectedWeightGraph(int V) 
	{
		adj = (ArrayList[]) new ArrayList[V];
	}
}