-- 테이블에서 자동차 종류가 '세단'인 자동차들 중 
-- 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성해주세요. 
-- 자동차 ID 리스트는 중복이 없어야 하며, 
-- 자동차 ID를 기준으로 내림차순 정렬해주세요.

SELECT  distinct(c.car_id)
FROM    car_rental_company_car c
JOIN    car_rental_company_rental_history h
ON      c.car_id = h.car_id
WHERE   extract(month FROM h.start_date) = 10
AND     c.car_type = '세단'
ORDER BY
        c.car_id desc
