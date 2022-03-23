-- JOIN
-- https://programmers.co.kr/learn/courses/30/lessons/59044
select i.name, i.datetime
from animal_ins i
         left join animal_outs o
                   on i.animal_id = o.animal_id
where o.datetime is null
order by datetime limit 3;