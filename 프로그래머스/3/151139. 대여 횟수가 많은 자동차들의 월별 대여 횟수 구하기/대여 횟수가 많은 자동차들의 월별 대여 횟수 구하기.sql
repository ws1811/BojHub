-- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 
-- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 
-- 총 대여 횟수가 5회 이상인 자동차들에 대해서 
-- 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력하는 SQL문을 작성해주세요. 
-- 결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬해주세요. 
-- 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요.
-- 코드를 입력하세요

SELECT      extract(month from start_date) as month
            ,car_id
            ,count(start_date) as records
FROM        car_rental_company_rental_history
WHERE       car_id in (
                        SELECT      car_id
                        FROM        car_rental_company_rental_history
                        WHERE       extract(month from start_date) in (8, 9, 10)
                                    and extract(year from start_date) = 2022
                        GROUP BY    car_id
                        HAVING      count(*) >= 5
)
and         8 <= EXTRACT(MONTH FROM START_DATE) AND EXTRACT(MONTH FROM START_DATE) <= 10
GROUP BY    extract(month from start_date), car_id 
ORDER BY    month, car_id desc;