-- �� ��Ű��
DROP SCHEMA IF EXISTS exam;

-- �� ��Ű��
CREATE SCHEMA exam;

-- ��å
CREATE TABLE exam.title (
	tno  INT         NOT NULL COMMENT '��ȣ', -- ��ȣ
	name VARCHAR(20) NOT NULL COMMENT '��å' -- ��å
)
COMMENT '��å';

-- ��å
ALTER TABLE exam.title
	ADD CONSTRAINT PK_title -- ��å �⺻Ű
		PRIMARY KEY (
			tno -- ��ȣ
		);
		
select * from title;