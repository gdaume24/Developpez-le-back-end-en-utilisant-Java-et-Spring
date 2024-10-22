#!/bin/bash

# Nom de votre service
SERVICE_NAME="db"  # Remplacez par le nom de votre service dans docker-compose.yml

# Supprimer le conteneur
echo "Suppression du conteneur..."
docker-compose down $SERVICE_NAME

# Supprimer le volume
echo "Suppression des volumes..."
docker volume rm db_data

# Rebuild de l'image
echo "Reconstruction de l'image..."
docker-compose up -d --build $SERVICE_NAME

winpty docker exec -it db bash

mysql -p

root

use my_database;

show tables;
