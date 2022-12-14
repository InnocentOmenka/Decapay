package com.example.decapay.controllers;

import com.example.decapay.pojos.requestDtos.UserUpdateRequest;
import com.example.decapay.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers=UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private UserService userService;

    @Test
    void editUser() {
        try {
            UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
            userUpdateRequest.setFirstname("Michael");
            userUpdateRequest.setLastname("Ajayi");
            userUpdateRequest.setEmail("olamic695@yahoo.com");

            String requestBody = mapper.writeValueAsString(userUpdateRequest);
            mockMvc.perform(put("/api/v1/user/edit/1")
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isOk());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}