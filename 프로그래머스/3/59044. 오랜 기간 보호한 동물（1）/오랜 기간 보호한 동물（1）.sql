-- 아직 입양을 못 간 동물 중, 
-- 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 보호 시작일 순으로 조회해야 합니다
SELECT  name
        ,datetime
FROM
       (
        SELECT  i.name  AS name
                ,i.datetime AS datetime
                ,o.datetime AS d
        FROM    animal_ins i
        LEFT
        JOIN    animal_outs o
        ON      i.animal_id = o.animal_id
        WHERE   o.name IS NULL
        AND     i.name IS NOT NULL
        ORDER BY
                i.datetime
        )
WHERE   ROWNUM <= 3
ORDER BY    
        datetime
    ;

