-- 내 스키마
DROP SCHEMA IF EXISTS exam;

-- 내 스키마
CREATE SCHEMA exam;

-- 직책
CREATE TABLE exam.title (
	tno  INT         NOT NULL COMMENT '번호', -- 번호
	name VARCHAR(20) NOT NULL COMMENT '직책' -- 직책
)
COMMENT '직책';

-- 직책
ALTER TABLE exam.title
	ADD CONSTRAINT PK_title -- 직책 기본키
		PRIMARY KEY (
			tno -- 번호
		);
		
select * from title;