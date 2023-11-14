-- 입양을 간 동물 중, 
-- 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회
-- 결과는 보호 기간이 긴 순으로 조회
SELECT  animal_id
        ,name
FROM(
    SELECT  i.animal_id
            ,i.name
            ,o.datetime - i.datetime as 보호기간
    FROM    animal_ins i
    JOIN    animal_outs o
    ON      i.animal_id = o.animal_id
    ORDER BY (o.datetime - i.datetime) desc
    )
WHERE   rownum <=2