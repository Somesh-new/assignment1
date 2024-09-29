package com.example.service;

import com.example.model.Login;
import com.example.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void signup(Login login) {
        loginRepository.save(login);
    }

    @Override
    public boolean signin(String emailid, String password, String typeofuser) {
        return loginRepository.validateUser(emailid, password, typeofuser);
    }
}