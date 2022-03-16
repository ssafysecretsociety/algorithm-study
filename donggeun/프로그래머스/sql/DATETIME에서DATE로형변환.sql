-- String, Date
-- https://programmers.co.kr/learn/courses/30/lessons/59414
select animal_id, name, date_format(datetime, "%Y-%m-%d") 날짜
from animal_ins