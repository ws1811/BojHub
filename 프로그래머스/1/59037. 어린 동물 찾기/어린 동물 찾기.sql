-- 동물 중 젊은 동물의 아이디와 이름을 조회
-- 결과는 아이디 순으로 조회
SELECT animal_id, name
FROM   animal_ins
WHERE  INTAKE_CONDITION <> 'Aged'
ORDER BY animal_id;