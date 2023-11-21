-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
-- 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬
-- 기본적인 파일경로는 /home/grep/src/ 
-- 게시글 ID를 기준으로 디렉토리가 구분되고, 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력
-- 조회수가 가장 높은 게시물은 하나만 존재
SELECT '/home/grep/src/'||b.BOARD_ID||'/'||FILE_ID||FILE_NAME||FILE_EXT as FILE_PATH
FROM USED_GOODS_BOARD b, USED_GOODS_FILE f
WHERE b.BOARD_ID = f.BOARD_ID
      AND VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY f.FILE_ID desc;