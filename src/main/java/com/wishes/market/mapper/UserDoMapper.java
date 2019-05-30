package com.wishes.market.mapper;

import com.wishes.market.model.UserDo;
import com.wishes.market.model.UserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDoMapper {
    /**
     *
     * @mbg.generated 2019-02-28
     */
    long countByExample(UserDoExample example);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int deleteByPrimaryKey(UserDo record);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int insert(UserDo record);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int insertSelective(UserDo record);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    List<UserDo> selectByExample(UserDoExample example);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    UserDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int updateByExampleSelective(@Param("record") UserDo record, @Param("example") UserDoExample example);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int updateByExample(@Param("record") UserDo record, @Param("example") UserDoExample example);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int updateByPrimaryKeySelective(UserDo record);

    /**
     *
     * @mbg.generated 2019-02-28
     */
    int updateByPrimaryKey(UserDo record);
}