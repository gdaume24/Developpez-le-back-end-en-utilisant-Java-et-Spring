# Utiliser l'image officielle Node.js comme base
FROM node:18-alpine

# Définir le répertoire de travail
WORKDIR /app

# Installer Mockoon CLI globalement
RUN npm install -g @mockoon/cli

# Copier les fichiers d'environnement Mockoon dans le conteneur
# Supposons que vos environnements sont dans le dossier 'environments'
COPY Front\ressources\mockoon\rental-oc.json /app/environments/rental-oc.json

# Exposer le port utilisé par Mockoon (par défaut 3000)
EXPOSE 3000

# Définir la commande par défaut pour exécuter Mockoon
# Remplacez 'your-environment.json' par le nom de votre fichier d'environnement
CMD ["mockoon-cli", "start", "--data", "/app/environments/rental-oc.json", "--port", "3000"]
