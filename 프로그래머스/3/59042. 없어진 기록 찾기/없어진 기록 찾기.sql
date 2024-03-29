-- 천재지변으로 인해 일부 데이터가 유실되었습니다. 
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의
-- ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
SELECT  o.animal_id
        ,o.name
FROM    animal_outs o
LEFT
JOIN    animal_ins i
ON      i.animal_id = o.animal_id
WHERE   i.datetime IS NULL
ORDER BY
        o.animal_id