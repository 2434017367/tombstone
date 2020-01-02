package com.example.tombstone.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
@Data
@TableName("figure")
public class FigureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private String id;
	/**
	 * 墓志铭
	 */
	private String title;

	/**
	 * 姓名
	 */
	private String name;


	/**
	 * 内容
	 */
	private String content;


	/**
	 * 出生日期
	 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birthDate;

	/**
	 * 死亡日期
	 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date deathDate;

	/**
	 * 主图
	 */
	private String image;
	/**
	 * 创建时间
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	/**
	 * 0：正常 1：禁止  2：删除
	 */
	private Integer status;


	@TableField(exist=false)
	private List<DeedsEntity> deedsList;

	@TableField(exist = false)
	private List<CommentEntity> commentList;

}
