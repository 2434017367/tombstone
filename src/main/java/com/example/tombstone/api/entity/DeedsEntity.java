package com.example.tombstone.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
@Data
@TableName("deeds")
public class DeedsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private String id;
	/**
	 * 人物id
	 */
	private String figureId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;

	/**
	 * 事件时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date deedsDate;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	/**
	 * 0：正常 1：禁止  2：删除
	 */
	private Integer status;

}
