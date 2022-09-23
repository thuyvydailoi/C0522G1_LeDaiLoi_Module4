package com.codegym.dto;


import java.util.HashMap;
import java.util.Map;

public class SessionDto {
    private Map<ShopDto, Integer> shopMap = new HashMap<>();

    public SessionDto() {
    }

    public SessionDto(Map<ShopDto, Integer> shopMap) {
        this.shopMap = shopMap;
    }

    public Map<ShopDto, Integer> getShopMap() {
        return shopMap;
    }

    public void setShopMap(Map<ShopDto, Integer> shopMap) {
        this.shopMap = shopMap;
    }

    public void addShop(ShopDto shopDto) {
        if (shopMap.containsKey(shopDto)) {
            Integer currentValue = shopMap.get(shopDto);
            shopMap.replace(shopDto, currentValue + 1);
        } else {
            shopMap.put(shopDto,1);
        }
    }
}
