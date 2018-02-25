package com.dc.ads;

public class LinkedList 
{
	public static LLNode root;
	
	public static void addNode(int data)
	{
		LLNode node = new LLNode(data);
		LLNode temp = null;
		
		if(root == null)
		{
			root = node;
		}
		
		else
		{
			temp = root;
			
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			
			temp.setNext(node);
		}
	}
	
	public static class LLNode
	{
		private int data;
		private LLNode next;
		
		public LLNode(int data)
		{
			this.data = data;
			next = null;
		}
		
		public int getData()
		{
			return this.data;
		}
		
		public void setData(int data)
		{
			this.data = data;
		}

		public LLNode getNext() {
			return next;
		}

		public void setNext(LLNode next) {
			this.next = next;
		}
	}
	
}