# OPT3_Rent-a-Thing
OPT3 Standaard Casus (BEWARE OF BUGS)

**Standaard casus**

Als de casus die je voor REQS hebt uitgewerkt onvoldoende aanknopingspunten biedt om deze casus voor OPT3 te realiseren, kun je gebruik maken van de standaard casus. Let er daarbij op dat de eisen dan wel iets scherper gesteld zijn dan dat je zelf een casus in zou brengen.

**Inleiding**

Verhuurbedrijf 'Rent-a-Thing' wil een systeem bouwen waarin alle producten staan die te huur zijn en waarin wordt bijgehouden welke van die producten op voorraad (ofwel niet verhuurd) zijn. Het bedrijf verhuurt de meest uiteenlopende producten, maar verhuurt vrijwel geen producten die identiek zijn. Zo heeft het bedrijf bijvoorbeeld wel meerdere boormachines te huur, maar allemaal van een ander merk of type. 
Inloggen  

Meerdere medewerkers van het bedrijf moeten het systeem tegelijkertijd kunnen bedienen. Om de (uitwerking van deze) casus niet te ingewikkeld te maken doen we net alsof het praktisch is dat alle medewerkers op dezelfde computer werken. Daartoe bestaat het systeem uit een 'inlogvenster', waarin elke medewerker kan inloggen met een username en een wachtwoord. Na succesvol inloggen wordt een 'menuvenster' geopend voor die medewerker. Het inlogvenster blijft geopend (of wordt opnieuw geopend) zodat ook een volgende medewerker kan inloggen, enzovoort. 

**Het hoofdmenu**

Het menuvenster toont een menu met de volgende mogelijkheden: 

    'Overzicht', waarmee het 'overzichtvenster' wordt geopend,
    'Beheer', waarmee het 'beheervenster' worden geopend en
    'Uitloggen', waarmee het menuvenster wordt gesloten. 
    
**Overzicht**

Het overzichtvenster toont een scrollbare lijst met (een korte omschrijving van) alle producten die het bedrijf verhuurt, met een indicatie of het product op voorraard is. Als op een product wordt geklikt wordt een 'detail'-venster geopend. 
Detailvenster

In het detailvenster wordt alle bekende informatie over het product getoond. Daarnaast wordt getoond of het product is verhuurd. Als het product is verhuurd wordt getoond door welke medewerker en aan welke klant (een veld met voor- en achternaam). Ook wordt dan een knop 'Retour' getoond, waarmee de verhuur van het product kan worden beeindigd. Als het product op voorraad is wordt een checkbox 'Verzekeren?' getoond en afhankelijk van of deze is aangevinkt wordt de totale huurprijs per dag getoond, al dan niet inclusief een bedrag voor de verzekering. Ook worden dan een invulveld voor een klantnaam en een knop 'Verhuur' getoond, waarmee het product kan worden verhuurd. 

**Beheer**

In het beheervenster wordt een lijst getoond van alle (bekende) soorten producten (zie hieronder). Als op een soort product wordt geklikt opent een 'toevoegen' venster. 

In het toevoegenvenster kunnen gegevens over het product worden ingevuld en kan het product met een knop 'Toevoegen' worden toegevoegd aan het assortiment van het bedrijf. 
Het doorvoeren van wijzigingen in de data

Alle wijzigingen die plaatsvinden (het toevoegen van producten, het verhuren of retourneren van producten) zijn direct zichtbaar in alle openstaande schermen van alle medewerkers.   
Het bewerken van de data

Een medewerker kan slechts in één venster tegelijk werken, andere vensters zijn niet actief. (Behalve het inlogvenster. Een medewerker zou, terwijl hij of zij al is ingelogd, opnieuw kunnen proberen in te loggen. Zo'n poging kan nooit succesvol zijn.) 

Elk venster bevat de mogelijkheid om het venster te sluiten en zonder iets te wijzigen terug te keren naar het voorgaande venster. 

In elk venster wordt de username van de ingelogde medewerker getoond, zodat elke medewerker weet in welk venster hij of zij behoort te werken. 
Soorten producten

Er zijn minimaal de volgende soorten producten bekend in het systeem: 

    Personenauto's, waarvan een merk, een gewicht (in kg) en een motorinhoud (in cc) bekend zijn. De huurprijs is 50 euro per dag, de verzekering is 0,01 euro per cc motorinhoud per dag.
    Vrachtauto's, waarvan een laadvermogen (in kg) en een motorinhoud (in cc) bekend zijn. De huurprijs is 0,10 euro per kg laadvermogen per dag, de verzekering is 0.01 euro per cc motorinhoud per dag.
    Boormachines, waarvan een merk en een type bekend zijn. De huurprijs is 5 euro per dag, de verzekering is 1 euro per dag. 

Van elke soort zijn minstens 3 (zelf te verzinnen) producten 'hardcoded' (bij het opstarten van het programma) aanwezig in het systeem. 
Opdracht

Als je deze casus gebruikt voor de tweede en derde opdracht voor OPT3 wordt die uitwerking beoordeeld volgens de beschrijving van de opdracht van OPT3. Daarbij geldt echter één afwijking. De uitwerking wordt alleen goedgekeurd als in plaats van 2 patterns de volgende 3 patterns op een nuttige wijze zijn toegepast:

    Het Observer Pattern
    Het Abstract Factory Method Pattern
    Het Template Method Pattern.

