# Database
## User
|  field   |  type   | help_text | constraint  | length |
| -------- | ------- | --------- | ----------- | ------ |
| id       | int     |           | primary-key |        |
| name     | char    |           |             | 20     |
| password | char    |           |             | 200    |
| admin    | boolean |           |             |        |


## Book
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