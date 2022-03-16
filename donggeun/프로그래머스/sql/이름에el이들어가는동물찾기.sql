-- String, Date
-- https://programmers.co.kr/learn/courses/30/lessons/59047
select animal_id, name
from animal_ins
where name like '%el%'
  and animal_type = 'dog'
order by name