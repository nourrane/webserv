# serveur gommette

demarrer le serveur
```bash
./gradlew run
```

Fermer les anciens serveurs encore en marche
```bash
ps aux | grep gradlew
kill -9 numDuProgramme
```

ajouter un nouvel user :
`curl -X POST "http://localhost:8081/users?firstname=a&lastname=b"`

Pour faire la liste des eleves :
`curl -X GET "http://localhost:8081/eleves"`

Pour supprimer un eleve :
`curl -X DELETE "http://localhost:8081/eleves?id=12"`

**alt -z** : saute une ligne sur vscode.

**ctr maj bar**  ou **ctr k c** : mettre tout en commentaire

## Ce qu'il nous reste a faire:


- commentaire si besoin
- faire le rapport
- faire une recherche active des bugs possibles
- refaire index ?
