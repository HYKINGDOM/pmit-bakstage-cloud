-- ----------------------------
-- 2、日志记录表
-- ----------------------------

drop table if exists hw_it.sys_email_info_log;
create table hw_it.sys_email_info_log (
  id 			    integer(11) 	not null auto_increment    comment '自增ID',
  receiveEmail 		varchar(30) 	not null 				   comment '收件人地址',
  ccEmail 		    varchar(500) 	not null 				   comment '抄送人地址',
  subject 		    varchar(100) 	not null 				   comment '邮件主题',
  content           varchar(1000)   not null                   comment '邮件内容',
  template          varchar(100) 	default null			   comment '发件模板',
  sendTime 			varchar(30)     default null 			   comment '发送时间',
  create_by         varchar(64)     default null               comment '创建者',
  create_time 		datetime        default null               comment '创建时间',
  update_by 		varchar(64) 	default null	           comment '更新者',
  update_time 		datetime        default null               comment '更新时间',
  remark 			varchar(500) 	default null 			   comment '备注',
  primary key (id)
) engine=innodb auto_increment=1 default charset=utf8 comment = '邮件发送记录';