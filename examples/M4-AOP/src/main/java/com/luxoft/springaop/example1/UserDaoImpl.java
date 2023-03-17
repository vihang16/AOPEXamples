package com.luxoft.springaop.example1;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private static Map<Integer, UserDTO> userIdToUserDto = new HashMap<>();

    public UserDTO getUser(int id) {
        UserDTO user = userIdToUserDto.get(id);
        System.out.println("check...");
        if (user == null) {
            user = new UserDTO(id);
            userIdToUserDto.put(id, user);
        }

        return user;
    }
}
