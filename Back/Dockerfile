FROM openjdk:17-jdk-alpine

# Installer Maven (si nécessaire)
RUN apk add --no-cache maven

# Copier les fichiers de configuration
COPY . ./app

# Définir le répertoire de travail
WORKDIR /app

# Exposer le port de l’application
EXPOSE 8000

# Commande pour démarrer l'application avec rechargement à chaud
CMD ["mvn", "spring-boot:run"]