# Assoziierte Instanz

Dies ist der Microservice zur Verwaltung von Bezugspersonen und Hauptverantwortlichen
der dementiell veränderten Personen (DVP). 
Dieser Service verwaltet alle mit dem System arbeitenden Personen und soll 
in einer zukünftigen Version die Beziehungen zwischen diesen Personen und den
DVP verwalten, sowie alle damit verbundenen Rollen und Rechte. 
Weitere Informationen zu Details, wie der REST-API dem Eventing 
und dem allgemeinen Aufbau befinden sich im 
[Wiki](https://github.com/Archi-Lab/fae-team-2-assoziierte-instanz/wiki).

## Prerequisites

* [Maven](https://maven.apache.org/install.html)
* [Docker](https://www.docker.com/)

## Getting Started

Projekt bauen
```
mvn install -DskipTests=true
```

Docker Image bauen:
```
docker-compose build
```

Docker Container starten:
```
docker-compose up
```

Mehrere Docker Container starten:
```
docker-compose up --scale asi=2
```

Belegter Port: 8021

## Acknowledgements

* Der Eventing Code wurde von [REWE Digital](https://github.com/rewe-digital/integration-patterns) übernommen.
* Die EntityUUID4 Klasse wurde von [Team 1](https://github.com/Archi-Lab/fae-team-1) übernommen. 
* Das docker-compose File ist an das vom [sample-microservice](https://github.com/Archi-Lab/sample-microservice) angelehnt.
