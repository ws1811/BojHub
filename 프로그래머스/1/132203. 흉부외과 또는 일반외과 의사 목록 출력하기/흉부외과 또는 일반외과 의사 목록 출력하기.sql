-- DOCTOR 테이블에서
-- 진료과가 흉부외과(CS) 거나 일반외과(GS) 인 의사의
-- 이름, 의사ID, 진료과, 고용일자를 조회
-- 고용일자 기준 내림차순 정렬 >> 이름 기준 오름차순 정렬

SELECT dr_name
      ,dr_id
      ,mcdp_cd
      ,to_char(hire_ymd, 'YYYY-MM-DD') as HIRE_YMD
FROM  doctor
WHERE mcdp_cd = 'CS' 
or    mcdp_cd = 'GS'
ORDER BY hire_ymd desc, dr_name asc;