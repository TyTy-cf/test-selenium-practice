# TP GOG.com - Architecture POM


## Contexte


Vous allez automatiser la navigation sur https://www.gog.com/fr/, une plateforme de jeux vidéo, en utilisant l'architecture Page Object Model.


###  Partie 1 : Préparation des bases de l'architecture POM


Commencez par créer un package `gog`, vous travaillerez uniquement dans ce package


#### Exercice 1.1 : Créer `BasePage.java`


- **Consigne** : Créer une classe `BasePage` dans le package `pages`
- **Rôle** : Classe parente qui contient les méthodes utilitaires réutilisables par toutes les pages

| Méthode                  | Rôle                                     | Retour     |
|--------------------------|------------------------------------------| ---------- |
| `BasePage(WebDriver driver)` | Constructeur qui reçoit le driver        | -          |
| `waitUntil(By locator)`  | Attend qu'un élément soit visible        | WebElement |
| `waitClick(By locator)`  | Clique sur un élément                    | void       |
| `type(By locator, String text)` | Tape du texte dans un champ              | void       |
| `getText(By locator)`     | Récupère le contenu textuel d'un élément | String     |

- Attributs de la classe :
  - `protected WebDriver driver`
  - `protected WebDriverWait wait`


#### Exercice 1.2 : Créer `BaseTest.java`


- **Consigne** : Créer une classe `BaseTest` dans le package `tests`
- **Rôle** : Classe parente pour les tests

| Méthode   | Annotation  | Rôle                                   |
|-----------| ----------- | -------------------------------------- |
| `setUp()` | `@BeforeEach` | Initialise le driver avant chaque test |
| `down()`  | `@AfterEach`  | Ferme le driver après chaque test      |


###  Partie 2 : Créer les Pages Objects


#### Exercice 2.1 : Créer `HomePage.java`


- **Consigne** : Créer une classe `HomePage` dans le package `pages`, elle va hériter de `BasePage`
- **Rôle** : Représente la page d'accueil de GOG.com

Elle possède l'attribut `private final By searchInput = `, vous devez définir le bon locator à utiliser


| Méthode                    | Paramètres       | Rôle                                                               | Retour            |
| -------------------------- | ---------------- | ------------------------------------------------------------------ | ----------------- |
| `HomePage(WebDriver driver)` | WebDriver driver | Constructeur qui appelle super(driver)                             | -                 |
| `open()`                     | -                | Ouvre https://www.gog.com/fr/                                      | `HomePage`          |
| `searchGame(String gameName)` | String gameName  | Tape le nom du jeu dans la barre de recherche et appuie sur ENTRÉE | `SearchResultsPage` |


> Détails importants :
> - `open()` doit retourner `this` pour permettre le chaînage
> - `searchGame()` doit retourner `new SearchResultsPage(driver)`


#### Exercice 2.2 : Créer `SearchResultsPage.java`


- **Consigne** : Créer une classe `SearchResultsPage` dans le package `pages`, elle va hériter de `BasePage`
- **Rôle** : Représente la page des résultats de recherche


| Méthode                              | Paramètres       | Rôle                                         | Retour  |
|--------------------------------------| ---------------- | -------------------------------------------- | ------- |
| `SearchResultsPage(WebDriver driver)` | WebDriver driver | Constructeur qui appelle super(driver)       | -       |
| `isDisplayed()`                       | -                | Vérifie qu'on est bien sur la page résultats | boolean |
| `getCurrentUrl()`                     | -                | Retourne l'URL actuelle de la page           | String  |


###  Partie 3 : Écrire les tests


#### Exercice 3.1 : Créer `HomeTest`


- **Consigne** : Créer une classe `HomeTest` dans le package `tests`, elle va hériter de `BaseTest`
- **Rôle** : Contient les tests nécessaires à l'affiche de la page d'acceuil


#### Exercice 3.2 : Test vérification page d'accueil


- **Consigne** : Créer un test `testHomePageIsDisplayed()` dans `HomeTest`

Ce que doit faire le test :
- Ouvrir la page d'accueil de GOG
- Vérifier que la page s'affiche correctement (`isDisplayed`)
- Vérifier l'existance d'un lien pour revenir à la page d'accueil


#### Exercice 3.3 : Créer `SearchTest.java`


- **Consigne** : Créer une classe `SearchTest` dans le package `tests`, elle va hériter de `BaseTest`
- **Rôle** : Contient les tests de recherche sur GOG.com


#### Exercice 3.4 : Test recherche "Cyberpunk"


- **Consigne** : Créer un test `testSearchCyberpunk` dans la classe `SearchTest`

Ce que doit faire le test :
- Créer une instance de `HomePage` en lui passant `driver`
- Appeler `open()` puis `searchGame("Cyberpunk")`
- Vérifier que l'URL contient "Cyberpunk"


#### Exercice 3.5 : Test recherche "Binding"


- **Consigne** : Créer un test `testSearchBindingOf` dans la classe `SearchTest`

Ce que doit faire le test :
- Rechercher "Binding of" sur GOG
- Appeler `open()` puis `searchGame("Binding of")`
- Vérifier que `isDisplayed()` retourne `true`


###  Partie 4 : Améliorer les Page Objects


#### Exercice 4.1 : Ajouter une méthode dans `SearchResultsPage`


- **Consigne** : Ajouter une méthode `getFirstGameTitle()` dans `SearchResultsPage`
- **Rôle** : Retourne le titre du premier jeu dans les résultats

Il faut prévoir l'ajout de :
- Un attribut supplémentaire
- Une méthode supplémentaire


#### Exercice 4.2 : Test avec vérification du titre


- **Consigne** : Créer un test `testFirstResultContainsWitcher()`

Ce que doit faire le test :
- Rechercher "Witcher"
- Vérifier que le titre du premier résultat contient "Witcher"


#### Exercice 4.3 : Ajouter une méthode dans `HomePage`


- **Consigne** : Ajouter une méthode `changeLanguage(String locale)` dans `HomePage`

Ce que doit faire la méthode :
- Ouvrir https://www.gog.com/{locale}/
- Retourner `this`


###  Partie 5 : Améliorer la `HomeTest`


#### Exercice 5.1 : Tester le slider (carousel)


- **Consigne** : Créer un test `testSliderLeft()` dans `HomeTest`

Ce que doit faire le test :
- Chercher le bouton permettant de faire défiler le slider vers la gauche, cliquer dessus
- Vérifier ensuite le "swiper" (balise HTML) a bien changé son élément "actif" (classe `swiper-pagination-bullet-active`)

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `HomePage`


#### Exercice 5.2 : Aller sur la page d'un jeu


- **Consigne** : Créer un test `testGoToGamePage()` dans `HomeTest`

Ce que doit faire le test :
- Chercher le premier jeu du premier "swiper" (Nom : `a_plague_tale_requiem`) et cliquer dessus pour aller sur la page de détail de celui-ci

- Astuces :
  - il faudra créer une classe `GamePage`
  - il faudra ajouter des attributs / fonctions dans la classe `HomePage`


#### Exercice 5.3 : Améliorer la `SearchTest`


- **Consigne** : Créer un test `testFilterGoodOldGames`

Ce que doit faire le test :
- Chercher la checkbox de "GOOD OLD GAMES", cliquer dessus
- Vérifier l'affiche du filtre "Good old games"

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `SearchResultsPage`


#### Exercice 5.4 : Améliorer la `SearchResultsPage`


- **Consigne** : Créer un test `testRemoveFilter`

Ce que doit faire le test :
- Chercher le filtre "Supprimer les filtres" et cliquer dessus
- Vérifier que la page soit bien "réinitialisée" (à votre guise pour l'idée)

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `SearchResultsPage`


#### Exercice 5.5 : Améliorer la `HomePage`


- **Consigne** : Créer une fonction `goToGame`

Ce que doit faire la fonction :
- Elle prend en paramètre un `String` correspondant au nom du jeu à rechercher
- Elle doit faire le même comportement que la fonction `searchGame`, sauf qu'elle n'appuie pas sur `ENTER`
- Elle doit attendre que le dropdown de recherche apparaisse et clique sur le premier jeu du dropdown
- Elle renvoie un objet de type `GamePage`

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `HomePage`


#### Exercice 5.6 : Améliorer la `HomeTest`


- **Consigne** : Créer une fonction `testGoToGame`

Ce que doit faire la fonction :
- Tester le comportement de la fonction `goToGame` de la `HomePage`
- Vérifier que l'on arrive bien sur la page du jeu (via l'URL)
- Tester votre fonction avec le jeu "Theme Hospital"


#### Exercice 5.7 : Améliorer la `GamePage`


- **Consigne** : Créer une fonction `addGameToCart`

Ce que doit faire la fonction :
- Elle reprend le comportement de la fonction `goToGame` pour aller sur la page d'un jeu
- Elle clique sur le bouton "Ajouter au panier"


#### Exercice 5.8 : Créer la classe `GameTest`


- **Consigne** : Créer une fonction `testAddGameToCart`

Ce que doit faire la fonction :
- Elle reprend le comportement de la fonction `addGameToCart` de la `GamePage` pour ajouter un jeu au panier
- Elle doit vérifier que le jeu s'est correctement ajouté


###  Partie 6 : Nouvelle page


#### Exercice 6.1 : Créer la classe `WorkPage`


- **Consigne** : Créer une fonction `goToJobOfferInput`

Ce que doit faire la fonction :
- Aller sur la page des offres d'emplois, puis scroller jusqu'à la barre de recherche des offres d'emploi


#### Exercice 6.2 : Améliorer la classe `WorkPage`


- **Consigne** : Créer une fonction `searchForJobOffer`

Ce que doit faire la fonction :
- Avoir un paramètre de type String, de nom "job"
- Reprendre le comportement de la fonction `goToJobOfferInput`
- Ecrire le paramètre "job" dans la barre de recherche


#### Exercice 6.3 : Améliorer la classe `HomePage`


- **Consigne** : Créer une fonction `goToJobOfferPage`

Ce que doit faire la fonction :
- Cliquer sur le dropdown "À propos"
- Puis cliquer "Rejoindre notre équipe"
- La fonction doit retourner un objet de type `WorkPage`


#### Exercice 6.4 : Améliorer la classe `HomeTest`


- **Consigne** : Créer une fonction `testGoToJobOfferPage`

Ce que doit faire la fonction :
- Tester si l'on peut bien accéder à la base `WorkPage`


#### Exercice 6.5 : Créer la classe `WorkTest`


- **Consigne** : Créer une fonction `testSearchForJobOffer`

Ce que doit faire la fonction :
- Tester si l'on peut bien accéder à l'input de recherche d'offre d'emploi et saisir "backend" dedans
- Il faudra modifier `WorkPage` pour cet exercice


###  Partie 7 : Tests de navigation dans le menu boutique


#### Exercice 7.1 : Améliorer `HomePage.java`


- **Consigne** : Ajouter des méthodes pour naviguer dans le menu Boutique


| Méthode            | Paramètres | Rôle                                   | Retour        |
| ------------------ | ---------- | -------------------------------------- | ------------- |
| `openShopDropdown()` | -          | Ouvre le dropdown "BOUTIQUE"           | `HomePage`      |
| `goToOpenWorld()`    | -          | Clique sur "Monde ouvert" dans le menu | `OpenWorldPage` |
| `goToStrategy()`     | -          | Clique sur "Stratégie" dans le menu    | `StrategyPage`  |


- Attributs de la classe :
  - `private final By shopDropdown` : pour localiser le menu "BOUTIQUE"
  - `private final By openWorldLink` : pour localiser le lien "Monde ouvert"
  - `private final By strategyLink` : pour localiser le lien "Stratégie"


#### Exercice 7.2 : Créer `OpenWorldPage.java`


- **Consigne** : Créer une classe `OpenWorldPage` dans le package pages, elle va hériter de `BasePage`
- **Rôle** : Représente la page des jeux "Monde ouvert"


| Méthode                   | Paramètres       | Rôle                                            | Retour  |
| ------------------------- | ---------------- | ----------------------------------------------- | ------- |
| `OpenWorldPage(WebDriver driver)` | WebDriver driver | Constructeur qui appelle super(driver)          | -       |
| `isDisplayed()`            | -                | Vérifie qu'on est bien sur la page Monde ouvert | boolean |
| `getPageTitle()`           | -                | Retourne le titre de la page                    | String  |
| `getFirstGameTitle()`      | -                | Retourne le titre du premier jeu affiché        | String  |
| `getGamesCount()`          | -                | Retourne le nombre de jeux affichés sur la page | int     |


Attributs nécessaires :
- `private final By pageTitle` : pour localiser le titre de la page
- `private final By firstGame` : pour localiser le premier jeu
- `private final By gamesList` : pour compter les jeux affichés


#### Exercice 7.3 : Créer `BoutiqueTest.java`


- **Consigne** : Créer une classe `BoutiqueTest` dans le package tests, elle va hériter de `BaseTest`
- **Rôle** : Contient les tests de navigation du menu Boutique
- **Allure** : La classe sera annotée par `@Feature` avec le texte "Navigation menu boutique"
- Tous les tests que vous ajouterez à cette classe seront annotés par `@Story`, `@Description` et `@Severity` (sauf si préciser, on utilisera SeverityLevel.NORMAL)


#### Exercice 7.4 : Test navigation vers Monde ouvert


- **Consigne** : Créer un test `testGoToOpenWorld()` dans `BoutiqueTest`
- **Severity** : `SeverityLevel.CRITICAL`


Ce que doit faire le test :
- Ouvrir la page d'accueil
- Ouvrir le dropdown "BOUTIQUE"
- Cliquer sur "Monde ouvert"
- Vérifier que la page "Monde ouvert" s'affiche correctement (isDisplayed())
- Vérifier que l'URL contient "open-world"


#### Exercice 7.5 : Test affichage des jeux Monde ouvert


- **Consigne** : Créer un test `testOpenWorldGamesDisplay()` dans `BoutiqueTest`


Ce que doit faire le test :
- Naviguer vers la page "Monde ouvert"
- Vérifier qu'au moins 10 jeux sont affichés
- Vérifier que le premier jeu a un titre non vide


###  Partie 8 : Tests de la page Stratégie


#### Exercice 8.1 : Créer `StrategyPage.java`


- **Consigne** :Créer une classe `StrategyPage` dans le package `pages`, elle va hériter de `BasePage`
- **Rôle** : Représente la page des jeux de stratégie avec pagination par époque


| Méthode                           | Paramètres       | Rôle                                         | Retour       |
| --------------------------------- | ---------------- | -------------------------------------------- | ------------ |
| `StrategyPage(WebDriver driver)`    | WebDriver driver | Constructeur qui appelle super(driver)       | -            |
| `isDisplayed()`                     | -                | Vérifie qu'on est bien sur la page Stratégie | boolean      |
| `selectEpoch(String epoch)`         | String epoch     | Sélectionne une époque spécifique            | StrategyPage |
| `isEpochFilterActive(String epoch)` | String epoch     | Vérifie qu'un filtre d'époque est actif      | boolean      |
| `getActiveFilters()`                | -                | Retourne la liste des filtres actifs         | List<String> |
| `getFirstGameTitle()`               | -                | Retourne le titre du premier jeu             | String       |
| `clickNextPage()`                   | -                | Clique sur la page suivante de pagination    | StrategyPage |
| `clickPreviousPage()`               | -                | Clique sur la page précédente                | StrategyPage |
| `getCurrentPageNumber()`            | -                | Retourne le numéro de la page actuelle       | int          |
| `getTotalPages()`                   | -                | Retourne le nombre total de pages            | int          |


Attributs nécessaires :
- `private final By epochFilters` : pour localiser les filtres d'époque
- `private final By activeFilters` : pour vérifier les filtres actifs
- `private final By firstGame` : pour localiser le premier jeu
- `private final By nextPageButton` : pour la pagination suivante
- `private final By previousPageButton` : pour la pagination précédente
- `private final By currentPageIndicator` : pour identifier la page actuelle
- `private final By paginationInfo` : pour obtenir les infos de pagination


#### Exercice 8.2 : Test navigation vers Stratégie


- **Consigne** : Créer un test `testGoToStrategy()` dans `BoutiqueTest`
- **Severity** : `SeverityLevel.CRITICAL`


Ce que doit faire le test :
- Ouvrir la page d'accueil
- Ouvrir le dropdown "BOUTIQUE"
- Cliquer sur "Stratégie"
- Vérifier que la page "Stratégie" s'affiche correctement
- Vérifier que l'URL contient "strategy"


###  Partie 9 : Tests de pagination par époque


#### Exercice 9.1 : Test filtrage par époque "2010"


- **Consigne** : Créer un test `testFilterBy2010Epoch()` dans `BoutiqueTest`


Ce que doit faire le test :
- Naviguer vers la page "Stratégie"
- Sélectionner l'époque "2010"
- Vérifier que le filtre est actif
- Vérifier qu'au moins un jeu s'affiche
- Récupérer le titre du premier jeu et vérifier qu'il n'est pas vide


#### Exercice 9.2 : Test filtrage par époque "90"


- **Consigne** : Créer un test `testFilterBy90Epoch()` dans `BoutiqueTest`


Ce que doit faire le test :
- Naviguer vers la page "Stratégie"
- Sélectionner l'époque "90"
- Vérifier que le filtre est actif
- Vérifier qu'au moins un jeu s'affiche


#### Exercice 9.3 : Test filtrage par époque "90"


- **Consigne** : Créer un test `testScrollToDisplayGames()` dans `BoutiqueTest`


Ce que doit faire le test :
- Naviguer vers la page "Stratégie" 
- Sélectionner l'époque "90"
- Vérifier que le filtre est actif
- Scroller jusqu'au titre "Affichage de XXXX jeux" (2820 au moment de la rédaction du TP)


#### Exercice 9.4 : Test "Tags susceptibles de vous intéresser"


- **Consigne** : Créer un test `testScrollToLikableTags()` dans `BoutiqueTest`


Ce que doit faire le test :
- Naviguer vers la page "Stratégie"
- Scroller jusqu'au titre "Tags susceptibles de vous intéresser"
- Vérifier la présence de 5 éléments


#### Exercice 9.5 : Test changement de filtrage par époque


- **Consigne** : Créer un test `testChangeFilterByEpoch()` dans `BoutiqueTest`


Ce que doit faire le test :
- Naviguer vers la page "Stratégie"
- Sélectionner l'époque "90"
- Vérifier que le filtre est actif
- Sélectionner l'époque "2010"
- Vérifier que le filtre est actif et que le filtre "90" n'est plus actif






 

























