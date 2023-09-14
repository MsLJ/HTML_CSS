create table sns(
sns_no number(3) primary key,
sns_writer varchar2(10 char)not null,
sns_txt varchar2(500 char) not null,
sns_date date not null,
constraint snss_writer
foreign key (sns_writer) references web2_member(webm_id)
on delete cascade
);
select*from SNS;


select sns_no, sns_txt,sns_date, webm_id, webm_photo from sns, WEB2_MEMBER  where sns_writer=webm_id order by sns_date desc;




글 번호
글 내용
글쓴 날짜

글쓴사람 id
글쓴사람 프사
글쓴사람 이름

댓글
select*from
(select rownum as rn, d_no, d_title, d_date
from(select d_no, d_title, d_date from may30_dataroom order by d_date desc ) ) 
where rn>=? and rn<=?

select*from
(select rownum as rn, sns_no, sns_txt,sns_date, webm_id, webm_photo
select sns_no, sns_txt,sns_date, webm_id, webm_photo 
from sns, WEB2_MEMBER  where sns_writer=webm_id 
order by sns_date desc
where rn>=1 and rn<=3;


--subquery:줄어
--join:폭증
--join할시에 10000000(게시글수)*10000000(아이디수)=>?(RAM에 담는데)

--1)날짜순역순,글만

select *
from (
  select rownum as rn, sns_no, sns_writer, sns_txt, sns_date
  from (
    select *
    from sns
    order by sns_date desc
  )
)
where rn >= 3 and rn <= 5;

--2)날짜순역순으로 3~5번글 쓴 사람 id,프사
select webm_id, webm_photo 
from web2_member
where webm_id in (
	select sns_writer
	from (
		select rownum as rn, sns_no, sns_txt, sns_writer, sns_date 
		from (
			select *
			from sns 
			order by sns_date desc
		)
	)
	where rn >= 1 and rn <= 5 
)


--3)1,2join

select sns_no, webm_id, sns_txt, sns_date
from (select *
from (
  select rownum as rn, sns_no, sns_writer, sns_txt, sns_date
  from (
    select *
    from sns
    where sns_txt like'%%'
    order by sns_date desc
  )
)
where rn >= 1 and rn <= 5
),(select webm_id, webm_photo 
from web2_member
where webm_id in (
	select sns_writer
	from (
		select rownum as rn, sns_no, sns_txt, sns_writer, sns_date 
		from (
			select *
			from sns 
			where sns_txt like'%%'
			order by sns_date desc
		)
	)
	where rn >= 1 and rn <= 5 
)
)
where sns_writer =webm_id
order by sns_date desc;




select sns_no, webm_id, sns_txt, sns_date
from (select *
from (
  select rownum as rn, sns_no, sns_writer, sns_txt, sns_date
  from (
    select *
    from sns
    where sns_txt like'%%'
    order by sns_date desc
  )
)
where rn >= 3 and rn <= 5
),(select webm_id, webm_photo 
from web2_member
where webm_id in (
	select sns_writer
	from (
		select rownum as rn, sns_no, sns_txt, sns_writer, sns_date 
		from (
			select *
			from sns 
			where sns_txt like'%%'
			order by sns_date desc
		)
	)
	where rn >= 3 and rn <= 5 
)
)
where sns_writer =webm_id
order by sns_date desc;














select*
from(
select * 
from(
select rownum as rn, sns_no ,sns_txt ,sns_date 
from(
 select *
from sns order by sns_date desc
)
)
where rn>=3 and rn<=5
), (
select webm_id, webm_photo 
from web2_member
where webm_id in (
	select sns_writer
	from (
		select rownum as rn, sns_no, sns_txt, sns_writer, sns_date 
		from (
			select *
			from sns 
			order by sns_date desc
		)
	)
	where rn >= 3 and rn <= 5
)
)
where sns_writer = webm_id
order by sns_date desc;























select * from
(select rownum as rn, sns_no, sns_txt, sns_date, webm_id, webm_photo 
from sns, WEB2_MEMBER 
where sns_writer = webm_id 
order by sns_date desc)
where rn >= 3 and rn <= 5;









