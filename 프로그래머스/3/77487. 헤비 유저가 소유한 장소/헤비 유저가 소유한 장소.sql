-- 코드를 입력하세요
SELECT  id
        ,name
        ,host_id
FROM    places
WHERE   host_id in(SELECT      host_id
                 FROM        places
                 GROUP BY    host_id
                 HAVING      count(*) >= 2)