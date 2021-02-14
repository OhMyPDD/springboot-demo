package com.pdd.lj.mapper;

import com.pdd.lj.entity.RocOrderTrack;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单轨迹流转(RocOrderTrack)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-12 11:28:59
 */
@Repository
public interface RocOrderTrackDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    RocOrderTrack queryRecentOneById(String orderId);

//    /**
//     * 查询指定行数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<RocOrderTrack> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
//
//
//    /**
//     * 通过实体作为筛选条件查询
//     *
//     * @param rocOrderTrack 实例对象
//     * @return 对象列表
//     */
//    List<RocOrderTrack> queryAll(RocOrderTrack rocOrderTrack);
//
//    /**
//     * 新增数据
//     *
//     * @param rocOrderTrack 实例对象
//     * @return 影响行数
//     */
//    int insert(RocOrderTrack rocOrderTrack);
//
//    /**
//     * 修改数据
//     *
//     * @param rocOrderTrack 实例对象
//     * @return 影响行数
//     */
//    int update(RocOrderTrack rocOrderTrack);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 影响行数
//     */
//    int deleteById(Object id);
//
//    /**
//     * 通过ID查询多条数据
//     *
//     * @param orderId 主键
//     * @return 实例对象
//     */
//    List<RocOrderTrack> queryByOrderId(@Param("orderId") String orderId);
}