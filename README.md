# webserv
serveur gommette

demarrer le serveur
./gradlew run

Fermer les anciens serveurs encore en marchent
ps aux | grep gradlew
kill -9 numDuProgramme

ajouter un nouvel user
curl -X POST "http://localhost:8081/users?firstname=a&lastname=b"

Pour faire la liste des eleves
curl -X GET "http://localhost:8081/eleves"

Pour supprimer un eleve
curl -X DELETE "http://localhost:8081/eleves?id=12"

alt -z : saute une ligne sur vscode
ctr maj bar  ou ctr k c : mettre tout en commentaire

# Ce qui nous reste a faire:

-supprimer élève/gommette en vérifiant qui toutes les élève/gommette soient associés dans eleveGom se supprime aussi(pas commencer)
-date de eleveGom(pas commencer) + afficher quand il y en a besoin//
-nettoyer code(en cours)
-css(en cours)
- proposer uniquement des utilisateur et gommettes existentes pour creation attribution gommettes
