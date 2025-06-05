package kr.ac.hansung.cse.hellospringdatajpa.service;

import kr.ac.hansung.cse.hellospringdatajpa.entity.MyUser;

public interface AuthService {
    MyUser createUser(MyUser user);
    boolean checkEmailExists(String email);
}