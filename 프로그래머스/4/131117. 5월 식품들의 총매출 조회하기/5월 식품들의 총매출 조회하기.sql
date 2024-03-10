-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 
-- 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 
-- 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.
SELECT  p.product_id
        ,p.product_name
        ,sum(p.price * o.amount) as total_sales
FROM    food_order o
JOIN    food_product p
ON      o.product_id = p.product_id
WHERE   to_char(produce_date, 'YYYY-MM') = '2022-05'
GROUP BY
        p.product_id,p.product_name
ORDER BY    
        total_sales desc
        ,product_id;