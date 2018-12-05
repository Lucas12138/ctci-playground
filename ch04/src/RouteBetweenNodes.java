import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.Assert.assertEquals;

/**
 * Given a DAG, find out if there's a route between 2 nodes.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-12-05 1:34 AM
 */
public class RouteBetweenNodes {

    private static class Graph {
        private Node[] nodes;
    }

    private static class Node {
        private String name;
        private boolean isVisited;
        private Node[] children;

        Node(String n) {
            name = n;
        }
    }

    public boolean search(Graph graph, Node start, Node end) {

        Queue<Node> q = new LinkedList<>();
        start.isVisited = true;
        q.offer(start);

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (Node child : tmp.children) {
                if (child.isVisited) {
                    continue;
                }

                if (child == end) return true;

                child.isVisited = true;
                q.offer(child);
            }
        }
        return false;
    }

    @Test
    public void test() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        c.children = new Node[0];
        d.children = new Node[0];
        e.children = new Node[0];

        b.children = new Node[2];
        b.children[0] = c;
        b.children[1] = d;

        a.children = new Node[2];
        a.children[0] = b;
        a.children[1] = e;

        Graph graph = new Graph();
        graph.nodes = new Node[] {a,b,c,d,e};

        assertEquals(search(graph, a, b), true);
        assertEquals(search(graph, a, d), true);
        assertEquals(search(graph, e, d), false);
        assertEquals(search(graph, c, d), false);
    }
}
