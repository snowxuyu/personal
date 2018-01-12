package com.snow.personal.entity;

import lombok.Data;
import org.framework.basic.entity.BaseEntity;
import javax.persistence.Table;



@Data
@Table(name = "t_user")
public class User extends BaseEntity {
	/**  */
	private String userName;
	/**  */
	private String passWord;
	/**  */
	private String address;
	/**  */
	private String phone;

}
