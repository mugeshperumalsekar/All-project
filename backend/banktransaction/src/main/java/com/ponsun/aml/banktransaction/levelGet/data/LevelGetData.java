package com.ponsun.aml.banktransaction.levelGet.data;

import lombok.Data;

@Data
public class LevelGetData {
    private Integer id;
    private String name;


    public LevelGetData(final Integer id, final String name) {

        this.id = id;
        this.name = name;
    }

    public static LevelGetData newInstance(final Integer id, final String name) {
        return new LevelGetData(id, name);
    }
}
