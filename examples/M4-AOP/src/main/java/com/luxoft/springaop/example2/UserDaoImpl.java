package com.luxoft.springaop.example2;

import com.luxoft.springaop.example1.UserDTO;

import java.util.HashMap;
import java.util.Map;

@Log
public class UserDaoImpl {

    private static Map<Integer, UserDTO> userIdToUserDto = new HashMap<>();

    @Log(printArgs = false)
    public UserDTO getUser(int id) {
        UserDTO user = userIdToUserDto.get(id);

        if (user == null) {
            user = new UserDTO(id);
            userIdToUserDto.put(id, user);
        }

        return user;
    }

}
