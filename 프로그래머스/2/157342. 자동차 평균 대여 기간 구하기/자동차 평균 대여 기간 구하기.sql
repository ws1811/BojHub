-- 평균 대여 기간이 7일 이상인 자동차들의
-- 자동차 ID와 평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트를 출력
-- 평균 대여 기간은 소수점 두번째 자리에서 반올림
-- 결과는 평균 대여 기간을 기준으로 내림차순 정렬
-- 평균 대여 기간이 같으면 자동차 ID를 기준으로 내림차순 정렬

SELECT  car_id
        ,ROUND(AVG(end_date - start_date + 1), 1) as AVERAGE_DURATION
FROM    car_rental_company_rental_history
GROUP BY      
        car_id
HAVING  AVG(end_date - start_date + 1) >= 7
ORDER BY
        AVERAGE_DURATION desc, car_id desc

