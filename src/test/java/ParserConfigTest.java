import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Assert;
import org.junit.Test;

public class ParserConfigTest {

    private int expected;
    private String jsonStr;

    public ParserConfigTest() {
        configure();
    }

    private void configure() {
        this.expected = 123;
        this.jsonStr = "{\"value\":123}";
    }

    @Test
    public void test_0() {
        ParserConfig config = new ParserConfig();
        Assert.assertNotNull(config.getDeserializers());

    }

    @Test
    public void test_1() {
        ParserConfig config = new ParserConfig(Thread.currentThread().getContextClassLoader());

        Model model = JSON.parseObject(jsonStr, Model.class, config);
        Assert.assertEquals(expected, model.value);
    }

    public static class Model {
        public int value;
    }
}
