create table sns_re(
sre_no number(4) primary key,
sre_sns_no number(3) not null,
sre_writer varchar2(10 char)not null,
sre_txt varchar2 (150 char)not null,
sre_date date not null,
constraint sns_reply
foreign key(sre_sns_no)references sns(sns_no)
on delete cascade,
constraint sns_reply_writer
foreign key(sre_writer) references web2_member(webm_id)
on delete cascade
);
sns(sns_no)
web2_member(webm_id)
drop table sns_re;

create sequence sns_re_seq;

insert into sns_re values(sns_re_seq.nextval, ?, ?, ?,sysdate);



select *
from sns_re
where sre_sns_no = 35

select*
from 


select*from sns_re where sre_sns_no=35 order by sre_date desc;





create table photozone(
pz_no number(3) primary key,
pz_writer varchar2(50 char)not null,
pz_photo varchar2(100 char)not null,
pz_date date not null,
constraint photo_writer
foreign key (pz_writer) references WEB2_MEMBER(webm_id)
on delete cascade
);
create sequence photozone_seq;
insert into photozone values(photozone_seq.nextval,?,?,sysdate)
select*from photozone where ;

select rownum as rn, pz_no, pz_writer, pz_photo, pz_date
from(
select*from photozone order by pz_date desc

)
where rn>=1 and rn<=3;

SELECT *
FROM (
SELECT rownum AS rn, pz_no, pz_writer, pz_photo, pz_date
FROM (
SELECT *
FROM photozone
ORDER BY pz_date DESC
)
)
WHERE rn >= 1 AND rn <= 3;

create table photozone_like(
pzl_no number(5)primary key,
pzl_pz_no number(5)not null,
pzl_like number(9)not null,
constraint photo_like
foreign key(pzl_pz_no) references photozone(pz_no)
on delete cascade,
constraint photo_like_zero
foreign key(pzl_like) references photozone(pz_no)
on delete cascade
);

drop table PHOTOZONE_like;

create sequence photozone_like_seq;
insert into PHOTOZONE_like values(seq.naextval,?,?);




