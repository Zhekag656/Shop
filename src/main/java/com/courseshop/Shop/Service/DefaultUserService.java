package com.courseshop.Shop.Service;

import com.courseshop.Shop.DTO.UserDTO;
import com.courseshop.Shop.Entity.User;
import com.courseshop.Shop.Exceptions.ValidationException;
import com.courseshop.Shop.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService{

    private final UserRepo userRepo;
    private final UserConverter userConverter;

    private void validateUserDTO(UserDTO userDTO) throws ValidationException {
        if(isNull(userDTO)){
            throw new ValidationException("User is null");
        }
        if(isNull(userDTO.getLogin()) || userDTO.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) throws ValidationException{
        validateUserDTO(userDTO);
        User savedUser = userRepo.save(userConverter.fromUserDTOToUser(userDTO));
        return userConverter.fromUserToUserDTO(savedUser);
    }

    @Override
    public void deleteUser(Integer userId){
        userRepo.deleteById(userId);
    }

    @Override
    public UserDTO findByLogin(String login){
        User user = userRepo.findByLogin(login);
        if(user != null){
            return userConverter.fromUserToUserDTO(user);
        }
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userConverter::fromUserToUserDTO)
                .collect(Collectors.toList());
    }
}
