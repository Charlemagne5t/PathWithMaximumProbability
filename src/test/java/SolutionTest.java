import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void maxProbabilityTest1() {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;

        double expected = 0.25000;
        double actual = new Solution().maxProbability(n, edges, succProb, start, end);
        double delta = 1e-5;

        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void maxProbabilityTest2() {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };
        double[] succProb = {0.5, 0.5, 0.3};
        int start = 0;
        int end = 2;

        double expected = 0.30000;
        double actual = new Solution().maxProbability(n, edges, succProb, start, end);
        double delta = 1e-5;

        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void maxProbabilityTest3() {
        int n = 3;
        int[][] edges = {
                {0, 1}
        };
        double[] succProb = {0.5};
        int start = 0;
        int end = 2;

        double expected = 0.00000;
        double actual = new Solution().maxProbability(n, edges, succProb, start, end);
        double delta = 1e-5;

        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void maxProbabilityTest4() {
        int n = 5;

        int[][] edges = {
                {1, 4},
                {2,4},
                {0,4},
                {0,3},
                {0,2},
                {2,3}
        };

        double[] succProb = {0.37,0.17,0.93,0.23,0.39,0.04};
        int start = 3;
        int end = 4;

        double expected = 0.21390;
        double actual = new Solution().maxProbability(n, edges, succProb, start, end);
        double delta = 1e-5;

        Assert.assertEquals(expected, actual, delta);
    }
}
