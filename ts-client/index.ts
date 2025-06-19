import axios from 'axios';

async function fetchData() {
  const res = await axios.get('https://jsonplaceholder.typicode.com/todos/1');
  console.log('TS Response:', res.data);
}

fetchData();
