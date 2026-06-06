# Étape 1 — Image de base (FROM)
# Équivalent TP1 : docker run -it ubuntu:22.04 bash
FROM  ubuntu:22.04

RUN apt-get update && apt-get install -y curl zip unzip && \
    curl -s https://get.sdkman.io | bash && \
    bash -c 'source /root/.sdkman/bin/sdkman-init.sh && \
             sdk install java 25-open'

# Étape 3 — Déclarer le port (EXPOSE)
EXPOSE 8081

# Étape 4 — Copier le JAR dans l'image (COPY)
COPY target/master2-0.0.1-SNAPSHOT.jar /app.jar

# Étape 5 — Commande de démarrage de l'application
ENTRYPOINT ["bash", "-c", \
  "source /root/.sdkman/bin/sdkman-init.sh && \
   java -jar /app.jar \
   --spring.datasource.url=jdbc:postgresql://db:5432/master2 \
   --spring.datasource.username=postgres \
   --spring.datasource.password=passer \
   --spring.jpa.hibernate.ddl-auto=update"]
