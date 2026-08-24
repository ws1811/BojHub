-- SELECT  COUNT(DISTINCT name)
-- FROM    ANIMAL_INS
-- ;

SELECT COUNT(*)
FROM (
    SELECT  name
    FROM    ANIMAL_INS
    WHERE   name IS NOT NULL
    GROUP BY name
) t;