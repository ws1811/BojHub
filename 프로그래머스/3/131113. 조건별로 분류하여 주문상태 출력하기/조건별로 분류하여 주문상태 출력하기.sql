-- 5월 1일을 기준으로 
-- 주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문을 작성
-- 출고여부는 5월 1일까지 출고완료로 이 후 날짜는 출고 대기로 미정이면 출고미정으로 출력
-- 결과는 주문 ID를 기준으로 오름차순 정렬
SELECT  order_id
        ,product_id
        ,to_char(out_date, 'YYYY-MM-DD')
        ,case when out_date <= to_date('2022-05-01', 'YYYY-MM-DD') then '출고완료'
              when  out_date is null then '출고미정'
              else  '출고대기'
        end as 출고여부
FROM    food_order
ORDER BY order_id