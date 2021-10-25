package com.javacto.mapper;

import com.javacto.po.Member;
import org.apache.ibatis.annotations.Select;

/**
 * describe 会员
 * 作者：曾昭武
 */
public interface MemberMapper {

    @Select("SELECT * FROM member where id=#{id}")
    public Member findById(String id);
}
