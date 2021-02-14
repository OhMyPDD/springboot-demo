package com.pdd.lj.mapper;

import com.pdd.lj.entity.RocTrade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 交易单(订单组)(RocTrade)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-12 11:28:59
 */
@Repository
public interface RocTradeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RocTrade queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RocTrade> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rocTrade 实例对象
     * @return 对象列表
     */
    List<RocTrade> queryAll(RocTrade rocTrade);

    /**
     * 新增数据
     *
     * @param rocTrade 实例对象
     * @return 影响行数
     */
    int insert(RocTrade rocTrade);

    /**
     * 修改数据
     *
     * @param rocTrade 实例对象
     * @return 影响行数
     */
    int update(RocTrade rocTrade);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}