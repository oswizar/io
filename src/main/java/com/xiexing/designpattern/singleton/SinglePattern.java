/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: Singleton
 * Author:   xiexing
 * Date:     2019/3/26 14:29
 * Description:
 */
package com.xiexing.designpattern.singleton;

// 单例仓库类
class StoreHouse {
    // 初始化仓库数量
    private int quantity = 100;

    // 封闭构造子,防止被外部实例化
    private StoreHouse(){
        System.out.println("仓库初始容量为:"+quantity);
    }
    // 直接内部实例化
    private static StoreHouse ourInstance = new StoreHouse();

    // 让外部通过调用getInstance()方法来返回唯一的实例。
    public static StoreHouse getInstance() {
        return ourInstance;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

// 搬货工人类
class Carrier{
    public StoreHouse mStoreHouse;
    public Carrier(StoreHouse storeHouse){
        mStoreHouse = storeHouse;
    }
    //搬货进仓库
    public void MoveIn(int i){
        System.out.println("仓库进货:"+i);
        mStoreHouse.setQuantity(mStoreHouse.getQuantity()+i);
    }
    //搬货出仓库
    public void MoveOut(int i){
        System.out.println("仓库出货:"+i);
        mStoreHouse.setQuantity(mStoreHouse.getQuantity()-i);
    }
}

//工人搬运测试
public class SinglePattern {
    public static void main(String[] args){
        StoreHouse mStoreHouse1 = StoreHouse.getInstance();
        System.out.println("实例化仓库1...");
        StoreHouse mStoreHouse2 = StoreHouse.getInstance();
        System.out.println("实例化仓库2...");
        Carrier carrier1 = new Carrier(mStoreHouse1);
        Carrier carrier2 = new Carrier(mStoreHouse2);

        System.out.println("这两个仓库是不是同一个仓库?");

        // 这里用equals比较两个对象的地址是否相等
        if(mStoreHouse1.equals(mStoreHouse2)){
            System.out.println("是同一个");
        }else {
            System.out.println("不是同一个");
        }
        //搬运工搬完货物之后出来汇报仓库商品数量
        carrier1.MoveIn(30);
        System.out.println("仓库商品余量："+carrier1.mStoreHouse.getQuantity());
        carrier2.MoveOut(50);
        System.out.println("仓库商品余量："+carrier2.mStoreHouse.getQuantity());
    }
}