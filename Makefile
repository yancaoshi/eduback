.PHONY: clean
EXECUTABLES = jq docker docker-compose curl kubectl

mysql:
	docker run --name lecodedb --detach -p 3306:3306 -v $(shell pwd)/db/:/docker-entrypoint-initdb.d/ -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=lecodedb mysql:latest --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

docker:
	docker build -t eduback:latest --no-cache -f $(shell pwd)/Dockerfile .

