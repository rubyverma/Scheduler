package com.scheduler.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.scheduler.BaseTest;

public class TestUserController extends BaseTest{

    @Test
    public void getAccount() throws Exception {
        this.mockMvc.perform(get("/user/register").accept(MediaType.parseMediaType("text/html")))
          .andExpect(status().isOk());
    }

}
