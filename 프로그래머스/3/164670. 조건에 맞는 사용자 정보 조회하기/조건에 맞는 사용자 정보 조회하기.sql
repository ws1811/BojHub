-- USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 
-- 중고 거래 게시물을 3건 이상 등록한 사용자의 
-- 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성해주세요. 
-- 이때, 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력되도록 해주시고, 
-- 전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력해주세요. 
-- 결과는 회원 ID를 기준으로 내림차순 정렬해주세요.
SELECT  user_id
        ,nickname
        , (city || ' ' || street_address1 || ' ' ||  street_address2) AS 전체주소
        ,SUBSTR(tlno, 1, 3) || '-' || SUBSTR(tlno, 4, 4) || '-' || SUBSTR(tlno, 8) AS 전화번호
FROM    used_goods_user
WHERE   user_id IN (
                    SELECT  writer_id
                    FROM    used_goods_board
                    GROUP BY
                            writer_id
                    HAVING  count(board_id) >= 3  
    )
ORDER BY
        user_id desc