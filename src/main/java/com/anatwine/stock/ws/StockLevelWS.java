package com.anatwine.stock.ws;

import com.anatwine.stock.entity.StockLevel;
import com.anatwine.stock.service.StockLevelService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class StockLevelWS {

    @Inject StockLevelService stockLevelService;

    @RequestMapping(value = "/stocklevel/list", method = RequestMethod.GET)
    public List<StockLevel> getStockLevelsForBrand(@RequestParam(value = "brand") Long brandId){
        System.out.println("calling getStockLevelsForBrand");
        return stockLevelService.getStockLevelsForBrand(brandId);
    }

    @RequestMapping(value = "/stocklevel", method = RequestMethod.GET)
    public StockLevel getStockLevelForBrand(@RequestParam(value = "brandId") Long brandId, @RequestParam(value = "id") Long id){
        return stockLevelService.getStockLevel(brandId, id);
    }


    @RequestMapping(value = "/stocklevel", method = RequestMethod.PUT)
    public void addStockLevel(@RequestBody StockLevel stockLevel){
        stockLevelService.AddStockLevel(stockLevel);
    }

    @RequestMapping(value = "/helloworld")
    public String hello(){
        return "hello";
    }



}
