drop table account;

create table account (
    ano varchar(20) primary key,
    aowner varchar(10) not null,
    abalance number not null
);

--rollback : 마지막 commit 상태로 되돌린다(현재 작업 취소)
insert into account values('111-111', '홍길동', 1000000);
insert into account values('222-222', '스프링', 0);
select * from account;

rollback;
select * from account;

--commit : 현재 작업을 영구적으로 저장(반영)한다.
insert into account values('111-111', '홍길동', 1000000);
insert into account values('222-222', '스프링', 0);
select * from account;
commit;

rollback;
select * from account;

--기능 단위의 트랜젝션 처리
update account set abalance=abalance-10000 where ano='111-111';
update account set abalance=abalance+10000 where ano='222-223';

select * from account;
rollback;