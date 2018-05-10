 -----------member_grade------------------------
DROP TABLE member_grade;
DROP SEQUENCE member_grade_SEQ;

CREATE TABLE member_grade(
    member_grade_no NUMBER PRIMARY KEY, 
    grade VARCHAR2(10) NOT NULL
)

CREATE SEQUENCE member_grade_SEQ;

---------------------point_type--------------
DROP TABLE point_type;
DROP SEQUENCE point_type_SEQ;

CREATE TABLE point_type(
    point_type_no NUMBER PRIMARY KEY, 
    type VARCHAR2(10) NOT NULL
)

CREATE SEQUENCE point_type_SEQ;

--------------------subject----------------
DROP TABLE subject;
DROP SEQUENCE subject_SEQ;

CREATE TABLE subject(
    subject_no NUMBER PRIMARY KEY, 
    subject VARCHAR2(20) NOT NULL
)

CREATE SEQUENCE subject_SEQ;

------------trade_status-----------------------
DROP TABLE trade_status;
DROP SEQUENCE trade_status_SEQ;

CREATE TABLE trade_status(
	trade_status_no NUMBER PRIMARY KEY, 
    status VARCHAR2(10) NOT NULL
)

CREATE SEQUENCE trade_status_SEQ;

---------------------board_type--------------
DROP TABLE board_type;
DROP SEQUENCE board_type_SEQ;

CREATE TABLE board_type(
    board_type_no NUMBER PRIMARY KEY, 
    type VARCHAR2(10) NOT NULL
)

CREATE SEQUENCE board_type_SEQ;

-------------category-------------
DROP TABLE category;
DROP SEQUENCE category_SEQ;

CREATE TABLE category(
	category_no NUMBER PRIMARY KEY, 
    category VARCHAR2(10) NOT NULL
)

CREATE SEQUENCE category_SEQ;









------------bay_member--------------
DROP TABLE bay_member;

CREATE TABLE bay_member(
    id VARCHAR2(20) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    password VARCHAR2(20) NOT NULL, 
    email VARCHAR2(20) NOT NULL, 
    tel VARCHAR2(20) NOT NULL, 
    address VARCHAR2(100) NOT NULL, 
    point NUMBER DEFAULT 0, 
    member_grade_no NUMBER NOT NULL,
    CONSTRAINT FK_bay_member_member_grade_no FOREIGN KEY (member_grade_no)
    REFERENCES member_grade (member_grade_no) on delete cascade
)







--------------children-----------------------
DROP TABLE children;
DROP SEQUENCE children_SEQ;

CREATE TABLE children(
    children_no NUMBER PRIMARY KEY,
    gender VARCHAR2(20) NULL, 
    birth DATE NULL,
	id VARCHAR2(20),
	CONSTRAINT FK_children_id_bay_member_id FOREIGN KEY (id)
	REFERENCES bay_member (id)
)

CREATE SEQUENCE children_SEQ;

-----------rating------------------------
DROP TABLE rating;
DROP SEQUENCE rating_SEQ;

CREATE TABLE rating(
    id VARCHAR2(20) primary key, 
    trade_count number default 0,
    rating number default 0,
    CONSTRAINT FK_rating_id_bay_member_id FOREIGN KEY (id)
	REFERENCES bay_member (id)
)

CREATE SEQUENCE rating_SEQ;

-- bay_member를 생성할 때 rating도 생성
insert into RATING_TEST(id)
values('java')

-- 평점을 구하는 공식, 5에는 입력될 평점이 들어감 --> mybatis에서는 #{value}
update rating_test set trade_count = trade_count + 1,
rating = (5 + rating*trade_count)/(trade_count+1)

-----------------receive_message--------------------
DROP TABLE receive_message;
DROP SEQUENCE receive_message_SEQ;

CREATE TABLE message(
	receive_message_no NUMBER PRIMARY KEY,
    title VARCHAR2(100) NOT NULL, 
    content CLOB NOT NULL, 
    send VARCHAR2(20) NOT NULL,
    regdate DATE NOT NULL,
    status NUMBER DEFAULT 0,
    send_id VARCHAR2(20) NOT NULL,
    CONSTRAINT FK_message_id_bay_member_id FOREIGN KEY (id)
    REFERENCES bay_member (id)
)

CREATE SEQUENCE message_SEQ;

-----------------send_message--------------------
DROP TABLE send_message;
DROP SEQUENCE send_message_SEQ;

CREATE TABLE message(
	send_message_no NUMBER PRIMARY KEY,
    title VARCHAR2(100) NOT NULL, 
    content CLOB NOT NULL, 
    send VARCHAR2(20) NOT NULL,
    regdate DATE NOT NULL,
    receive_id VARCHAR2(20) NOT NULL,
    CONSTRAINT FK_message_id_bay_member_id FOREIGN KEY (id)
    REFERENCES bay_member (id)
)

CREATE SEQUENCE message_SEQ;

-----------bay_post--------------------
DROP TABLE bay_post;
DROP SEQUENCE bay_post_SEQ;

CREATE TABLE bay_post(
    bay_post_no NUMBER PRIMARY KEY,
    title VARCHAR2(100) NOT NULL, 
    content CLOB NOT NULL,
    regdate DATE NOT NULL, 
    thread NUMBER NOT NULL,
    depth NUMBER NOT NULL, 
    id VARCHAR2(20) NOT NULL, 
    board_type_no NUMBER NOT NULL, 
    subject_no NUMBER NOT NULL,
    CONSTRAINT FK_bay_post_id_bay_member_id FOREIGN KEY (id)
    REFERENCES bay_member (id),
    CONSTRAINT FK_bay_post_board_type_no FOREIGN KEY (board_type_no)
	REFERENCES board_type (board_type_no),
    CONSTRAINT FK_bay_post_subject_no FOREIGN KEY (subject_no)
	REFERENCES subject (subject_no)
)

CREATE SEQUENCE bay_post_SEQ;

--------------trade_post----------------------
DROP TABLE trade_post;
DROP SEQUENCE trade_post_SEQ;

CREATE TABLE trade_post(
	trade_post_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	regdate DATE NOT NULL,
	pick_count NUMBER NOT NULL, 
    price NUMBER NOT NULL,
    id VARCHAR2(20) NOT NULL, 
    category_no NUMBER NOT NULL,
    board_type_no NUMBER NOT NULL,
    trade_status_no NUMBER NOT NULL,
    trade_id VARCHAR2(20) DEFAULT NULL,
    is_delete number default 0,
    wish_price number default 0,
    suggest_content clob default NULL,
    CONSTRAINT FK_trade_post_category_no FOREIGN KEY (category_no)
    REFERENCES category (category_no),
    CONSTRAINT FK_trade_post_id_bay_member FOREIGN KEY (id)
    REFERENCES bay_member (id),
    CONSTRAINT FK_trade_post_board_type_no FOREIGN KEY (board_type_no)
	REFERENCES board_type (board_type_no),
    CONSTRAINT FK_trade_post_trade_status_no FOREIGN KEY (trade_status_no)
    REFERENCES trade_status (trade_status_no)
)

CREATE SEQUENCE trade_post_SEQ;









------------point_history----------------------
DROP TABLE point_history;
DROP SEQUENCE point_history_SEQ;

CREATE TABLE point_history(
    point_history_no NUMBER PRIMARY KEY,
    regdate date NOT NULL, 
    price NUMBER NOT NULL, 
    id VARCHAR2(20) NOT NULL, 
    point_type_no NUMBER NULL,
    CONSTRAINT FK_point_history_point_type FOREIGN KEY (point_type_no)
    REFERENCES point_type (point_type_no),
    CONSTRAINT FK_point_history_id_bay_member FOREIGN KEY (id)
    REFERENCES bay_member (id)
)

CREATE SEQUENCE point_history_SEQ;

-----------trade_history------------------
DROP TABLE trade_history;
DROP SEQUENCE trade_history_SEQ;

CREATE TABLE trade_history(
	trade_history_no NUMBER PRIMARY KEY,
	id varchar2(20) NOT NULL,
	trade_post_no NOT NULL,
	CONSTRAINT FK_trade_history_id FOREIGN KEY (id)
	REFERENCES bay_member (id),
	CONSTRAINT FK_trade_history_no FOREIGN KEY (trade_post_no)
	REFERENCES trade_post (trade_post_no)
)

CREATE SEQUENCE trade_history_SEQ;

--------------member_pick-----------------
DROP TABLE member_pick;
DROP SEQUENCE member_pick_SEQ;

CREATE TABLE member_pick(
	member_pick_no NUMBER PRIMARY KEY, 
    trade_post_no NUMBER NOT NULL, 
    id VARCHAR2(20) NOT NULL,
    CONSTRAINT FK_member_pick_trade_post FOREIGN KEY (trade_post_no)
	REFERENCES trade_post (trade_post_no),
    CONSTRAINT FK_member_pick_id_bay_member FOREIGN KEY (id)
    REFERENCES bay_member (id)
)

CREATE SEQUENCE member_pick_SEQ;

------------photo---------------------
DROP TABLE photo;
DROP SEQUENCE photo_SEQ;

CREATE TABLE photo(
    photo_no NUMBER PRIMARY KEY, 
    photo_path VARCHAR2(100) NOT NULL, 
    trade_post_no NUMBER NOT NULL,
    CONSTRAINT FK_photo_trade_post_no FOREIGN KEY (trade_post_no)
    REFERENCES trade_post (trade_post_no)
)

CREATE SEQUENCE photo_SEQ;
        
-------------comment-------------------
DROP TABLE bay_comment;
DROP SEQUENCE bay_comment_SEQ;

CREATE TABLE bay_comment(
    bay_comment_no NUMBER PRIMARY KEY, 
    thread NUMBER NOT NULL, 
    depth NUMBER NOT NULL, 
    bay_comment VARCHAR2(100) NOT NULL, 
    bay_post_no NUMBER NOT NULL, 
    id VARCHAR2(20) NOT NULL, 
    CONSTRAINT FK_comment_bay_post_no FOREIGN KEY (bay_post_no)
    REFERENCES bay_post (bay_post_no),
    CONSTRAINT FK_comment_id_bay_member_id FOREIGN KEY (id)
    REFERENCES bay_member (id)
)

CREATE SEQUENCE bay_comment_SEQ;
        
------------------trade_comment--------------
DROP TABLE trade_comment;
DROP SEQUENCE trade_comment_SEQ;

CREATE TABLE trade_comment(
    trade_comment_no NUMBER PRIMARY KEY, 
    thread NUMBER NOT NULL, 
    depth NUMBER NOT NULL, 
    trade_comment NUMBER NOT NULL, 
    trade_post_no NUMBER NULL, 
    id VARCHAR2(20) NOT NULL, 
    CONSTRAINT FK_trade_comment_trade_post FOREIGN KEY (trade_post_no)
    REFERENCES trade_post (trade_post_no),
    CONSTRAINT FK_trade_comment_id_bay_member FOREIGN KEY (id)
    REFERENCES bay_member (id)
)

CREATE SEQUENCE trade_comment_SEQ;

