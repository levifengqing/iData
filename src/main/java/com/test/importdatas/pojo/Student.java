package com.test.importdatas.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  add@GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Author  levi
 * @Date 2020-08-09 
 */

@Data
@Entity
@Table ( name ="student" )
public class Student  implements Serializable {

	private static final long serialVersionUID =  2051555314692220221L;

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "age" )
	private Integer age;

   	@Column(name = "sex" )
	private String sex;

   	@Column(name = "body_color" )
	private String bodyColor;

}
