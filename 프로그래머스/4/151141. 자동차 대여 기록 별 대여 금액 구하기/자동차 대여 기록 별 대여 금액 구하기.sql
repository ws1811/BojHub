-- 자동차 종류가 '트럭'인 자동차의 대여 기록에 대해서
-- 대여 기록 별로 대여 금액(컬럼명: FEE)을 구하여 
-- 대여 기록 ID와 대여 금액 리스트를 출력하는 SQL문을 작성
-- 결과는 대여 금액을 기준으로 내림차순 정렬
-- 대여 금액이 같은 경우 대여 기록 ID를 기준으로 내림차순 정렬
SELECT   t.history_id
        ,TRUNC(t.duration * t.daily_fee * (1 - NVL(p.discount_rate, 0) / 100)) AS FEE
FROM    (
        SELECT    h.history_id
                    ,c.car_type
                    ,c.daily_fee
                    ,h.end_date - h.start_date + 1 AS DURATION
                    ,CASE   WHEN h.end_date - h.start_date + 1 BETWEEN 7 AND 29 THEN '7일 이상'
                            WHEN h.end_date - h.start_date + 1 BETWEEN 30 AND 89 THEN '30일 이상'
                            WHEN h.end_date - h.start_date + 1 >= 90 THEN '90일 이상'
                        END AS DURATION_TYPE
        FROM   car_rental_company_car c
        JOIN
                 car_rental_company_rental_history h
        ON     c.car_id = h.car_id
        WHERE  c.car_type = '트럭'
        ) t
LEFT JOIN
        car_rental_company_discount_plan p
ON      t.car_type = p.car_type
AND     t.duration_type = p.duration_type
ORDER BY FEE DESC, t.history_id DESC