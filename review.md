# PlayerSet
* preferer un list.of pour initialiser la list plutot que X add
* preferer l'api stream pour lever l'exception plutot que le if else
* ajouter countDiceByValue. a terme on doit pouvoir tout rapatrier dans l'objet et supprimer les getter

# pom & test 
* suppression junit 4 
* uniformisation configuration 
* migre test to junit 5
* simplifie le test de cohérence sur la valeur des dés. 
* deplace ce test dans PlayerSetTest. on devrait tester unitairement le reste de cet objet 

# Supression de l'abstract 
* countDiceByValue porté par le playerSet

# PlayerContext
* suppression code inutilisé
* formatage

# Clean toutes classe

# PlayerSet 
* deplace certaines methodes de calcul dans l'objet qui peut porter cette responsabilité

# Factorisation des X of a kind en une strategie
