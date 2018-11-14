import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: ListTest
 * Author:   xiexing
 * Date:     2018/11/8 9:39
 * Description: List测试
 */

public class ListTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void listTest(){
        List list = new ArrayList();
        list.add("小明");
        list.add("小冰");
        list.add("小华");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            log.info("{}",iterator.next());

        }
    }

}
