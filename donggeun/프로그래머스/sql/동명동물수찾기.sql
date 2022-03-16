-- GROUP BY
-- https://programmers.co.kr/learn/courses/30/lessons/59041
select NAME, count(NAME) 'COUNT'
from ANIMAL_INS
group by NAME
having count(NAME) >= 2
order by NAME