package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Represents a non-directional graph where each vertex
 * is a Node object. Connections between nodes are based
 * on the cartesian coordinate system.
 * @author James Baumeister on 30/4/17
 */
public class Graph {
	
	/**
	 * Connects all nodes, building their E, W, S, N, NE, SE, NW, SW edges,
	 * in that order. The nodes should form a 10x10 square grid, and the array
	 * is such that every i'th node % 10 = 9 is a right edge.
	 * See the assignment specification for more information.
	 * @param nodes An array of Node objects to be connected
	 * @return An array of connected Node objects
	 */
	public void connectNodes(Node[] nodes) {
		ArrayList<Edge> edges = null;
		Node node = null;
		for (int i=0;i<nodes.length;i++) { 
			node = nodes[i];
			edges = new ArrayList<Edge>();
			int edge = i % 10;
			
			if (edge != 9) // west edge detect
				//add a east edge
				edges.add(new Edge(node, nodes[i+1]));
				
			if (edge != 0) // east edge detect
				//add a west edge
				edges.add(new Edge(node, nodes[i-1]));
			
			if (i+10<nodes.length)// detect out of bounds south edge
				//add south edge
				edges.add(new Edge(node, nodes[i+10]));
			
			if (i-10 >= 0) //detect out of bounds north edge
				//add north edge
				edges.add(new Edge(node, nodes[i-10]));
			
			
			if (i-9 >= 0 && edge != 0) //detect out of bounds north east edge
				edges.add(new Edge(node, nodes[i-9]));
			
			if (i+11<nodes.length && edge != 9) //detect out of bounds south east edge
				edges.add(new Edge(node, nodes[i+11]));

			if (i-11 >= 0 && edge != 0) //detect out of bounds north west edge
				edges.add(new Edge(node, nodes[i-11]));		

			if (i+9 < nodes.length && edge != 0) //detect out of bounds south west edge
				edges.add(new Edge(node, nodes[i+9]));
			
			node.setEdges(edges);
		}
	}
	
	/**
	 * Performs a breadth-first search of the graph and returns the shortest
	 * path from one node to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	public Node[] breadthFirstSearch(Node start, Node target) {
		
		Queue<Node> queue = new LinkedList<Node>(); 
		
		List<Node> visited = new ArrayList<Node>();
	    Map<Node, Node> parentMap = new HashMap<Node, Node>();
	    
		Node parent = start;
		queue.offer(start);
		visited.add(start);
		
		//while queue is empty
		while (!queue.isEmpty()){
			//get first Node in queue
			parent = queue.poll();
			//check if it is the target
			if (parent.equals(target)){
				break;
			} else {
				//get all edges
				for (Edge e : parent.getEdges()){
					//get the node of the edge
					Node neighbour = e.getNode2();
					//if the node hasn't been seen before
					if (!visited.contains(neighbour)){
						//put it in the queue for later traversing
						queue.offer(neighbour);
						//set it as visited so it can't be put in the queue again
						visited.add(neighbour);
						//give it the parent it was found at
						parentMap.put(neighbour, parent);	
					}
				}
			}
		}
		if (!parent.equals(target))
			return null;
		
		List<Node> path = new ArrayList<Node>();
		for (Node node = target; node != null; node = parentMap.get(node))
			path.add(node);
		
		Collections.reverse(path);
		return path.toArray(new Node[path.size()]);
	}

	/**
	 * Performs a depth-first search of the graph and returns the first-found
	 * path from one node to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	public Node[] depthFirstSearch(Node start, Node target) {

		
		// TODO
		return null;
	}
		
	/**
	 * Performs a search of the graph using Dijkstra's algorithm, which takes into
	 * account the edge weight. It should return the least-costly path from one node
	 * to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	public Node[] dijkstrasSearch(Node start, Node target) {
		// TODO
		return null;
	}
	
	/**
	 * Performs a search of the graph using the A* algorithm, which using a heuristic to optimise the
	 * direction of search. It should return the least-costly path from one node to another.
	 * @param start The node from which to start searching
	 * @param target The target node to which a path is built
	 * @return An array of Node objects representing the path from start to target, in that order
	 */
	public Node[] aStarSearch(Node start, Node target) {
		// TODO
		return null;
	}
	
	/**
	 * Searches for an edge from the source node to the destination.
	 * @param source The source, or first, node
	 * @param destination The destination, or second, node
	 * @return The edge between the nodes, or null if not found
	 */
	
	public Edge getEdge(Node source, Node destination) {
		List<Edge> srcEdges = source.getEdges();
		Edge e = new Edge(source,destination);
		for (Edge srcEdge : srcEdges){
			if (srcEdge.getNode2().equals(destination)){
				return srcEdge;
			}
		}
		return null;
	}
	
	/**
	 * From an array of Node objects, this calculates the total cost of
	 * travelling from the first to last nodes.
	 * @param vertices An array of Node objects representing a path
	 * @return The total cost of travel
	 */
	public double calculateCost(Node[] vertices) {
		return 0;//TODO
	}
}
