package com.lsp.uidemo;

/**
 * Created by lsp.
 * Date: 2021-5-28
 */
public class Animal {

    private String name;

    private int imageId;

    public Animal(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }


    public int getImageId() {
        return imageId;
    }

}
