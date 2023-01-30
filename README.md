## PROJEKTNI ZADATAK

Projektni zadatak je automatsko testiranje Web aplikacije (Frontend- UI) sa Selenium WebDriver kao web framework koji omogućava izvršavanje automatskih testova. 

Pri izvođenju ovog zadatka korišteni su Java development Kit, integrirano razvojno okruženje IntelliJ, te Chrome, Firefox i Edge driver.

Stranica na kojoj se provode testovi je web shop https://proton-vrecice.hr/ .

Napravljena je klasa ProtonTest koja unutar sebe sadrži 6 testova.

1. test loginPretplataTest provjerava logiranje korisnika, te korisnika pretplaćuje na newsletter
2. test kirbySearchTest provjerava searchbox
3. test checkoutTest provjerava dodavanje artikla u košaricu i izvršavanje kupnje
4. test addAndRemoveFromCartTest provjerava dodavanje veće količine artikla, te brisanje istog artikla iz košarice
5. test detailOfProduct provjerava kategoriju proizvoda, te pronalazi određeni proizvod, te zatim i njegov opis
6. test filterProducts provjerava searchbox, te zadane artikle sortira prema cijeni 
