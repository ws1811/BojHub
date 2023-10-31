-- 코드를 입력하세요
SELECT book_id
      ,to_char(published_date, 'YYYY-MM-DD')
FROM book
WHERE category = '인문'
    and to_date('2021-01-01', 'YYYY-MM-DD') <= published_date 
    and published_date <= to_date('2021-12-31', 'YYYY-MM-DD')
ORDER BY published_date;