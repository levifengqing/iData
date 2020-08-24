package com.test.importdatas.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  add@GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Author  levi
 * @Date 2020-08-24 
 */

@Data
@Entity
@Table ( name ="user_home" )
public class UserHome  implements Serializable {

	private static final long serialVersionUID =  3193375328906816217L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "home_id" )
	private Integer homeId;

   	@Column(name = "home_size" )
	private Integer homeSize;

   	@Column(name = "home_address" )
	private String homeAddress;

   	@Column(name = "home_user" )
	private Integer homeUser;

//   	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name = "id")
//   	private UserInfo userInfo1;
//测试失败
}
