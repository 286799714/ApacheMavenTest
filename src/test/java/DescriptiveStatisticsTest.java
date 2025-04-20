import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DescriptiveStatisticsTest {
    private static final DescriptiveStatistics commonStats = new DescriptiveStatistics();
    private static final double[] values = {1, 2, 2, 3, 4, 5, 6, 10};

    @BeforeAll
    public static void setUpBeforeClass() {
        for (double v : values) {
            commonStats.addValue(v);
        }
    }

    @Test
    public void testEmptyInputReturnsNaN() {
        DescriptiveStatistics stats = new DescriptiveStatistics();

        assertTrue(Double.isNaN(stats.getMean()));
        assertTrue(Double.isNaN(stats.getStandardDeviation()));
        assertTrue(Double.isNaN(stats.getPercentile(50)));
    }

    @Test
    public void testOneElementInput() {
        DescriptiveStatistics stats = new DescriptiveStatistics(1);
        stats.addValue(10);

        assertEquals(10.0, stats.getMean());
        assertEquals(10.0, stats.getStandardDeviation());
        assertEquals(10.0, stats.getPercentile(50));
    }

    @Test
    public void testCommonInput() {
        assertEquals(4.125, commonStats.getMean());
        assertEquals(2.9001231500945415, commonStats.getStandardDeviation());
        assertEquals(3.5, commonStats.getPercentile(50));
    }
}
