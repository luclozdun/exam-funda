package com.request.request.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "request")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private String detail;

    private Date createdAt;

    private String name;

    private String subtitle;

    private String age;

    @Lob
    private String description;

    @Lob
    private String image;

    @Lob
    private String background;
}
