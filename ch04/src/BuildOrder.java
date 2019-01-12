import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given a list of project dependencies, determine if it's possible to build all the projects.
 * If valid, return a build order.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-11 11:10 AM
 */
public class BuildOrder {


    private String[] findBuildOrder(String[] projects, String[][] dependencies) {
        if (projects == null || dependencies == null || projects.length == 0) return null;

        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String project : projects) {
            map.put(project, new ArrayList<>());
            indegree.put(project, 0);
        }

        for (String[] dependency : dependencies) {
            indegree.put(dependency[1], indegree.get(dependency[1]) + 1);
            map.get(dependency[0]).add(dependency[1]);
        }

        Queue<String> q = new LinkedList<>();
        for (String project : projects) {
            if (indegree.get(project) == 0) {
                q.offer(project);
            }
        }

        List<String> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i += 1) {
                String p = q.poll();
                order.add(p);
                for (String next : map.get(p)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        if (order.size() == projects.length) {
            return order.toArray(new String[projects.length]);
        }else {
            return null;
        }
    }


    @Test
    public void test() {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[][] {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        assertEquals(Arrays.toString(findBuildOrder(projects, dependencies)), "[e, f, b, a, d, c]");

        dependencies = new String[][] {{"a", "d"}, {"f", "b"}, {"b", "f"}, {"f", "a"}, {"d", "c"}};
        assertEquals(findBuildOrder(projects, dependencies), null);
    }
}
