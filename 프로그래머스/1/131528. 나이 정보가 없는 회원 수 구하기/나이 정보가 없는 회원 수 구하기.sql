-- 나이 정보가 없는 회원이 몇 명인지 출력하는 SQL문을 작성해
-- 이때 컬럼명은 USERS로 지정
SELECT  count(*) as USERS
FROM    user_info
WHERE   age is null;