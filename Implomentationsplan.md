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

# Refactoring Idéer:

* Trimmed och Turbo borde vara Interfaces, just Nu kan vi inte ha t.ex en turbo-trim-Car eller turbo-trim-Truck

* Veichle transport har all logik som veichle loader borde ha. Som att bara lasta när man är nära.

* Om vi gör detta kan vi ta bort mer logik från CarController.

* Just nu är CarController och CarView beroende av varandra. Vi vill ha en Main/Game klass som har CarController och CarView så det blir Game --> CarView --> CarController.

* Borde se över TimerListener och om den ska flyttas till sin egen klass.

* Gör turbo till en Wrapperklass altså att Trimmed<T extends Veichle> så kan vi kalla veichle.speedfactor*trim() 


# Refactoringplan

## STEG 1:
* Gör main metoden i CarController till en egen klass (Typ Game).
* flytta över de sakerna som krävs i main metoden till Game klassen.
* skapa en CarView och en CarController i klassen.

## STEG 2
* Se till att vi flyttar logik från CarController till Game.

## STEG 3:
* TimerListener ska till sin egen klass.

## STEG 4:
* Game ska ha en Timer i sig som använder TimerListener.
* När vi startar game kan vi välja delay.

# STEG 5:
* VeichleLoader borde vara klassen som hanterar hur långt bort man får lasta
* Just nu är det VeichleTransport.

# STEG 6:
* Skriv om IncrementSpeed() och decrementSpeed() i veichle. har onödig logik.

# STEG 7:
* Se över hur truck påverkas av när man klickar för att höja/sänka flaket i interface.

## STEG KANSKE:
* Gör om TrimmedCar och TurboCar till egna interfaces eller wrappers
* Då kan vi ha t.ex TrimmedTurboTruck med samma funktionalitet