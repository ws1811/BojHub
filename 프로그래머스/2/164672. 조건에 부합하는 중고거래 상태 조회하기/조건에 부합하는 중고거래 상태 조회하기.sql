-- 2022년 10월 5일에 등록된 중고거래 게시물의 
-- 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회
-- 거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류
-- 결과는 게시글 ID를 기준으로 내림차순 정렬

SELECT board_id
       ,writer_id
       ,title
       ,price
       ,case when status = 'SALE' then '판매중'
             when status = 'DONE' then '거래완료'
             when status = 'RESERVED' then '예약중'
        end as status
FROM   used_goods_board
WHERE  created_date = '2022-10-05'
ORDER BY board_id desc;