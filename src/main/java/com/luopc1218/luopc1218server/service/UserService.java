package com.luopc1218.luopc1218server.service;

import com.luopc1218.luopc1218server.entity.Password;
import com.luopc1218.luopc1218server.entity.user.*;
import com.luopc1218.luopc1218server.repository.UserMapper;
import com.luopc1218.luopc1218server.util.jwt.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(Integer id) throws RuntimeException {
        User user = userMapper.getUserById(id);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        return user;
    }

    public String signIn(SignInBody signInBody) throws RuntimeException {
        User user = userMapper.getUserByName(signInBody.getUsername());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        } else {
            String encryptedPassword = new Password(signInBody.getPassword()).getEncryptedPassword();
            Integer userId = user.getId();
            String basePassword = userMapper.getUserPassword(userId);
            if (!Objects.equals(basePassword, encryptedPassword)) {
                throw new RuntimeException("密码错误");
            }
            return Jwt.createJwtToken(user);
        }
    }

    public void signUp(SignUpBody signUpBody) throws RuntimeException {
        String name = signUpBody.getUsername();
        if (userMapper.getUserByName(name) != null) {
            throw new RuntimeException("用户已存在");
        }
        Password password = new Password(signUpBody.getPassword());
        String phone = signUpBody.getPhone();
        Integer telCodeId = signUpBody.getTelCodeId();
        String email = signUpBody.getEmail();
        String avatarUrl = signUpBody.getAvatar();
        User user = new User(name, avatarUrl);
        userMapper.addUser(user);
        Integer userId = user.getId();
//        绑定密码
        UserPassword userPassword = new UserPassword(userId, password.getEncryptedPassword());
        userMapper.addUserPassword(userPassword);
//        绑定手机号
        if (!Objects.equals(phone, "") && telCodeId != null) {
            UserPhone userPhone = new UserPhone(userId, telCodeId, phone);
            userMapper.addUserPhone(userPhone);
        }
//        绑定邮箱
        if (!Objects.equals(email, "")) {
            UserEmail userEmail = new UserEmail(userId, email);
            userMapper.addUserEmail(userEmail);
        }
    }

    public void changeAvatar(Integer id, String url) throws RuntimeException {
        userMapper.changeAvatar(id, url);
    }

    public void changePassword(Integer userId, Map<String, Object> changePasswordForm) throws RuntimeException {
        String encryptedPassword = new Password((String) changePasswordForm.get("password")).getEncryptedPassword();
        String basePassword = userMapper.getUserPassword(userId);
        if (!Objects.equals(basePassword, encryptedPassword)) {
            throw new RuntimeException("密码错误");
        }
        String encryptedNewPassword = new Password((String) changePasswordForm.get("newPassword"))
                .getEncryptedPassword();
        userMapper.changePassword(userId, encryptedNewPassword);
    }

}
