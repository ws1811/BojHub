-- USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요. 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.
SELECT  u.user_id
        ,u.nickname
        ,sq.total_sales
FROM    used_goods_user u
JOIN    (
        SELECT  b.writer_id     AS  USER_ID      
                ,sum(b.price)   AS  TOTAL_SALES
        FROM    used_goods_board b
        WHERE   b.status = 'DONE'
        GROUP BY
                b.writer_id
        HAVING  sum(b.price) >= 700000
        ) sq
ON      u.user_id = sq.user_id
ORDER BY
        sq.total_sales