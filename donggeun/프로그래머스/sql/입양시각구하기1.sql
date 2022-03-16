-- GROUP BY
-- https://programmers.co.kr/learn/courses/30/lessons/59412

select hour (datetime), count (animal_id)
from animal_outs
WHERE HOUR (DATETIME) between 9 AND 19
group by hour (datetime)
order by hour (datetime)
