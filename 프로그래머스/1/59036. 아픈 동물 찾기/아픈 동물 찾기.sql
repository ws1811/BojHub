-- 동물 중 아픈 동물의 아이디와 이름을 조회
-- 결과는 아이디 순
SELECT animal_id, name
FROM   animal_ins
WHERE  INTAKE_CONDITION = 'Sick'
ORDER BY animal_id;