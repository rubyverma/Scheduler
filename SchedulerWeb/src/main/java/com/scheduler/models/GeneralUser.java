package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralUser {
        
        private int userId;
        private int clientId;
        private String username;
        private String password;
        private String repassword;
        private String firstName;
        private String lastName;
        private String email;
        private Date dob;
        private String address;
        private String gender;
        private String tocken;
        private int emailVerified;
        private String gcmRegId;
}
