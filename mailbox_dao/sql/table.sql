################# 消息表 ####################################
DROP TABLE IF EXISTS tmb_message;
CREATE TABLE tmb_message(
	Fmb_mid INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_policy TINYINT NOT NULL DEFAULT 0,
	Fmb_channel TINYINT NOT NULL DEFAULT 0,
	Fmb_status TINYINT NOT NULL DEFAULT 0,
	Fmb_content_type TINYINT NOT NULL DEFAULT 0,
	Fmb_content_level TINYINT NOT NULL DEFAULT 0,
	Fmb_content_title VARCHAR(32) NOT NULL DEFAULT "",
	Fmb_content_summary VARCHAR(128) NOT NULL DEFAULT "",
	Fmb_content_body VARCHAR(64) NOT NULL DEFAULT "",
	Fmb_operator VARCHAR(32) NOT NULL DEFAULT "",
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flastmodify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fmb_mid)
) CHARSET=utf8mb4, ENGINE=InnoDb;

ALTER TABLE tmb_message ADD(Fmb_operator VARCHAR(32) NOT NULL DEFAULT "");


DROP TABLE IF EXISTS tmb_receiver_sms;
CREATE TABLE tmb_receiver_sms(
	Fmb_mid INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_receiver_tel VARCHAR(16) NOT NULL DEFAULT "",
	PRIMARY KEY(Fmb_mid, Fmb_receiver_tel)
) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS tmb_receiver_mail;
CREATE TABLE tmb_receiver_mail(
	Fmb_mid INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_receiver_mail VARCHAR(64) NOT NULL DEFAULT "",
	PRIMARY KEY(Fmb_mid, Fmb_receiver_mail)
) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS tmb_receiver_hosting;
CREATE TABLE tmb_receiver_hosting(
	Fmb_mid INT UNSIGNED NOT NULL DEFAULT 0,
	Fcompany_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fgroup_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fuser_role TINYINT NOT NULL DEFAULT 0,
	PRIMARY KEY(Fmb_mid, Fcompany_id, Fgroup_id)
) CHARSET=utf8mb4, ENGINE=InnoDb;

DROP TABLE IF EXISTS tmb_sending_time_rule;
CREATE TABLE tmb_sending_time_rule(
	Fmb_mid INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_start_time INT UNSIGNED NOT NULL DEFAULT 0,
	Frepeat_unit TINYINT NOT NULL DEFAULT 0,
	Frepeat_count INT UNSIGNED NOT NULL DEFAULT 0,
	Fday_time_list VARCHAR(64) NOT NULL DEFAULT 0,
	Funit_time_list VARCHAR(64) NOT NULL DEFAULT 0,
	PRIMARY KEY(Fmb_mid)
) CHARSET=utf8mb4, ENGINE=InnoDb;


################# 消息模板表 ####################################
DROP TABLE IF EXISTS tmb_message_template;
CREATE TABLE tmb_message_template(
	Ftemplate_id INT UNSIGNED NOT NULL DEFAULT 0,
	Ftemplate_name VARCHAR(32) NOT NULL DEFAULT "",
	Fmb_policy TINYINT NOT NULL DEFAULT 0,
	Fmb_channel TINYINT NOT NULL DEFAULT 0,
	Fmb_content_type TINYINT NOT NULL DEFAULT 0,
	Fmb_content_level TINYINT NOT NULL DEFAULT 0,
	Fmb_content_title VARCHAR(32) NOT NULL DEFAULT "",
	Fmb_content_summary VARCHAR(128) NOT NULL DEFAULT "",
	Fmb_content_body VARCHAR(64) NOT NULL DEFAULT "",
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flastmodify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Ftemplate_id)
) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS tmb_template_receiver_sms;
CREATE TABLE tmb_template_receiver_sms(
	Ftemplate_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_receiver_tel VARCHAR(16) NOT NULL DEFAULT "",
	PRIMARY KEY(Ftemplate_id, Fmb_receiver_tel)
) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS tmb_template_receiver_mail;
CREATE TABLE tmb_template_receiver_mail(
	Ftemplate_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_receiver_mail VARCHAR(64) NOT NULL DEFAULT "",
	PRIMARY KEY(Ftemplate_id, Fmb_receiver_mail)
) CHARSET=utf8mb4, ENGINE=InnoDb;


DROP TABLE IF EXISTS tmb_template_receiver_hosting;
CREATE TABLE tmb_template_receiver_hosting(
	Ftemplate_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fcompany_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fgroup_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fuser_role TINYINT NOT NULL DEFAULT 0,
	PRIMARY KEY(Ftemplate_id, Fcompany_id, Fgroup_id)
) CHARSET=utf8mb4, ENGINE=InnoDb;

DROP TABLE IF EXISTS tmb_template_sending_time_rule;
CREATE TABLE tmb_template_sending_time_rule(
	Ftemplate_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_start_time INT UNSIGNED NOT NULL DEFAULT 0,
	Frepeat_unit TINYINT NOT NULL DEFAULT 0,
	Frepeat_count INT UNSIGNED NOT NULL DEFAULT 0,
	Fday_time_list VARCHAR(64) NOT NULL DEFAULT 0,
	Funit_time_list VARCHAR(64) NOT NULL DEFAULT 0,
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flastmodify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Ftemplate_id)
) CHARSET=utf8mb4, ENGINE=InnoDb;


################# 消息实例表 ####################################
DROP TABLE IF EXISTS tmb_message_job;
CREATE TABLE tmb_message_job(
	Fmb_job_id INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_mid INT UNSIGNED NOT NULL DEFAULT 0,
	Fmb_channel TINYINT NOT NULL DEFAULT 0,
	Fmb_status TINYINT NOT NULL DEFAULT 0,
	Fmb_content_type TINYINT NOT NULL DEFAULT 0,
	Fmb_content_level TINYINT NOT NULL DEFAULT 0,
	Fmb_content_title VARCHAR(32) NOT NULL DEFAULT "",
	Fmb_content_summary VARCHAR(128) NOT NULL DEFAULT "",
	Fmb_content_body VARCHAR(64) NOT NULL DEFAULT "",
	Fmb_error_description VARCHAR(128) NOT NULL DEFAULT "",
	Fmb_operator VARCHAR(32) NOT NULL DEFAULT "",
	Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	Flastmodify_timestamp INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fmb_job_id)
) CHARSET=utf8mb4, ENGINE=InnoDb;

ALTER TABLE tmb_message_job ADD(Fmb_operator VARCHAR(32) NOT NULL DEFAULT "");


