-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
-- 결과는 카테고리명을 기준으로 오름차순 정렬
SELECT  b.category
        ,sum(s.sales) as TOTAL_SALES
FROM    book_sales s
JOIN    book b
ON      s.book_id = b.book_id
WHERE   to_char(s.sales_date, 'YYYY-MM') = '2022-01'
GROUP BY
        b.category
ORDER BY
        b.category