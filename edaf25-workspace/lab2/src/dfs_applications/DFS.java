package dfs_applications;

import graph.Graph;

import java.util.Iterator;
import java.util.List;


public class DFS {

    public static <V, E> void dfs(Graph<V, E> g) {
        g.unvisit();
        for (Graph.Vertex<V, E> v : g) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
    }

    private static <V, E> void dfs(Graph.Vertex<V, E> v) {
        v.visit();
        for (Graph.Edge<V, E> e : v) {
            Graph.Vertex<V, E> w = e.destination();
            if (!w.isVisited()) {
                dfs(w);
            }
        }
    }

    public static <V, E> boolean isConnected(Graph<V, E> g) {
        g.unvisit();
        dfs(g.iterator().next());
        Iterator<Graph.Vertex<V, E>> itr = g.iterator();
        while (itr.hasNext()) {
            if (!itr.next().isVisited()) {
                return false;
            }
        }
        return true;
    }

    public static <V, E> int nbrOfComponents(Graph<V, E> g) {
        int sum = 0;
        if (isConnected(g)) {
            return 1;
        } else {
            g.unvisit();
            Iterator<Graph.Vertex<V, E>> itr = g.iterator();
            while (itr.hasNext()) {
                Graph.Vertex<V, E> temp = itr.next();
                if (!temp.isVisited()) {
                    dfs(temp);
                    sum++;
                }
            }
        }
        return sum;
    }

    public static <V, E> boolean pathExists(Graph<V, E> g,
        Graph.Vertex<V, E> v, Graph.Vertex<V, E> u) {
        g.unvisit();
        if (v.equals(u)) {
            return true;
        }
        System.out.println("-------------------START-------------------");
        return pathExists(v, u);
    }

    private static <V, E> boolean pathExists(Graph.Vertex<V, E> v, Graph.Vertex<V, E> u) {
        Iterator<Graph.Edge<V, E>> itr = v.iterator();
        while (itr.hasNext()) {
            System.out.println("Vector: " + v.toString());
            Graph.Edge<V, E> temp = itr.next();
            System.out.println("Edge link to: " + temp.destination().toString());
            if (!temp.destination().isVisited()) {
                temp.destination().visit();
                if (temp.destination().equals(u)) {
                    System.out.println("Found destination");
                    return true;
                } else {
                    System.out.println("Continue searching...");
                    if(pathExists(temp.destination(), u)){
                        return true;
                    }
                }
            }
        }
        System.out.println("No destination found");
        return false;
    }

    public static <V, E> List<Graph.Vertex<V, E>> findPath(Graph<V, E> g,
        Graph.Vertex<V, E> v, Graph.Vertex<V, E> u) {
        return null;
    }


}

