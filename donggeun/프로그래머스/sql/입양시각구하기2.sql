-- GROUP BY
-- https://programmers.co.kr/learn/courses/30/lessons/59413
SET @HOUR = -1;
SELECT (@HOUR := @HOUR + 1) AS HOUR, (
    SELECT COUNT(*)
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME) = @HOUR
) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23;