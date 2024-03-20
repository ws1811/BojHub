-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.
SELECT  i.animal_id
        ,i.name
FROM    animal_ins i
JOIN    animal_outs o
ON      i.animal_id = o.animal_id
WHERE   o.datetime < i.datetime
ORDER BY 
        i.datetime