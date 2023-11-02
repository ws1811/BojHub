-- 경기도에 위치한 창고의
-- ID, 이름, 주소, 냉동시설 여부를 조회
-- 냉동시설 여부가 NULL인 경우, 'N'으로 출력
-- 결과는 창고 ID를 기준으로 오름차순 정렬
SELECT   warehouse_id
         ,warehouse_name
         ,address
         ,NVL(freezer_yn, 'N')
FROM     food_warehouse
WHERE    address like '%경기도%'
ORDER BY warehouse_id;