-- 2022년 10월에 작성된
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일 조회
-- 댓글 작성일 기준 오름차순 정렬 -> 게시글 제목 기준 오름차순 정렬
SELECT b.title
      ,b.board_id
      ,r.reply_id
      ,r.writer_id
      ,r.contents
      ,to_char(r.created_date, 'YYYY-MM-DD') as created_date
FROM   used_goods_board b
INNER JOIN   used_goods_reply r
ON     b.board_id = r.board_id
WHERE  extract(year from b.created_date) = 2022
   and extract(month from b.created_date) = 10
ORDER BY r.created_date asc, 
         b.title;