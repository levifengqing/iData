package com.test.importdatas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description  add@GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Author  levi
 * @Date 2020-08-18 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name ="user_info" )
public class UserInfo  implements Serializable {

	private static final long serialVersionUID =  8874403752230789641L;

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "user_name" )
	private String userName;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "gmt_create" )
	private Date gmtCreate;

   	@Column(name = "gmt_modified" )
	private Date gmtModified;

   	@Column(name = "version" )
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2",strategy = "uuid2")
	private Integer version;

   	@Column(name = "rights" )//数据库设计，避免关键字，否则jpa操作会报错
	private String right;

   	@Column(name = "role" )
	private String role;

   	@Column(name = "salt" )
	private String salt;

   	@Column(name = "md5_password" )
	private String md5Password;

   	@OneToOne
	@JoinColumn(name = "id",referencedColumnName = "pid")
   	private UserDetail userDetail;
   	//已经可以正常查询出结果
   	//一对一，另一方好像啥的不用加了，就可以查出来了

	//测试失败
//	@OneToMany(mappedBy = "userInfo1",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<UserHome> userHomes;



}
