create table may26_bbs(
b_no number(3)primary key,
b_title varchar2(100 char)not null,
b_txt varchar2(600 char)not null,
b_date date not null

);
DROP TABLE may26_bbs purge;
create sequence may26_bbs_seq;
insert into MAY26_BBS values(may26_BBS_seq.nextval,'test','testtt',sysdate);
select*from may26_bbs;
select*from may26_bbs order by b_date;

delete from may26_bbs
where b_no = 89;

select * from may30_dataroom where d_no=1;
select*
from(
select rownum as rn, b_no, b_title, b_date
from (
select b_no,b_title,b_date
from MAY26_BBS
order by b_date desc
)
)
where rn>=2 and rn<=5;

update may26_bbs
set b_title = ㅁㄴ21, b_txt =pp
where b_no = 85;

--파일은 결국 웹서버에 있어야 사용자가 다운 가능
--DB서버->웹서버 ->사용자?
--DB에 파일-x
--DB서버에는 파일명만

--ㅋ.png %2A.png
create table may30_dataroom(
d_no number(3)primary key,
d_title varchar2(100 char)not null,
d_file varchar2(200 char)not null,
d_date date not null
);
create sequence may30_dataroom_seq;
insert into may30_dataroom values(may30_dataroom_seq.nextval),1,1,sysdate);
select*from may30_dataroom;

insert into may30_dataroom values(may30_dataroom_seq.nextval,?,?,sysdate);
select*from(
select rownum as rn, d_no, d_title, d_date
from(
select d_no, d_title, d_date
from may30_dataroom
order by d_date desc
)
)
where rn>=? and rn<=?
delete 



