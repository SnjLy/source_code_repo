package com.mock;

import com.alibaba.fastjson.JSON;
import com.mock.model.User;
import com.mock.model.UserDao;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * <p></p>
 * Created by admin on 2017/9/1.
 */
public class MockUserTest {

    @Test
    public void testUser() {
        UserDao userDao = mock(UserDao.class);
        User userMock = mock(User.class);
        when(userMock.getId()).thenReturn(null);
        when(userDao.getUserById(anyLong())).thenReturn(new User(2L, "yehaoTest"));
        doThrow(new RuntimeException()).when(userDao.getUserById(userMock.getId()));

        System.out.println(JSON.toJSONString(userDao.getUserById(1L)));
        System.out.println(JSON.toJSONString(userDao.getUserById(userMock.getId())));

    }

}
