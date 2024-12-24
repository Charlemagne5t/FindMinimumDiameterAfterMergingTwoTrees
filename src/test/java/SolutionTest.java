import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[][] edges1 = {
                {0,1},
                {0,2},
                {0,3},
                {2,4},
                {2,5},
                {3,6},
                {2,7},
        };
        int[][] edges2 = {
                {0,1},
                {0,2},
                {0,3},
                {2,4},
                {2,5},
                {3,6},
                {2,7},
        };
        int expected = 5;
        int actual = new Solution().minimumDiameterAfterMerge(edges1, edges2);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void test2() {
        int[][] edges1 = {
                {0, 1},
                {2, 0},
                {3, 2},
                {3, 6},
                {8, 7},
                {4, 8},
                {5, 4},
                {3, 5},
                {3, 9}
        };
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {0, 3}
        };
        int expected = 7;
        int actual = new Solution().minimumDiameterAfterMerge(edges1, edges2);

        Assert.assertEquals(expected, actual);
    }
}
