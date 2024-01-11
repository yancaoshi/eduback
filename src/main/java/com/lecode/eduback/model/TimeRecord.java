package com.lecode.eduback.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TimeRecord {

    @TableId
    private int trid;
    private int ctid;
    private int tid;

//      `trid` INT NOT NULL AUTO_INCREMENT,
//  `ctid` INT NOT NULL,
//            `tid` INT NULL,
//  `sgid` INT NULL,
//  `trhour` DECIMAL(3,1) NULL,
//  `trcontent` VARCHAR(20) NULL,
//  `trtype` VARCHAR(3) NULL,
//  `trstatus` VARCHAR(3) NULL,
//  `trnote` VARCHAR(45) NULL,


}
