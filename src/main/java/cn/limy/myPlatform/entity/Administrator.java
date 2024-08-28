package cn.limy.myPlatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author 蒾酒
 * @since 2024-03-07
 */
@Getter
@Setter
@TableName("administrator")
@Schema(name = "Administrator对象", description = "管理员表")
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name ="主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(name ="管理员账号")
    @TableField("admin_account")
    private String adminAccount;

    @Schema(name ="管理员密码")
    @TableField("admin_password")
    private String adminPassword;

    @Schema(name ="管理员昵称")
    @TableField("admin_name")
    private String adminName;

    @Schema(name ="社区id")
    @TableField("merchant_id")
    private Integer merchantId;
}
