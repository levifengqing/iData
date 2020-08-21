package com.test.importdatas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  add@GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Author  levi
 * @Date 2020-08-18 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name ="user_detail" )
public class UserDetail  implements Serializable {

	private static final long serialVersionUID =  435988773771799744L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long sid;

   	@Column(name = "pid" )
	private Long pid;

   	@Column(name = "address" )
	private String address;

   	@Column(name = "sex" )
	private String sex;

}
