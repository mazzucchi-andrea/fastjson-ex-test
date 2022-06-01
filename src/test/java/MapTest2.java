import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class MapTest2 {
    private String jsonStr;
    private Object[] actualValues;
    private Object[] expectedValues;

    public MapTest2() {
        configure();
    }

    private void configure() {
        this.jsonStr = "{1:\"2\",\"3\":4,'5':6}";
        this.actualValues = new Object[]{1, "3", "5"};
        this.expectedValues = new Object[]{"2", 4, 6};
    }

    @Test
    public void test_map() {
        Map<Object, Object> map = JSON.parseObject(jsonStr, new TypeReference<Map<Object, Object>>() {
        });
        Assert.assertEquals(expectedValues[0], map.get(actualValues[0]));
        Assert.assertEquals(expectedValues[1], map.get(actualValues[1]));
        Assert.assertEquals(expectedValues[2], map.get(actualValues[2]));
    }
}
