create table web2_member(
webm_id varchar2(10 char) primary key,
webm_pw varchar2(12 char) not null,
webm_name varchar2(12 char) not null,
webm_age number(3)not null,
webm_adr varchar2(100 char)not null,
webm_birthday date not null,
webm_photo varchar2(100 char)not null
);
--1)데이터 다 가져와서 for if문써서(비효율적)
insert into web2_member values('dlwnsgk23','12345','이준하',23,'경기도 남양주시 평내동 123',to_date(?,'YYYYMMDD'),'btc.png');
delete from WEB2_MEMBER;
select * from WEB2_MEMBER;
select webm_id,webm_pw from WEB2_MEMBER where webm_id='dlwnsgk23' and webm_pw='dlwnsgk0108';
--2)id/pw맞는 계정만 가져와서
--DAO에서 로그인 성공처리하자
--SQL injection공격에 취약
select*from web2_member where webm_id='' and webm_pw='' --or like webm_id='asd'
--3) id맞는 계정만 가져와서
--DAO에서 비번검사
select*from WEB2_MEMBER where webm_id='ㅁㄴㅇ';
--스마트폰 앱->하이브리드 앱->보안코딩->BD/AI
delete from web2_member where webm_id=?;

update web2_member
set webm_pw = ?, webm_name = ?, webm_adr = ?, webm_photo=?
where webm_id = ?;

select*from web2_member where webm_id = 'dlwnsgk23'; 


--탈퇴했을떄 글 삭제 하기위해 외래키 사용
--constraint sns_writer  (제약명)
--foreign key(webs_writer) references web2_member(webm_id) (web2member아이디와 연관)
--on delete cascade (지워지면 다 지워라)

create table sns(
sns_no number(3) primary key,
sns_writer varchar2(10 char)not null,
sns_txt varchar2(500 char) not null,
sns_date date not null,
constraint snss_writer
foreign key (sns_writer) references web2_member(webm_id)
on delete cascade
);
create sequence may26_bbs_seq;
create sequence sns_seq; may26_BBS_seq.nextval
insert into sns values(sns_seq.nextval,'dlwnsgk23','asd',sysdate);


select count(*)
from SNS
where sns_txt like '%'||?||'%'

select*
from sns
where sns_txt like '%%';

