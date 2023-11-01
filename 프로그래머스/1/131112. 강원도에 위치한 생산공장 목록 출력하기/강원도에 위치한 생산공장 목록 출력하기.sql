-- FOOD_FACTORY 테이블에서
-- 강원도에 위치한 식품공장의
-- 공장ID, 공장 이름, 주소  조회
-- 정렬 : 공장 ID 기준 오름차순
SELECT factory_id
      ,factory_name
      ,address
FROM food_factory
WHERE address like '강원도%'
ORDER BY factory_id;