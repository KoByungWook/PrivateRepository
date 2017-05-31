-- bwriter가 감자바인 게시물 가져요기
select *
from board
where bwriter='감자바';

-- bwriter가 스프링인 게시물의 bno, btitle, bwriter 가져오기
select bno, btitle, bwriter
from board
where bwriter='스프링';

-- bno가 1에서 10사이인 게시물 가져오기
select *
from board
where bno>=1 and bno<=10;

select *
from board
where bno between 1 and 10;

-- bwriter가 '스'를 포함하는 게시물의 bno, btitle, bwriter 가져오기
select bno, btitle, bwriter
from board
where bwriter like '%스%';

-- 제목 중 '제목'이 포함된 게시글의 bno, btitle, bwriter 가져오기
select bno, btitle, bwriter
from board
where btitle like '%제목%';

-- 제목, 내용 중 '자바'이 포함된 게시글의 bno, btitle, bwriter 가져오기
select bno, btitle, bwriter, bcontent
from board
where btitle like '%자바%' or bcontent like '%자바%';

-- 글쓴이가 '감자바', '김길동', '라즈베리'인 게시물의 bno, btitle, bwriter 가져오기
select bno, btitle, bwriter, bcontent
from board
where bwriter='감자바' or bwriter='김길동' or bwriter='라즈베리';

select bno, btitle, bwriter, bcontent
from board
where bwriter in ('감자바', '김길동', '라즈베리');

-- 첨부 파일이 없는 게시물을 가져오기
select *
from board
where boriginalfilename is null;

-- 첨부 파일이 있는 게시물을 가져오기
select *
from board
where boriginalfilename is not null;

-- 게시물을 작성한 사람의 이름을 가져오기(중복 제거)
select distinct bwriter
from board;

-- 게시물의 날짜가 2016년인 게시글을 가져오기
select *
from board
where '2016.01.01'<=bdate and bdate<='2016.12.31';

select *
from board
where bdate between '2016.01.01' and '2016.12.31';

-- bno -> 번호, btitle -> 제목, bwriter -> 글쓴이로 컬럼 이름을 변경해서 가져오기
select bno as 번호, btitle as 제목, bwriter as 글쓴이
from board;

-- 게시물의 번호를 기준으로 올림차순 가져오기
select *
from board
order by bno asc;

-- 2017년에 작성한 게시물의 번호를 기준으로 내림차순 가져오기
select *
from board
where bdate between '2017.01.01' and '2017.12.31'
order by bno desc;

-- 글쓴이를 기준으로 1차 정렬(올림)하고, 쓴 날짜를 기준으로 2차 정렬(내림)하시오
select *
from board
order by bwriter asc, bdate desc;

-- 페이징처리
-- 저장되어 있는 순서대로 행 번호 매기기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

-- 정렬 후, 행 번호 매기기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);

-- 특정 행 번호 이하만 가져오기(TOP N)
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
where rownum<=10;

-- 행 번호 범위를 이용해서 가져오기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
where rownum<=10;

-- 시작 행 번호와 끝 행 번호 사이의 게시물 가져오기
select *
from (
    select rownum as r, bno, btitle, bwriter, bdate, bhitcount
    from (
        select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc
    )
    --where rownum<=(pageNo*rowsPerPage)
    where rownum<=(2*10)
)
--where r>=((pageNo-1)*rowsPerPage + 1);
where r>=((2-1)*10+1);

-- 전체 행 수 구하기
select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

-- 특정 조건에 맞는 행수 구하기
select count(*) from board where bwriter <> '스프링';
