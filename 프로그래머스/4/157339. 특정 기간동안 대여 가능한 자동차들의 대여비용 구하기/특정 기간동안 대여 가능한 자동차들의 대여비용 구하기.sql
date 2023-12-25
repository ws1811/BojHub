-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 

-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요. 
-- 결과는 대여 금액을 기준으로 내림차순 정렬하고, 
-- 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 
-- 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.

SELECT  distinct(c.car_id)
        ,c.car_type
        ,c.daily_fee * 30 * (1 - p.discount_rate / 100) AS FEE
FROM    car_rental_company_car c
JOIN    car_rental_company_rental_history h
ON      c.car_id = h.car_id
JOIN    car_rental_company_discount_plan p
ON      c.car_type = p.car_type
WHERE   c.car_id NOT IN (
                         SELECT     car_id
                         FROM       car_rental_company_rental_history
                         WHERE      end_date >= to_date('2022-11-01', 'YYYY-MM-DD')
                         AND        start_date <= to_date('2022-11-30', 'YYYY-MM-DD')
                        )
AND     p.duration_type = '30일 이상'
AND     c.car_type in ('SUV', '세단')
AND     c.daily_fee * 30 * (1 - p.discount_rate / 100) BETWEEN 500000 AND 1999999
ORDER 
BY      FEE DESC, c.car_type, c.car_id desc