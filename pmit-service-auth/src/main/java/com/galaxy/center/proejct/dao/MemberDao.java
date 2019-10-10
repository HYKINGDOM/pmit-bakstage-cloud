package com.galaxy.center.proejct.dao;


import com.center.pmit.project.common.pojo.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * 〈用户Dao〉
 *
 */
@Mapper
public interface MemberDao {

    /**
     * 根据会员名查找会员
     * @param memberName 会员名
     * @return 会员
     */
    Member findByMemberName(String memberName);
}
