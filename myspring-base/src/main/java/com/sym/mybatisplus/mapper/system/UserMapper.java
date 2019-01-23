package com.sym.mybatisplus.mapper.system;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.sym.mybatisplus.common.SuperMapper;
import com.sym.mybatisplus.model.system.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends SuperMapper<User> {

    @Select("selectUserListByPage")
    List<User> selectUserListByPage(Pagination page);


}
