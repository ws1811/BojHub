-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블
-- ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블
-- 아직 입양을 못 간 동물 중, 
-- 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성
-- 결과는 보호 시작일 순으로 조회
SELECT  *
FROM    (SELECT  i.name
                ,i.datetime
        FROM    animal_ins i
        LEFT
        JOIN    animal_outs o
        ON      i.animal_id = o.animal_id
        WHERE   o.animal_id IS NULL
        ORDER BY i.datetime)
WHERE   rownum <=3