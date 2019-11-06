package com.datastructure.exercice;

import java.util.ArrayDeque;
import java.util.Deque;

import com.datastructure.solution.Node;

public class BinaryTreeGoThrough {
	
	public static void main(String[] args) {
		Node root = new Node("root");
		Node cheese = new Node("cheese");
		Node choco = new Node("choco");
		Node egg = new Node("egg");
		Node bread = new Node("bread");
		Node nuts = new Node("nuts");
		Node orange = new Node("orange");
		Node jam = new Node("jam");
		Node ham = new Node("ham");

		root.setLeft(cheese);
		root.setRight(jam);
		cheese.setLeft(choco);
		cheese.setRight(ham);
		ham.setLeft(bread);
		ham.setRight(nuts);
		jam.setLeft(egg);
		jam.setRight(orange);
		
		BinaryTreeGoThrough.goThroughDepthFirst(root);
		System.out.println("-------------------------------");
		BinaryTreeGoThrough.goThroughBreadthFirst(root);
		
	}
	
	public static void goThroughDepthFirst(Node node) {		
		if (node==null) return;
		goThroughDepthFirst(node.getLeft());		
		goThroughDepthFirst(node.getRight());
		System.out.println(node.getData());
	}
	public static void goThroughBreadthFirst(Node node) {		
		if (node==null) return;
		Deque<Node> q = new ArrayDeque<>();
		q.addLast(node);
		while(!q.isEmpty()) {
			Node head = q.poll();
			System.out.println(head.getData());
			if (head.getLeft()!=null) q.addLast(head.getLeft());
			if (head.getRight()!=null) q.addLast(head.getRight());
		}
	}
}
