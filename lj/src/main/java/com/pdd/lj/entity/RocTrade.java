package com.pdd.lj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易单(订单组)(RocTrade)实体类
 *
 * @author makejava
 * @since 2020-05-12 11:28:59
 */
@Data
public class RocTrade implements Serializable {
    private static final long serialVersionUID = 877363156340995931L;
    /**
    * 交易单ID
    */
    private Long id;
    /**
    * 交易单id
    */
    private String tradeId;
    /**
    * 创建时间
    */
    private Date dateCreate;
    /**
    * 修改时间
    */
    private Date dateUpdate;
    /**
    * 0表示未删除
    */
    private Integer deleted;
}