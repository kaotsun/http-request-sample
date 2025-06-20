import mysql from 'mysql2/promise';
import dotenv from 'dotenv';
dotenv.config();

async function main() {
  const conn = await mysql.createConnection({
    host: process.env.DB_HOST,
    port: Number(process.env.DB_PORT),
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME
  });

  const [rows] = await conn.execute('SELECT * FROM users');
  console.log('Before update:', rows);

  await conn.execute('UPDATE users SET age = age + 1 WHERE name = ?', ['Taro']);

  const [updatedRows] = await conn.execute('SELECT * FROM users');
  console.log('After update:', updatedRows);

  await conn.end();
}

main().catch(console.error);

