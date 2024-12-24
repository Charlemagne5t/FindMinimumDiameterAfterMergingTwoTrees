import java.util.*;
class Solution {
    int longestPathInSingleTree = 0;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int h1 = minHeight(edges1);
        int h2 = minHeight(edges2);
        return Math.max( longestPathInSingleTree, h1 + h2 + 1);
    }

    int minHeight(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        Map<Integer, Integer> neiCount = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> nei = g.getOrDefault(edge[0], new ArrayList<>());
            nei.add(edge[1]);
            g.put(edge[0], nei);
            int c = neiCount.getOrDefault(edge[0], 0);
            c++;
            neiCount.put(edge[0], c);

            nei = g.getOrDefault(edge[1], new ArrayList<>());
            nei.add(edge[0]);
            g.put(edge[1], nei);
            c = neiCount.getOrDefault(edge[1], 0);
            c++;
            neiCount.put(edge[1], c);
        }

        Deque<Integer> q = new ArrayDeque<>();
        int n = neiCount.size();
        for(Map.Entry<Integer, Integer> e : neiCount.entrySet()) {
            if(e.getValue() == 1) {
                q.offer(e.getKey());
                n--;
            }
        }

        int res = 0;

        while(q.size() > 1) {
            int size = q.size();
            if(n == 2) {
                longestPathInSingleTree = Math.max (longestPathInSingleTree, (res + 1) * 2 + 1);
                return res + 2;
            }
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                List<Integer> neis = g.get(cur);
                for(int nei : neis) {
                    if(neiCount.get(nei) != 1) {
                        int c = neiCount.get(nei);
                        c--;
                        if(c == 1) {
                            q.offer(nei);
                            n--;
                        }
                        neiCount.put(nei, c);
                    }
                }
            }

            res++;
            longestPathInSingleTree = Math.max (longestPathInSingleTree, res * 2);
        }

        return res;


    }
}