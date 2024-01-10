-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 
-- 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.
SELECT  flavor
FROM    (   
        SELECT  f.flavor
        FROM    first_half f
        JOIN    (
                    SELECT  flavor
                            ,sum(total_order) as total_order
                    FROM    july
                    GROUP BY
                            flavor
                ) j
        ON      f.flavor = j.flavor
        ORDER BY
                f.total_order + j.total_order desc
        )
WHERE   rownum <= 3

