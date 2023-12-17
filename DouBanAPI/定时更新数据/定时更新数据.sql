SELECT
    movieid,
    COUNT(CASE WHEN isLike = 0 THEN 1 END) AS count_isLike_0,
    COUNT(CASE WHEN isLike = 1 THEN 1 END) AS count_isLike_1,
    COUNT(CASE WHEN isLike = 1 THEN 1 END) / COUNT(*) * 100 AS percentage_good_reviews
FROM
    comments
GROUP BY
    movieid;
		
		
UPDATE movies m
JOIN (
        SELECT
                movieid,
                COUNT( CASE WHEN isLike = 0 THEN 1 END ) AS count_isLike_0,
                COUNT( CASE WHEN isLike = 1 THEN 1 END ) AS count_isLike_1,
                COUNT( CASE WHEN isLike = 1 THEN 1 END ) / COUNT(*)  AS percentage_good_reviews 
        FROM
                comments 
        GROUP BY
                movieid 
        ) c ON m.id = c.movieid 
        SET m.goodCount = c.count_isLike_1,
        m.goodRate = c.percentage_good_reviews;