-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
-- 결과는 카테고리명을 기준으로 오름차순 정렬

SELECT  b.category
        ,sum(s.sales) as TOTAL_SALES
FROM    BOOK b
JOIN    BOOK_SALES s
ON      b.book_id = s.book_id
WHERE   extract(year from s.sales_date) = 2022
        and extract(month from s.sales_date) = 1
GROUP BY b.category
ORDER BY b.category 
