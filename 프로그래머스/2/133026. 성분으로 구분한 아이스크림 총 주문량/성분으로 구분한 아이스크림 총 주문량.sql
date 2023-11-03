-- 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량
-- 총주문량을 총주문량이 작은 순서대로 조회
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정

SELECT IC.INGREDIENT_TYPE
      ,SUM(FH.TOTAL_ORDER) AS TOTAL_ORDER
      
FROM   FIRST_HALF FH
JOIN   ICECREAM_INFO IC
ON      FH.FLAVOR = IC.FLAVOR
GROUP BY IC.INGREDIENT_TYPE;
