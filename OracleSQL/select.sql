-- bwriter�� ���ڹ��� �Խù� �������
select *
from board
where bwriter='���ڹ�';

-- bwriter�� �������� �Խù��� bno, btitle, bwriter ��������
select bno, btitle, bwriter
from board
where bwriter='������';

-- bno�� 1���� 10������ �Խù� ��������
select *
from board
where bno>=1 and bno<=10;

select *
from board
where bno between 1 and 10;

-- bwriter�� '��'�� �����ϴ� �Խù��� bno, btitle, bwriter ��������
select bno, btitle, bwriter
from board
where bwriter like '%��%';

-- ���� �� '����'�� ���Ե� �Խñ��� bno, btitle, bwriter ��������
select bno, btitle, bwriter
from board
where btitle like '%����%';

-- ����, ���� �� '�ڹ�'�� ���Ե� �Խñ��� bno, btitle, bwriter ��������
select bno, btitle, bwriter, bcontent
from board
where btitle like '%�ڹ�%' or bcontent like '%�ڹ�%';

-- �۾��̰� '���ڹ�', '��浿', '�����'�� �Խù��� bno, btitle, bwriter ��������
select bno, btitle, bwriter, bcontent
from board
where bwriter='���ڹ�' or bwriter='��浿' or bwriter='�����';

select bno, btitle, bwriter, bcontent
from board
where bwriter in ('���ڹ�', '��浿', '�����');

-- ÷�� ������ ���� �Խù��� ��������
select *
from board
where boriginalfilename is null;

-- ÷�� ������ �ִ� �Խù��� ��������
select *
from board
where boriginalfilename is not null;

-- �Խù��� �ۼ��� ����� �̸��� ��������(�ߺ� ����)
select distinct bwriter
from board;

-- �Խù��� ��¥�� 2016���� �Խñ��� ��������
select *
from board
where '2016.01.01'<=bdate and bdate<='2016.12.31';

select *
from board
where bdate between '2016.01.01' and '2016.12.31';

-- bno -> ��ȣ, btitle -> ����, bwriter -> �۾��̷� �÷� �̸��� �����ؼ� ��������
select bno as ��ȣ, btitle as ����, bwriter as �۾���
from board;

-- �Խù��� ��ȣ�� �������� �ø����� ��������
select *
from board
order by bno asc;

-- 2017�⿡ �ۼ��� �Խù��� ��ȣ�� �������� �������� ��������
select *
from board
where bdate between '2017.01.01' and '2017.12.31'
order by bno desc;

-- �۾��̸� �������� 1�� ����(�ø�)�ϰ�, �� ��¥�� �������� 2�� ����(����)�Ͻÿ�
select *
from board
order by bwriter asc, bdate desc;

-- ����¡ó��
-- ����Ǿ� �ִ� ������� �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

-- ���� ��, �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);

-- Ư�� �� ��ȣ ���ϸ� ��������(TOP N)
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
where rownum<=10;

-- �� ��ȣ ������ �̿��ؼ� ��������
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
where rownum<=10;

-- ���� �� ��ȣ�� �� �� ��ȣ ������ �Խù� ��������
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

-- ��ü �� �� ���ϱ�
select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

-- Ư�� ���ǿ� �´� ��� ���ϱ�
select count(*) from board where bwriter <> '������';
