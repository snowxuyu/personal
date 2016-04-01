package com.snow.personal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.framework.basic.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by gaoguoxiang on 2016/3/4.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_user")
public class User extends BaseEntity {
    private String userName;
    private String password;
    private String address;
}
