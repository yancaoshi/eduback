package com.lecode.eduback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@Builder
@Slf4j
@TableName("user")
public class User {
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    private String uno;
    private String uname;
    private String upassword;
    private String uwechatid;
    private String uwechatopenid;
    private String uphone;
    private Character ustatus;
    private String unote;

}
