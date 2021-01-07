package com.lxw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxw
 * @since 2020-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EbookEntry对象", description="")
public class EbookEntry implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer categoryId;

    private String title;

    private String summary;

    private String uploadUser;

    private Date createTime;

    private Date updateTime;

    private String name;

}
