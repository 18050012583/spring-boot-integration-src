package com.example.springboot.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "user_info_index", type = "doc")
public class User implements Serializable{

    @Id
    private Long id;

    private String username;

}
