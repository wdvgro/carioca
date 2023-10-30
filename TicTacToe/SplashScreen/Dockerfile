# Gebruik een basisimage, bijvoorbeeld OpenJDK
FROM openjdk:11-jre-slim

# Voeg het gamerserver.jar-bestand toe aan de container
COPY newgameserver-1.0.jar /app/newgameserver-1.0.jar

# Stel de werkdirectory in voor de container
WORKDIR /app

# Het commando dat wordt uitgevoerd wanneer de container wordt gestart
CMD ["java", "-jar", "newgameserver-1.0.jar"]

