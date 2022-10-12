# pokemon CRUD (Create/Read/Update/Delete)
SpringBoot application with SpringData JPA to view/create/update/delete a pokemon.

### Get a pokemon by ID
```http
GET /pokemon/{id}
```
| Parameter | Type | Description |
| :---------| :-----| :----------- |
| `id`      | `string` | *** Required: A primary key ID of a pokemon from table "pokemon" |


<img width="904" alt="image" src="https://user-images.githubusercontent.com/66429881/195228672-982ecd61-3c0a-487a-84c0-d978fbfc346f.png">


### Get a pokemon collection (with page & size)
```http
GET /pokemon
```
| Parameter | Type | Description |
| :---------| :-----| :----------- |
| `page`      | `string` | *** Optional: Starting with page 1 |
| `size`      | `string` | *** Optional: Default is 20 |


<img width="978" alt="image" src="https://user-images.githubusercontent.com/66429881/195228813-788f7094-a383-4a38-8cb6-e1aa68839def.png">

### Create a new pokemon
```http
POST /pokemon
```
| Parameter | Type | Description |
| :---------| :-----| :----------- |
| `orderNumber`      | `number` |1|
| `name`      | `string` | Example: Bulbasaur|
| `type1`      |  `string` | Example: Grass |
| `type2`      | `string` | Example: Poison |
| `total`       | number | Example: 1
| `hp`        | number | |
| `attack`    | number | |
| `defense`   | number | |
| `spAttack`  | number | |
| `spDefense` | number | |
| `speed`     | number | |
| `generation` | number | |
| `legendary`   | number | |

<img width="1090" alt="image" src="https://user-images.githubusercontent.com/66429881/195229489-b74de7ff-16e7-464f-b8b8-abaaf9b43984.png">


### Update a pokemon
```http
PUT /pokemon/{id}
```
| Parameter | Type | Description |
| :---------| :-----| :----------- |
| `id`      | `number` | ***Required***|
| `orderNumber`      | `number` |1|
| `name`      | `string` | Example: Bulbasaur|
| `type1`      |  `string` | Example: Grass |
| `type2`      | `string` | Example: Poison |
| `total`       | number | Example: 1
| `hp`        | number | |
| `attack`    | number | |
| `defense`   | number | |
| `spAttack`  | number | |
| `spDefense` | number | |
| `speed`     | number | |
| `generation` | number | |
| `legendary`   | number | |

<img width="936" alt="image" src="https://user-images.githubusercontent.com/66429881/195229450-c7b33f10-82e5-452f-a6bb-2efe4b9ebf79.png">


### Partially update a pokemon
```http
PATCH /pokemon/{id}
```
| Parameter | Type | Description |
| :---------| :-----| :----------- |
| `id`      | number | ***Required****|
| `name`      | `string` | Example: Bulbasaur|
...

<img width="929" alt="image" src="https://user-images.githubusercontent.com/66429881/195229410-cd0a0053-639f-427a-b6ac-50dfad781b73.png">


### Delete a pokemon
```http
DELETE /pokemon/{id}
```
| Parameter | Type | Description |
| :---------| :-----| :----------- |
| `id`      | number | ***Required****|


<img width="1306" alt="image" src="https://user-images.githubusercontent.com/66429881/195229361-a9bba205-1d88-44dc-83d9-5944922d0959.png">
