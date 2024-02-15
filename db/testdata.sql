SET NAMES 'utf8mb4';

-- 插入测试数据到 student 表
INSERT INTO `lecodedb`.`student` (`sno`, `sname`, `snick`, `sbirth`, `sgender`, `sschool`, `saddress`, `sfamily`, `sfname`, `sfmobile`, `ssource`, `sstatus`, `snote`, `deleted`)
VALUES
('S001', '张三', '小张', '2005-01-01', 'M', '第一中学', '某市某区某街道123号', 'FATHER', '张伟', '13800138000', '1', 'VALID', '优秀学生', 0),
('S002', '李四', '小李', '2006-02-02', 'F', '第二中学', '某市某区某街道456号', 'MOTHER', '李红', '13900139000', '1', 'VALID', '艺术特长', 0),
('S003', '王五', '小王', '2004-03-03', 'M', '第三中学', '某市某区某街道789号', 'GUARDIAN', '王刚', '13700137000', '1', 'CHURN', '转学去外地', 0);

-- 插入测试数据到 user 表
INSERT INTO `lecodedb`.`user` (`uno`, `uuser`, `uname`, `upassword`, `uwechatid`, `uwechatopenid`, `uphone`, `ustatus`, `unote`, `deleted`)
VALUES
('U001', 'user1', '用户一', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', 'wechatid1', 'openid1', '15000000001', 'ACTIVE', '前台', 0),
('U002', 'user2', '用户二', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', 'wechatid2', 'openid2', '15000000002', 'LOCK', '老师', 0),
('U003', 'user3', '用户三', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', 'wechatid3', 'openid3', '15000000003', 'ACTIVE', '管理员', 0);

-- 插入测试数据到 teacher 表
INSERT INTO `lecodedb`.`teacher` (`tno`, `tname`, `tnick`, `tbirth`, `tgender`, `tavatar`, `tjoindate`, `tresigndate`, `tstatus`, `tnote`, `deleted`)
VALUES
('T001', '陈老师', '陈', '1980-04-04', 'F', 'avatar1.jpg', '2010-09-01', NULL, 'ACTIVE', '数学老师', 0),
('T002', '王老师', '王', '1978-05-05', 'M', 'avatar2.jpg', '2012-03-15', NULL, 'ACTIVE', '英语老师', 0),
('T003', '刘老师', '刘', '1982-06-06', 'F', 'avatar3.jpg', '2015-08-23', '2023-07-01', 'RESIGN', '物理老师', 0);

-- 插入测试数据到 contract 表
-- 注意：这里的sid需要根据实际student表中的sid来设置
INSERT INTO `lecodedb`.`contract` (`ctno`, `sid`, `ctamount`, `ctstart`, `ctend`, `ctinstallment`, `ctpaidhour`, `ctfreehour`, `classtype`, `ctstatus`, `ctnote`, `deleted`)
VALUES
('CT001', 1, 5000.00, '2023-01-01', '2023-12-31', 1, 0, 0, 'A', 'ACTIVE', '2023年度合同', 0),
('CT002', 2, 6000.00, '2023-02-01', '2023-12-31', 2, 0, 0, 'B', 'ACTIVE', '2023年度合同', 0),
('CT003', 3, 5500.00, '2023-03-01', '2023-12-31', 1, 0, 0, 'A', 'EXPIRED', '2022年度合同', 0);

-- 插入测试数据到 teacher 表
INSERT INTO `lecodedb`.`group_student` (`gsid`, `sid`, `gsstart`, `gsend`, `gsstatus`, `gsnote`, `deleted`)
VALUES
(1, 1, '2023-09-01', NULL, 'ACTIVE', '表现良好', 0),
(2, 2, '2023-09-01', NULL, 'ACTIVE', '需要加强', 0),
(3, 3, '2023-09-01', '2023-12-31', 'QUIT', '转学', 0);

-- 插入测试数据到 contract_payment 表
INSERT INTO `lecodedb`.`contract_payment` (`cpid`, `ctid`, `cpdate`, `cpamount`, `cpphase`, `cppayer`, `cppayee`, `cpchannel`, `cpstatus`, `ctnote`, `deleted`)
VALUES
(1, 1, '2023-01-10', 5000.00, 1, '张三', '学校', 'WECHAT', 'PAID', '全额支付', 0),
(2, 2, '2023-02-15', 3000.00, 1, '李四', '学校', 'ALIPAY', 'PAID', '首期支付', 0),
(3, 2, '2023-06-15', 3000.00, 2, '李四', '学校', 'ALIPAY', 'PAID', '尾期支付', 0);

-- 插入测试数据到 payment_commission 表
INSERT INTO `lecodedb`.`payment_commission` (`pcid`, `cpid`, `pcrole`, `pcpercent`, `pcamount`, `pcstatus`, `pcdate`, `pcnote`, `deleted`)
VALUES
(1, 1, 'SALE', 0.05, 250.00, 'CONFIRMED', '2023-01-11', '销售佣金', 0),
(2, 2, 'SALE', 0.05, 150.00, 'CONFIRMED', '2023-02-16', '销售佣金', 0),
(3, 3, 'SALE', 0.05, 150.00, 'PAID', '2023-06-16', '销售佣金', 0);

-- 插入测试数据到 study_group 表
INSERT INTO `lecodedb`.`study_group` (`sgid`, `sgno`, `sgname`, `sgcourse`, `sgcapacity`, `sgstart`, `sgend`, `sgclasstime`, `sgclasshour`, `crid`, `sgstatus`, `sgnote`, `deleted`)
VALUES
(1, 'D301', '草莓班', '乐高', 6, '2023-09-01', '9999-12-31', '14:00:00', 1.5, NULL, 'ACTIVE', '下午班', 0),
(2, 'D302', '蓝莓班', '玛塔', 6, '2023-09-01', '9999-12-31', '10:00:00', 1.5, NULL, 'ACTIVE', '上午班', 0),
(3, 'D303', '香蕉班', '寒假班', 6, '2023-01-15', '2023-02-15', '09:00:00', 2, NULL, 'CLOSED', '寒假特训', 0);

-- 插入测试数据到 time_record 表
INSERT INTO `lecodedb`.`time_record` (`trid`, `ctid`, `tid`, `sgid`, `trhour`, `trdate`, `trcontent`, `trstatus`, `trnote`, `deleted`)
VALUES
(1, 1, 1, 1, 1.5, '2023-09-02', '乐高基础', 'ATTEND', '', 0),
(2, 2, 2, 2, 1.5, '2023-09-02', '玛塔入门', 'ATTEND', '', 0),
(3, 3, 3, 3, 2, '2023-01-16', '寒假加强', 'ATTEND', '', 0);
