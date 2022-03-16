-- String, Date
-- https://programmers.co.kr/learn/courses/30/lessons/59411
select o.animal_id, o.name
from animal_outs o
         left join animal_ins i
                   on o.animal_id = i.animal_id
order by o.datetime - i.datetime desc limit 2