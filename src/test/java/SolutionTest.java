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
        double delta = 0.000001;

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
        double delta = 0.000001;

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
        double delta = 0.000001;

        Assert.assertEquals(expected, actual, delta);
    }
}
