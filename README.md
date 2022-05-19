# DB docker command

docker run --name planet -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=planet-db -d postgres

Postman collection is inside root dir: Planet.postman_collection