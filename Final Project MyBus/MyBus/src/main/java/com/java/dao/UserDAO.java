package com.java.dao;

import java.util.List;

public interface UserDAO {
       public void insertUser( User user);
       public User selectUser(int userID);
       public List<User> selectUsers();
       public void updateUser(User user);
       public void deleteUser(int userID);

}