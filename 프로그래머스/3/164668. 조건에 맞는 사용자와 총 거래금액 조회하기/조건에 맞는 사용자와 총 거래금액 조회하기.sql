-- USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서
-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의
-- 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성
-- 결과는 총거래금액을 기준으로 오름차순 정렬
SELECT  u.user_id
        ,u.nickname
        ,b.total_sales
FROM     (SELECT  writer_id
                ,sum(price) as total_sales
         FROM    used_goods_board 
         WHERE   status='DONE'
         GROUP BY writer_id
         HAVING  sum(price) >= 700000) b
JOIN    used_goods_user u
ON      u.user_id = b.writer_id
ORDER BY total_sales



