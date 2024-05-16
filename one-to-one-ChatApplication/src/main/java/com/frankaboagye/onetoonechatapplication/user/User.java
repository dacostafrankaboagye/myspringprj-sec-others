package com.frankaboagye.onetoonechatapplication.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document  // for the mongo
public class User {

    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
