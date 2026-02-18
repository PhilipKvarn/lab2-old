# Vad vi kan göra

## Skapa en ovanliggande Game Klass ovanför CarController och view
Denna ska ha ett CarController cc och en CarView view eller frame
Då kan vi potentiellt ta bort dependecies från CarView <---> CarController.
Eftersom de beror på varandra.
Då följer vi också single responsibility bättre.
Logiken för kollision bör inte hanteras i CarController.
CarController är bara till för att skicka instruktioner till Veichles.
Så då borde CarController inte sköta saker som collision detection.

## Dependency Inversion Principle:
Det känns som att detta kan användas här men jag är inte säker hur.