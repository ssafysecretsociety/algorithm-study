-- String, Date
-- https://programmers.co.kr/learn/courses/30/lessons/59409
select animal_id, name, if(sex_upon_intake like '%Neutered%' or sex_upon_intake like '%Spayed%', 'O', 'X') 중성화
from animal_ins;