# Dementiell Veränderte Person

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

## Acknowledgements

* Der Eventing Code wurde von [REWE Digital](https://github.com/rewe-digital/integration-patterns) übernommen.
