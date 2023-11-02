-- 2021년에 가입한 회원 중
-- 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력
SELECT count(*) as users
FROM   user_info
WHERE  age between 20 and 29
   and to_char(joined, 'YYYY') = '2021';