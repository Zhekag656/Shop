package com.courseshop.Shop.DTO;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String email;
}
