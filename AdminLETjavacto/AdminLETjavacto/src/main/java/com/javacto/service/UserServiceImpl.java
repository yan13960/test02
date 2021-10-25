package com.javacto.service;

import com.javacto.mapper.UserMapper;
import com.javacto.po.Role;
import com.javacto.po.UserInfo;
import com.javacto.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
@Service("userServiceId")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public List<UserInfo> queryAll(){
        return userMapper.queryAll();
    }
    public  void insert(UserInfo info){
        //userMapper.insert(info);

        //对密码进行加密处理
        info.setPassword(BCryptPasswordEncoderUtils.encodePassword(info.getPassword()));

        userMapper.insert(info);
    }

    /**
     * 根据id查询用户信息
     */
    public UserInfo findById(String userId){
        return  userMapper.findById(userId);
    }

    //查询可以添加的用户权限
    public List<Role> findOtherRoles(String userId){
        return  userMapper.findOtherRoles(userId);
    }
    //添加权限
    public void addRoleToUser(String userId, String[] roleIds){

        for (String roleId:roleIds){
            userMapper.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1.通过用户名查询用户信息
        UserInfo info = userMapper.findByName(username);

      //  User user =  new User(info.getUsername(),"{noop}"+info.getPassword(),getAuthority(info.getRoles()));

        /*  User user= new User(info.getUsername(),"{noop}"+info.getPassword(), true,
                true, true,
                true, getAuthority(info.getRoles()));
*/
     /*    User user= new User(info.getUsername(),"{noop}"+info.getPassword(), info.getStatus()==0?false:true,
                true, true,
                true, getAuthority(info.getRoles()));
*/
        User user= new User(info.getUsername(),info.getPassword(), info.getStatus()==0?false:true,
                true, true,
                true, getAuthority(info.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        //暂时把权限信息写死,
       /* list.add(new SimpleGrantedAuthority("ROLE_USER"));
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
*/
        for (Role r:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }

        return list;

    }
}
