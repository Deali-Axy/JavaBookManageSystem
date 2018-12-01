# JavaBookManageSystem

## 介绍
使用Java编写的简易图书管理软件，Java课程的课设之一。

## 依赖
- `Mybatis 3.4.6`
- `QFramework4J`: [About QFramework](https://github.com/Deali-Axy/QFramework4J)
- `Sqlite-Jdbc 3.23.1`
- `SwingSets3`


## 数据库设计
### User
|  field   |  type   | help_text | constraint  | length |
| -------- | ------- | --------- | ----------- | ------ |
| id       | int     |           | primary-key |        |
| name     | char    |           |             | 20     |
| password | char    |           |             | 200    |
| admin    | boolean |           |             |        |

### Book
|      field       |   type   | help_text | constraint  | length |
| ---------------- | -------- | --------- | ----------- | ------ |
| id               | int      |           | primary-key |        |
| name             | char     |           |             | 200    |
| author           | char     |           |             | 200    |
| publisher        | char     |           |             | 200    |
| publication_date | datetime |           |             |        |
| pages            | int      |           |             |        |
| ISBN             | char     |           |             | 20     |

## Borrowing
|  field  | type | help_text |      constraint       | length |
| ------- | ---- | --------- | --------------------- | ------ |
| id      | int  |           | primary-key           |        |
| book_id | int  |           | foregin-key to `Book` |        |
| user_id | int  |           | foregin-key to `User` |        |
| date    | date |           |                       |        |