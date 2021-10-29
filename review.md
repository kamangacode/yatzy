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

# suppression de la factory
* utilisation de la map pour determiner la category
* suppression des optional => fail fast : si category inconnu jete erreur
* fix acceptance test : nom des categories suites incorrect.

# Factorisation des X of a kind en une strategie

# strategy
* Utilise intStream 

# PlayerSet
* suppression du getter !!

# TODO - NEXT 
* Test de toutes les nouvelles classes, methodes créés ou déplacées...
* Une partie de l'algo du full, 2 pair et XOfAKind doit etre factorisable. tjrs le meme pattern stream.filter.xx.orElese
* getCountDiceByValue doit pourvoir etre supprimer si on pousse encore

