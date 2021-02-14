package com.pdd.lj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单轨迹流转(RocOrderTrack)实体类
 *
 * @author makejava
 * @since 2020-05-12 11:28:59
 */
@Data
public class RocOrderTrack implements Serializable {
    private static final long serialVersionUID = -32958537492265243L;
    /**
    * ID
    */
    private Long id;
    /**
    * 业务订单id
    */
    private String orderId;
    /**
    * 操作内容
    */
    private String content;
    /**
     * 上一个状态
     */
    private Integer preStatusCode;
    /**
    * 当前状态
    */
    private Integer currentStatusCode;
    /**
    * 描述
    */
    private String description;
    /**
    * 操作人id
    */
    private String operator;
    /**
     * 操作人姓名
     */
    private String operatorName;
    /**
    * 操作类型(系统触发或人为触发)
    */
    private Integer operatorType;
    /**
    * 轨迹类型(订单轨迹或者交付单轨迹)
    */
    private Integer trackType;
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