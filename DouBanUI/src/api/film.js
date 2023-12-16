import axios from 'axios';

const service = axios.create({
  baseURL: 'http://localhost:8099', // api 的 base_url
  timeout: 5000, // 请求超时时间
});

/**
 * 获取电影数据
 * @param {*} data
 * @returns
 */
export function getMoviesByKeyword(data) {
   return service.get('movies/getMoviesByKeyword', { params: data });
}

/**
 * Get movies by movieId with pagination.
 * @param {number} movieId - The ID of the movie.
 * @param {number} pageIndex - The index of the page.
 * @param {number} pageSize - The number of items per page.
 * @returns {Promise} A Promise that resolves with the response data.
 */
export function getMoviesByMovieId(movieId, pageIndex, pageSize) {
  const url = 'movies/findByMovieId';
  const params = {
    movieId: movieId,
    pageIndex: pageIndex,
    pageSize: pageSize
  };

  return service.get(url, { params: params })
    .then(response => response.data)
    .catch(error => {
      // Handle error
      console.error('Error fetching movies:', error);
      throw error; // You may want to handle or log the error differently
    });
}



/**
 * Get movie details by ID.
 * @param {number} id - The ID of the movie.
 * @returns {Promise} A Promise that resolves with the response data.
 */
export function getMovieDetailById(id) {
  const url = `movies/detail?id=${id}`;

  return service.get(url)
    .then(response => response.data)
    .catch(error => {
      // Handle error
      console.error('Error fetching movie details:', error);
      throw error; // You may want to handle or log the error differently
    });
}