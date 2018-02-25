package com.dc.karumanchi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.dc.ads.LinkedList;
import com.dc.ads.LinkedList.LLNode;

public class Sort0s1s2sinLinkedList 
{
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br.readLine();
		System.out.println("Enter the size of linkedlist");
		int size = Integer.parseInt(br.readLine());
		
		for(int i=0; i<size; i++)
		{
			int inp = Integer.parseInt(br.readLine());
			LinkedList.addNode(inp);
			
		}
		
		sort0s1s2s(LinkedList.root);
		printLL();
	}
	
	public static void sort0s1s2s(LLNode head)
	{
		LLNode oneNode, twoNode, zeroNode, ptr = head, tptr = null;
		oneNode = twoNode = zeroNode = null;
		
		
		if(head.getData() == 0)
		{
			zeroNode = head;
		}
		
		else if(head.getData() == 1)
		{
			oneNode = head;
		}
		else if(head.getData() == 2)
		{
			twoNode = head;
		}
		tptr = ptr;	
		ptr = ptr.getNext();
		
		while(ptr != null)
		{
			LLNode temp = ptr;
			
			//tptr.setNext(ptr.getNext());
			
			if(ptr.getData() == 0)
			{
				tptr.setNext(ptr.getNext());
				ptr = ptr.getNext();
				
				if(zeroNode == null)
				{
					temp.setNext(head);
					zeroNode = temp;
					head = temp;
				}
				else if(zeroNode != null)
				{
					temp.setNext(zeroNode.getNext());
					zeroNode.setNext(temp);
				}
			}
			else if(ptr.getData() == 1 )
			{
				tptr.setNext(ptr.getNext());
				ptr = ptr.getNext();
				
				if(oneNode == null)
				{
					
					if(zeroNode != null)
					{
						temp.setNext(zeroNode.getNext());
						oneNode = temp;
						zeroNode.setNext(oneNode);
					}
					else
					{
						temp.setNext(head);
						oneNode = temp;
						head = temp;
					}
					
				}
				else if(oneNode != null)
				{
					System.out.println("H");
					temp.setNext(oneNode.getNext());
					oneNode.setNext(temp);
				}
			}
			else
			{
				tptr = ptr;
			    ptr = ptr.getNext();
			}
				
		}
		
		LinkedList.root = head;
	}
	public static void printLL()
	{
		LLNode temp = LinkedList.root;
		while(temp!= null)
		{
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

}
