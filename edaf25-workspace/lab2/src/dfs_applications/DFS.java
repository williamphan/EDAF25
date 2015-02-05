package dfs_applications;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph.Graph;


public class DFS  {
	
	public static <V,E> void dfs(Graph<V,E> g) {
		g.unvisit();
		for (Graph.Vertex<V,E> v : g) {
			if (!v.isVisited()) {
				dfs(v);
			}
		}
	}
	
	private static <V,E> void dfs(Graph.Vertex<V,E> v) {
		v.visit();
		for (Graph.Edge<V,E> e : v) {
			Graph.Vertex<V,E> w = e.destination();
			if (!w.isVisited()) {
				dfs(w);
			}
		}
	}
	
	public static <V,E> boolean isConnected(Graph<V,E> g) {
		return false;
	}
	
	public static <V,E> int nbrOfComponents(Graph<V,E> g) {
		return 0;
	}
	
	public static <V,E> boolean pathExists(Graph<V,E> g,
			Graph.Vertex<V,E> v, Graph.Vertex<V,E> u) {
		return false;
	}
		
	public static <V,E> List<Graph.Vertex<V,E>> findPath(Graph<V,E> g,
			Graph.Vertex<V,E> v, Graph.Vertex<V,E> u) {
		return null;
	}
	

}

