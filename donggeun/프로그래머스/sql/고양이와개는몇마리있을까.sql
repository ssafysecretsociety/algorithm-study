-- GROUP BY
-- https://programmers.co.kr/learn/courses/30/lessons/59040

select ANIMAL_TYPE, count(*)
from ANIMAL_INS
group by ANIMAL_TYPE
order by ANIMAL_TYPE