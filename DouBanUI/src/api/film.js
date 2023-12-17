import axios from 'axios';

const service = axios.create({
  baseURL: 'http://localhost:8099', // api 的 base_url
  timeout: 500000, // 请求超时时间
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
 */
export function getCommentsByMovieId(data) {
  const url = 'movies/getCommentsByMovieId';
  return service.get(url, { params: data });
}


/**
 * Get movie details by ID.
 * @param {number} id - The ID of the movie.
 * @returns {Promise} A Promise that resolves with the response data.
 */
export function getMovieDetailById(id) {
  const url = `movies/detail?id=${id}`;
  return service.get(url);
}

/**
 * 获取Top电影数据
 */
export function getTop() {
  return service.get('movies/top');
}
