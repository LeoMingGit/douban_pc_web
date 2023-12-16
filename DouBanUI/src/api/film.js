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
