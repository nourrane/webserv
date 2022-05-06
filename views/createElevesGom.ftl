<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

 <h1>Espace de gommettes des élèves</h1>
    <p>Espace ajout une gommette a un élève</p>
        <form action="/elevesGom/create" method="post">

        <div>Identifiant de l'élève :</div>
        <input type="text" name="idEleve" required/>
        <br/><br/>
        <div>Identifiant de la gommette :</div>
        <input type="text" name="idGom" required/>
        <br/><br/>
        <div>Date :</div>
        <input type="text" name="date" required/>
        <br/><br/>
        <div>Motif :</div>
        <textarea type="text" name="motif" required/>
        </textarea>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    <a href="/elevesGom"> Retour à la page précédente</a> <br/>

</body>

</html>