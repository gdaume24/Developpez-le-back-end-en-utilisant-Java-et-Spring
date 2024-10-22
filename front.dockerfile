FROM node:20.15.0-alpine

# Définir le répertoire de travail
WORKDIR /Front

# Copier les fichiers de configuration
COPY ./Front .

# Exposer le port de l’application
EXPOSE 4200

# Commande pour démarrer l'application avec rechargement à chaud
CMD sh -c "npm install && node_modules/.bin/ng serve --host 0.0.0.0 --port 4200"

# Commande pour garder le container actif
# CMD tail -f /dev/null
