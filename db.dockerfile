FROM mysql:5.7

ENV MYSQL_ROOT_PASSWORD=root
# ENV MYSQL_DATABASE=my_database

# Copier les fichiers de configuration
COPY ./db/script.sql /docker-entrypoint-initdb.d/
