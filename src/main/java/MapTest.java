import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: MapTest
 * Author:   xiexing
 * Date:     2018/11/5 17:58
 * Description: Map测试
 */

public class MapTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void mapTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "小明");
        map.put("key2", "小冰");
        map.put("key3", "小华");
        String str = map.get("key1").toString();
        log.info(str);
        log.info("map : {}",map);

        Iterator<Map.Entry<String,Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Object> entry = iterator.next();
            log.info(entry.getKey()+entry.getValue());
        }
    }
}
