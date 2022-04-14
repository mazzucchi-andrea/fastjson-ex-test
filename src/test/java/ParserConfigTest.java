import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParserConfigTest {

    private int expected;
    private String jsonStr;

    public ParserConfigTest(int expected, String jsonStr){
        this.expected = expected;
        this.jsonStr = jsonStr;
    }

    @Parameters
    public static Collection<Object> getTestParameters(){
        return Arrays.asList(new Object[][] {
                {123, "{\"value\":123}"},
                {456, "{\"value\":456}"},
                {789, "{\"value\":789}"}
        });
    }

    @Test
    public void test_0() throws Exception{
        ParserConfig config = new ParserConfig();
        config.getDeserializers();
    }

    @Test
    public void test_1() throws Exception{
        ParserConfig config = new ParserConfig(Thread.currentThread().getContextClassLoader());

        Model model = JSON.parseObject(jsonStr, Model.class, config);
        Assert.assertEquals(expected, model.value);
    }

    public static class Model {
        public int value;
    }
}
