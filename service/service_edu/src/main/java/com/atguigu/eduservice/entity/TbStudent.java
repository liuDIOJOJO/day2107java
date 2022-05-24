package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbStudent对象", description="")
public class TbStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.ID_WORKER_STR)
    private String sid;

    private String sname;

    private Integer age;

    private Date birthday;

    private Integer proid;

    private Integer cityid;

    private Integer couid;

    private String address;

    private Integer gid;


}
