drop  view  goodCount_view ;
create view  goodCount_view as 
SELECT *, likeCount / totalCount as goodRate from (
SELECT
	m.id,
	COUNT( c.movieid ) AS totalCount,
	SUM( CASE WHEN c.isLike = 1 THEN 1 ELSE 0 END ) AS likeCount 
FROM
	movies m
	LEFT JOIN comments c ON m.id = c.movieid 
GROUP BY
	m.id
) as tb;


SELECT * from goodCount_view


UPDATE movies m
JOIN goodCount_view gcv ON m.id = gcv.id
SET m.goodCount = gcv.likeCount,
    m.goodRate = gcv.goodRate;

	

drop view top_movies_view5 ;

CREATE VIEW top_movies_view5 AS

(
    SELECT
        m.id,m.name,m.year,m.img,m.goodCount, m.goodRate
    FROM
        movies m
    WHERE
        m.`year` = 2015 
    GROUP BY
        m.id
    ORDER BY
        goodCount DESC
    LIMIT
        5
)
UNION
(
   
    SELECT
        m.id,m.name,m.year,m.img,m.goodCount, m.goodRate
    FROM
        movies m
    WHERE
        m.`year` = 2016
    GROUP BY
        m.id
    ORDER BY
        goodCount DESC
    LIMIT
        5
)
UNION
(
  
    SELECT
        m.id,m.name,m.year,m.img,m.goodCount, m.goodRate
    FROM
        movies m
    WHERE
        m.`year` = 2017
    GROUP BY
        m.id
    ORDER BY
        goodCount DESC
    LIMIT
        5
)
UNION
(
 
    
    SELECT
        m.id,m.name,m.year,m.img,m.goodCount, m.goodRate
    FROM
        movies m
    WHERE
        m.`year` = 2018
    GROUP BY
        m.id
    ORDER BY
        goodCount DESC
    LIMIT
        5
)
UNION
(
   
    SELECT
        m.id,m.name,m.year,m.img,m.goodCount, m.goodRate
    FROM
        movies m
    WHERE
        m.`year` = 2019
    GROUP BY
        m.id
    ORDER BY
        goodCount DESC
    LIMIT
        5
)


select * from top_movies_view5  
 
drop view  top_movies_view_good ;
CREATE view  top_movies_view_good  as

	SELECT
			m.id,m.name,m.year,m.img,m.goodCount, m.goodRate
	FROM
			movies m
	GROUP BY
			m.id
	ORDER BY
			goodCount DESC
	LIMIT
			10
				
SELECT * from top_movies_view_good				
				
				
##	前10的數據			
SELECT * from (
	select movieId ,count(1) as cnt from  comments where isLike=1 GROUP BY movieId
) as tb ORDER BY tb.cnt desc limit 10		
									
# 驗證2015的數據								
SELECT * from (
	select movieId ,count(1) as cnt from  comments where isLike=1 
	and  movieId in (SELECT id from  movies where year =2015)
	GROUP BY movieId
) as tb ORDER BY tb.cnt desc limit 5
select * from top_movies_view5 where year =2015 order by goodCount desc
									
										
	