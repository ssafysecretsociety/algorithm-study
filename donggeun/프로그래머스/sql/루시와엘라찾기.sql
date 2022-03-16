-- String, Date
-- https://programmers.co.kr/learn/courses/30/lessons/59046
select animal_id, name, sex_upon_intake
from animal_ins
where name in ('lucy', 'ella', 'pickle', 'rogan', 'sabrina', 'mitty')