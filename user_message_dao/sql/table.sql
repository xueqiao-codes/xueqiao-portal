## 用户的消息 ##
DROP TABLE IF EXISTS tuser_message;
CREATE TABLE tuser_message_#NUM#(
	Fmessage_id BIGINT UNSIGNED NOT NULL,
	Fuser_id BIGINT UNSIGNED NOT NULL DEFAULT 0,
	Fcompany_id BIGINT NOT NULL DEFAULT 0,
	Fmessage_job_id BIGINT NOT NULL DEFAULT 0,
	Fmessage_type SMALLINT NOT NULL DEFAULT 0,
	Fmessage_level SMALLINT NOT NULL DEFAULT 0,
	Fmessage_state SMALLINT NOT NULL DEFAULT 0,
	Ftitle VARCHAR(32) NOT NULL DEFAULT "",
	Fsummary VARCHAR(256) NOT NULL DEFAULT "",
	Fcontent_file_name VARCHAR(64) NOT NULL DEFAULT "",
	Fcreate_timestamp BIGINT UNSIGNED NOT NULL DEFAULT 0,
	Flast_modify_timestamp BIGINT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY(Fmessage_id),
	UNIQUE KEY(Fuser_id,Fmessage_job_id)
) CHARSET=utf8mb4, ENGINE=InnoDb;