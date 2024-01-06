.PHONY: clean
EXECUTABLES = jq docker docker-compose curl kubectl

mysql:
	docker run --name lecodedb --detach --rm -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=lecodedb mysql:latest --character-set-server=utf8mb4

