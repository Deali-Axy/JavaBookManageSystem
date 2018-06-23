# Database
## User

|  field   | type | help_text | constraint  | length |
| -------- | ---- | --------- | ----------- | ------ |
| id       | int  |           | primary-key |        |
| name     | char |           |             | 20     |
| password | char |           |             | 200    |


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
| field | type | help_text |      constraint       | length |
| ----- | ---- | --------- | --------------------- | ------ |
| id    | int  |           | primary-key           |        |
| book  | int  |           | foregin-key to `Book` |        |
| user  | int  |           | foregin-key to `User` |        |