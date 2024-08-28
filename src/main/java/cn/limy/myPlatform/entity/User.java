package cn.limy.myPlatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 蒾酒
 * @since 2024-03-07
 */
@Data
@TableName("user")
@Schema(name = "User对象", description = "用户表")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(name="主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="用户昵称")
    @TableField("user_name")
    private String userName;

    @Schema(name="密码")
    @TableField("password")
    private String password;

    @Schema(name="账号")
    @TableField("user_account")
    private String userAccount;

    @Schema(name="用户角色：user / admin")
    @TableField("user_role")
    private String userRole;

    @Schema(name="头像")
    @TableField("avatar")
    private String avatar;

    @Schema(name="创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(name="更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @Schema(name="逻辑删除：1删除/0存在")
    @TableField("is_delete")
    private Boolean isDelete;

    @Schema(name="性别")
    @TableField("gender")
    private Boolean gender;

    @Schema(name="状态：1正常0禁用")
    @TableField("status")
    private Boolean status;


    @Schema(name="手机号")
    @TableField("phone")
    private String phone;
}
