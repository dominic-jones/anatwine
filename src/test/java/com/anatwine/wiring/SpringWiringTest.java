package com.anatwine.wiring;

import com.anatwine.stock.StockLevelServiceApplication;
import com.anatwine.stock.ws.StockLevelWS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StockLevelServiceApplication.class)
public class SpringWiringTest {

    @Inject
    StockLevelWS stockLevelWS;

    @Test
    public void testWiring() {

    }

}
