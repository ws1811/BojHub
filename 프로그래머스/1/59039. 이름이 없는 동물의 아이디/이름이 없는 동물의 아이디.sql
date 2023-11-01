-- 동물 중, 이름이 없는 채로 들어온 동물의 ID를 조회
-- 단, ID는 오름차순 정렬되어야 합니다.
SELECT animal_id
FROM   animal_ins
WHERE  name is null
ORDER BY animal_id;