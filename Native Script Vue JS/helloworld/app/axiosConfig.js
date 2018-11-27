import axios from "axios/index";


let client = axios.create(
  {

    baseURL: 'https://www.receitaws.com.br/v1/cnpj', //Server
    timeout: 1000 * 30 , // 30 seg
  });

export default client;