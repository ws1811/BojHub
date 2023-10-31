-- 코드를 입력하세요
SELECT  f.flavor
FROM    first_half  f
       ,icecream_info i
WHERE   f.flavor = i.flavor
and     f.total_order > 3000
and     i.INGREDIENT_TYPE = 'fruit_based'
ORDER BY f.total_order desc;
      