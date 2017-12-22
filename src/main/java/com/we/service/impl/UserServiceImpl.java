package com.we.service.impl;

import com.we.common.Pager;
import com.we.dao.BaseDAO;
import com.we.dao.UserDAO;
import com.we.service.AbstractBaseService;
import com.we.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created on 2017/12/21 14:27
 *
 * @author mh
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        super.setBaseDAO(userDAO);
        this.userDAO = userDAO;
    }

    @Override
    public String isPhone(String phone) {
        return userDAO.isPhone(phone);
    }

    @Override
    public String isId(Integer id) {
        return userDAO.isId(id);
    }
}